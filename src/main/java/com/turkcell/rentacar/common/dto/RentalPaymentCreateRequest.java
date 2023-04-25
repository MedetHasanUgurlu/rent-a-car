package com.turkcell.rentacar.common.dto;

import com.turkcell.rentacar.business.dto.request.abstracts.PaymentRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class RentalPaymentCreateRequest extends PaymentRequest {
    private double price;
}
