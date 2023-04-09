package com.turkcell.rentacar.repository;

import com.turkcell.rentacar.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long> {


    boolean existsByCarId(Long carId);
    Rental findByCarId(Long carId);
}
