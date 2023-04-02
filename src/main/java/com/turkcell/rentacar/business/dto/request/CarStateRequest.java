package com.turkcell.rentacar.business.dto.request;

import com.turkcell.rentacar.entity.enums.State;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CarStateRequest {
    private State state;
}
