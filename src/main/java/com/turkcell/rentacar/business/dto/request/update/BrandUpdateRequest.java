package com.turkcell.rentacar.business.dto.request.update;

import com.turkcell.rentacar.business.dto.request.abstracts.BrandRequest;
import com.turkcell.rentacar.common.constants.ValidationConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BrandUpdateRequest implements BrandRequest {

    @NotEmpty(message = ValidationConstants.Brand.NAME_CAN_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstants.Brand.NAME_CAN_NOT_BE_NULL)
    private String name;
}
