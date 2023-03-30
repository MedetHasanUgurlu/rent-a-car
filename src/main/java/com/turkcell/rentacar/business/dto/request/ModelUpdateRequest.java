package com.turkcell.rentacar.business.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelUpdateRequest extends ModelRequest{
    private String name;
}
