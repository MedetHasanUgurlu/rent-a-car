package com.turkcell.rentacar.business.dto.request.update;

import com.turkcell.rentacar.business.dto.request.abstracts.ModelRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelUpdateRequest extends ModelRequest {
    private String name;
}
