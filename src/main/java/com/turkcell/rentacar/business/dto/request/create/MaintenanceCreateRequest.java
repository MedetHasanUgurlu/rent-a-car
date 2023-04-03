package com.turkcell.rentacar.business.dto.request.create;

import com.turkcell.rentacar.business.dto.request.abstracts.MaintenanceRequest;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MaintenanceCreateRequest extends MaintenanceRequest {

    private String complaint;
    private double price;
    private boolean isPaid = false;
    private Long carId;
    @CreatedDate
    private Date entryDate;

}
