package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.CarStateRequest;
import com.turkcell.rentacar.business.dto.request.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import com.turkcell.rentacar.entity.enums.State;

import java.util.List;
public interface CarService {
    void createCar(CarCreateRequest carCreateRequest);
    CarResponse getCarById(Long id);
    List<CarResponse> getCars();
    void updateCar(Long id, CarUpdateRequest carUpdateRequest);
    void deleteCarById(Long id);

    List<CarResponse> findByState(String state);
    void sentToMaintance(Long id);
    List<CarResponse> getCarsInRentedOrAvailable();
    List<CarResponse> getCarsByStateCondition(Boolean isClicked);
}
