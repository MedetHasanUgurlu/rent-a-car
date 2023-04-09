package com.turkcell.rentacar.repository;

import com.turkcell.rentacar.entity.Car;
import com.turkcell.rentacar.entity.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByStateIsNot(State state);

}
