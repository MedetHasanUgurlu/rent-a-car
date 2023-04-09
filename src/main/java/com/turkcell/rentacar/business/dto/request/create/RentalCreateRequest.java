package com.turkcell.rentacar.business.dto.request.create;


import com.turkcell.rentacar.business.dto.request.abstracts.RentalRequest;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentalCreateRequest extends RentalRequest {

    private Long  carId;
    private double dailyPrice;
    private int rentedDays;


}