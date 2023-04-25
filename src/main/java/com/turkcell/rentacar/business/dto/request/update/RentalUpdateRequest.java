package com.turkcell.rentacar.business.dto.request.update;

import com.turkcell.rentacar.business.dto.request.abstracts.RentalRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentalUpdateRequest implements RentalRequest {

    private double dailyPrice;
    private int rentedDays;

}
