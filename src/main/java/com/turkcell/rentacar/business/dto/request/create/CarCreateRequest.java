package com.turkcell.rentacar.business.dto.request.create;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarCreateRequest {
    private Long modelId;
    private int modelYear;
    private String plate;
    private double dailyPrice;

}
