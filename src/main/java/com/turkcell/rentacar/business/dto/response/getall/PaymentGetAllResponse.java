package com.turkcell.rentacar.business.dto.response.getall;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentGetAllResponse {
    private Long id;
    private String cardNumber;
    private String cardHolder;
    private int expreationYear;
    private int expreationMonth;
    private String cvv;
    private double balance;
}
