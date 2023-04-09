package com.turkcell.rentacar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

// TODO:
//  1. Araçlar kiralanabilmelidir (rental).
//  2. Kiraya gönderilen aracın durumu güncellenmelidir.
//  3. Kirada veya bakımda olan bir araç kiralanamamalı.
//  4. totalPrice alanı sadece okunabilmelidir.
//  5. Kiradan dönen aracın durumu (rental delete işlemi ile) güncellenmelidir.

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "rentals")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double dailyPrice;
    private int rentedDays;
    private double totalPrice;
    private LocalDateTime startDate;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
