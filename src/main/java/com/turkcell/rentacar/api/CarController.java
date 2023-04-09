package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarController {
    ResponseEntity<Void> createCar(CarCreateRequest carCreateRequest);
    ResponseEntity<CarResponse> getCarById(Long id);
    ResponseEntity<List<CarResponse>> getCars(boolean includeMaintenance);
    ResponseEntity<Void> deleteCarById(Long id);
    ResponseEntity<Void> updateCar(Long id, CarUpdateRequest carUpdateRequest);



}
