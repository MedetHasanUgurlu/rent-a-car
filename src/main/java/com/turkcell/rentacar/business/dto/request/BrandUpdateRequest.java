package com.turkcell.rentacar.business.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandUpdateRequest extends BrandRequest {
    private String name;
}
