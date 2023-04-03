package com.turkcell.rentacar.business.dto.request.update;

import com.turkcell.rentacar.business.dto.request.abstracts.BrandRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandUpdateRequest extends BrandRequest {
    private String name;
}
