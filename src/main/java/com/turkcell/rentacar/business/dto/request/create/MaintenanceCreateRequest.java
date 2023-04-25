package com.turkcell.rentacar.business.dto.request.create;

import com.turkcell.rentacar.business.dto.request.abstracts.MaintenanceRequest;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MaintenanceCreateRequest implements MaintenanceRequest {

    private String complaint;
    private double price;
    private Long carId;


}
