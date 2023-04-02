package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.CarStateRequest;
import com.turkcell.rentacar.business.dto.request.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CarController {
    ResponseEntity createCar(CarCreateRequest carCreateRequest);
    ResponseEntity<CarResponse> getCarById(Long id);
    ResponseEntity<List<CarResponse>> getCars();
    ResponseEntity deleteCarById(Long id);
    ResponseEntity updateCar(Long id, CarUpdateRequest carUpdateRequest);
    ResponseEntity<List<CarResponse>> getCarsByMaintenance(String state);
    ResponseEntity sendToMaintenance(Long id);
    ResponseEntity<List<CarResponse>> getCarsByStateCondition(Boolean isClicked);

}
