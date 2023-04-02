package com.turkcell.rentacar.repository;

import com.turkcell.rentacar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    //List<Car> getCarsByState_AvailableAndState_Rented();
    @Query("select c from Car c where c.state='RENTED' or c.state= 'AVAILABLE'")
    List<Car> stateRentedOrAvailable();

    @Query("select c from Car c where c.state='MAINTENANCE'")
    List<Car> stateMaıntenance();

}
