package com.turkcell.rentacar.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "brands")
public class Brand
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "brand")
    @JsonBackReference
    private List<Model> modelList;



}

/*
* Arabalar bakıma (maintenance) gönderilebilmelidir.
* Bakımdan gelen araba yeniden kiralanabilir duruma gelmelidir.
* Zaten bakımda olan araba bakıma gönderilememez.
* Kirada olan araba bakıma gönderilemez.
* Bakımda olan araba araba listesinde görüntülenip görüntülenmeyeceğine kullanıcıdan bir parametre alarak gelmelidir veya gelmemelidir. */