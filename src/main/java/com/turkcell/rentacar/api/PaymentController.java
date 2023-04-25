package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.PaymentCreateRequest;
import com.turkcell.rentacar.business.dto.request.create.RentalCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.PaymentUpdateRequest;
import com.turkcell.rentacar.business.dto.request.update.RentalUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.PaymentGetResponse;
import com.turkcell.rentacar.business.dto.response.get.RentalGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.PaymentGetAllResponse;
import com.turkcell.rentacar.business.dto.response.getall.RentalGetAllResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentController {
    ResponseEntity<Void> createPayment(PaymentCreateRequest request);
    ResponseEntity<PaymentGetResponse> getPaymentById(Long id);
    ResponseEntity<List<PaymentGetAllResponse>> getAllPayments();
    ResponseEntity<Void> deletePayment(Long id);
    ResponseEntity<Void> updatePayment(Long id, PaymentUpdateRequest request);

}
