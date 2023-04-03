package com.turkcell.rentacar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Model model;
    @OneToMany(mappedBy = "car")
    @JsonBackReference
    private List<Maintenance> maintenances;

}
