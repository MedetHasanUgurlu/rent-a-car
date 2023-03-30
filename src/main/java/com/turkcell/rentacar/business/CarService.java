package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import java.util.List;
public interface CarService {
    void createCar(CarCreateRequest carCreateRequest);
    CarResponse getCarById(Long id);
    List<CarResponse> getCars();
    void updateCar(Long id, CarUpdateRequest carUpdateRequest);
    void deleteCarById(Long id);
}
