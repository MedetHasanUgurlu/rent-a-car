package com.turkcell.rentacar.business.dto.response.getall;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RentalGetAllResponse {
    private Long id;
    private Long carId;
    private double dailyPrice;
    private int rentedDays;
    private double totalPrice;
    private LocalDateTime startDate;
}
