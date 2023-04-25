package com.turkcell.rentacar.business.dto.response.abstracts;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandResponse {
    private int id;
    private String name;
}
