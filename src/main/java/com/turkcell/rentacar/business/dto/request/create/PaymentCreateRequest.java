package com.turkcell.rentacar.business.dto.request.create;

import com.turkcell.rentacar.business.dto.request.abstracts.IPaymentRequest;
import com.turkcell.rentacar.business.dto.request.abstracts.PaymentRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PaymentCreateRequest extends PaymentRequest implements IPaymentRequest {
    private double balance;
}
