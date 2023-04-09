package com.turkcell.rentacar.business.dto.response.get;

import com.turkcell.rentacar.business.dto.response.MaintenanceResponse;
import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MaintenanceGetResponse extends MaintenanceResponse {
    private Long id;
    private String complaint;
    private double price;
    private boolean isPaid;
    private Long carId;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private boolean isCompleted;
}
