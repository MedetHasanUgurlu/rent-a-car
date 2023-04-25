package com.turkcell.rentacar.api.impl;

import com.turkcell.rentacar.api.PaymentController;
import com.turkcell.rentacar.business.PaymentService;
import com.turkcell.rentacar.business.dto.request.create.PaymentCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.PaymentUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.PaymentGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.PaymentGetAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentControllerImp implements PaymentController {
    private final PaymentService service;
    @Override
    @PostMapping
    public ResponseEntity<Void> createPayment(@RequestBody PaymentCreateRequest request) {
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PaymentGetResponse> getPaymentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<PaymentGetAllResponse>> getAllPayments() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePayment(@PathVariable Long id,@RequestBody PaymentUpdateRequest request) {
        service.update(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
