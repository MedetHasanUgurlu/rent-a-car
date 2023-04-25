package com.turkcell.rentacar.business.dto.response.get;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentGetResponse {
    private Long id;
    private String cardNumber;
    private String cardHolder;
    private int expreationYear;
    private int expreationMonth;
    private String cvv;
    private double balance;
}
