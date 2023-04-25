package com.turkcell.rentacar.business.dto.request.abstracts;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequest {

    private String cardNumber;
    private String cardHolder;
    private int expreationYear;
    private int expreationMonth;
    private String cvv;

}
