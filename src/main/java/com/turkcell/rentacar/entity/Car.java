package com.turkcell.rentacar.entity;


import com.turkcell.rentacar.entity.enums.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int modelYear;
    private String plate;
    private double dailyPrice;
    @Enumerated(EnumType.STRING)
    private State state;
    @ManyToOne
    private Model model;
    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;
    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

}
