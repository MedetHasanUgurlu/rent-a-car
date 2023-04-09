package com.turkcell.rentacar.business.dto.request.update;

import com.turkcell.rentacar.business.dto.request.abstracts.MaintenanceRequest;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MaintenanceUpdateRequest extends MaintenanceRequest {

    private String complaint;
    private double price;
    private boolean isPaid;
    private boolean isRepaired;

}
