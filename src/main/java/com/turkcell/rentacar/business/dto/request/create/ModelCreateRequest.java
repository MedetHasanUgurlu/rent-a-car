package com.turkcell.rentacar.business.dto.request.create;

import com.turkcell.rentacar.business.dto.request.abstracts.ModelRequest;
import com.turkcell.rentacar.common.constants.ValidationConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ModelCreateRequest implements ModelRequest {

    @NotEmpty(message = ValidationConstants.Model.NAME_CAN_NOT_BE_EMPTY)
    @NotNull(message = ValidationConstants.Model.NAME_CAN_NOT_BE_NULL)
    private String name;

    @NotNull(message = ValidationConstants.Model.BRAND_ID_CAN_NOT_BE_NULL)
    private Long brandId;
}
