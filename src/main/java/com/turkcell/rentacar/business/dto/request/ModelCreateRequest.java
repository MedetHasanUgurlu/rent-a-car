package com.turkcell.rentacar.business.dto.request;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.turkcell.rentacar.entity.Brand;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelCreateRequest extends ModelRequest{

    private String name;
    private Long brandId;
}
