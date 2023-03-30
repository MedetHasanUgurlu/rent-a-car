package com.turkcell.rentacar.business.dto.request;

import com.turkcell.rentacar.entity.enums.State;
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
    private State state;
    private Long modelId;
}
