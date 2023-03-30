package com.turkcell.rentacar.business.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandCreateRequest extends BrandRequest {
    private String name;
}
