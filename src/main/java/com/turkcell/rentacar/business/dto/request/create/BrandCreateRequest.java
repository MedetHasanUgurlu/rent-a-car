package com.turkcell.rentacar.business.dto.request.create;

import com.turkcell.rentacar.business.dto.request.abstracts.BrandRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandCreateRequest extends BrandRequest {
    private String name;
}
