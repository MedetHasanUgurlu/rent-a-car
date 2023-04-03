package com.turkcell.rentacar.business.dto.request.create;

import com.turkcell.rentacar.business.dto.request.abstracts.ModelRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelCreateRequest extends ModelRequest {

    private String name;
    private Long brandId;
}
