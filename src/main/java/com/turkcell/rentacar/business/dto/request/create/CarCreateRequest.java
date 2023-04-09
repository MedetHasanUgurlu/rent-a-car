package com.turkcell.rentacar.business.dto.request.create;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarCreateRequest {

    private int modelYear;
    private String plate;
    private double dailyPrice;
    private Long modelId;
}
