package com.turkcell.rentacar.business.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelResponse {
    private Long id;
    private String name;
    private Long brandId;
}
