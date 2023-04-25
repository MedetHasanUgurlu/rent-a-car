package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.create.PaymentCreateRequest;
import com.turkcell.rentacar.common.dto.RentalPaymentCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.PaymentUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.PaymentGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.PaymentGetAllResponse;

import java.util.List;

public interface PaymentService {
    void add(PaymentCreateRequest request);
    PaymentGetResponse findById(Long id);
    List<PaymentGetAllResponse> getAll();
    void delete(Long id);
    void update(Long id, PaymentUpdateRequest request);
    void payRent(RentalPaymentCreateRequest request);
}
