package com.turkcell.rentacar.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private Date entryDate;
    private Date exitDate;
    private String complaint;
    private double price;
    private boolean isPaid= false;
    private boolean isRepaired= false;
    @ManyToOne
    @JsonManagedReference
    private Car car;



}
