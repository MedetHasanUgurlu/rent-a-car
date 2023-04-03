package com.turkcell.rentacar.business.dto.response.get;

import com.turkcell.rentacar.business.dto.response.MaintenanceResponse;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MaintenanceGetResponse extends MaintenanceResponse {
    private Long id;
    private Date entryDate;
    private Date exitDate;
    private String complaint;
    private double price;
    private boolean isPaid;
    private boolean isRepaired;
    private Long carId;
}
