package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.PaymentService;
import com.turkcell.rentacar.business.PosService;
import com.turkcell.rentacar.business.dto.request.abstracts.IPaymentRequest;
import com.turkcell.rentacar.business.dto.request.create.PaymentCreateRequest;
import com.turkcell.rentacar.common.dto.RentalPaymentCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.PaymentUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.PaymentGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.PaymentGetAllResponse;
import com.turkcell.rentacar.entity.Payment;
import com.turkcell.rentacar.core.exceptionold.exceptions.ResourceNotFoundException;
import com.turkcell.rentacar.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapper mapper;
    private final PosService posService;

    private Payment requestToEntity(IPaymentRequest request){
        return mapper.map(request,Payment.class);
    }
    private PaymentGetResponse entityToGetResponse(Payment payment){
        return mapper.map(payment,PaymentGetResponse.class);
    }
    private PaymentGetAllResponse entityToGetAllResponse(Payment payment){
        return mapper.map(payment, PaymentGetAllResponse.class);
    }
    @Override
    public void add(PaymentCreateRequest request) {
       checkCardNumberExist(request.getCardNumber());
       Payment payment = requestToEntity(request);
       payment.setId(0L);
       repository.save(payment);
    }

    @Override
    public PaymentGetResponse findById(Long id) {
        checkExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<PaymentGetAllResponse> getAll() {
        return repository.findAll().stream().map(payment -> entityToGetAllResponse(payment)).toList();
    }

    @Override
    public void delete(Long id) {
        checkExist(id);
        repository.deleteById(id);
    }

    @Override
    public void update(Long id, PaymentUpdateRequest request) {
        checkExist(id);
        Payment payment = requestToEntity(request);
        payment.setId(id);
        repository.save(payment);
    }

    @Override
    public void payRent(RentalPaymentCreateRequest request) {
        checkCardValid(request);
        Payment payment = repository.findByCardNumber(request.getCardNumber());
        checkAmountEnough(request.getPrice(), payment.getBalance());
        posService.pay();
        payment.setBalance(payment.getBalance()-request.getPrice());
        repository.save(payment);
    }
    private void checkCardNumberExist(String cardNumber){
        if(repository.existsByCardNumber(cardNumber)){
            throw new RuntimeException("CardNumber has already exist.");
        }
    }
    private void checkExist(Long id){
        if(repository.findById(id).isEmpty()){
            //throw new ResourceNotFoundException("Payment",id);
        }
    }
    private void checkCardValid(RentalPaymentCreateRequest request){
        if(!repository.existsByCardNumberAndAndCardHolderAndAndCvvAndExpreationMonthAndExpreationYear(
                request.getCardNumber(), request.getCardHolder(), request.getCvv(), request.getExpreationMonth(), request.getExpreationYear()
        )){
            //throw new ResourceNotFoundException("Payment",Long.valueOf(request.getCardNumber()));
        }
    }
    private void checkAmountEnough(double price,double balance){
        if(price>balance){
            throw new RuntimeException("Balance is not enough.");
        }
    }
}
