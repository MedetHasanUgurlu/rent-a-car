package com.turkcell.rentacar.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private String complaint;
    private double price;
    private boolean isPaid;
    private boolean isCompleted;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;



}
