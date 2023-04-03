package com.turkcell.rentacar.business.dto.response.getall;

import com.turkcell.rentacar.business.dto.response.MaintenanceResponse;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MaintenanceGetAllResponse extends MaintenanceResponse {
    private Long id;
    private Date entryDate;
    private Date exitDate;
    private String complaint;
    private double price;
    private boolean isPaid;
    private boolean isRepaired;
    private Long carId;
}
