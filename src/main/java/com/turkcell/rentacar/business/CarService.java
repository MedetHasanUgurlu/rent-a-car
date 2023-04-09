package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.create.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import com.turkcell.rentacar.entity.enums.State;

import java.util.List;
public interface CarService {
    void createCar(CarCreateRequest carCreateRequest);
    CarResponse getCarById(Long id);
    List<CarResponse> getCars(boolean includeMaintenance);
    void updateCar(Long id, CarUpdateRequest carUpdateRequest);
    void deleteCarById(Long id);
    void changeStatus(Long id, State state);
}
