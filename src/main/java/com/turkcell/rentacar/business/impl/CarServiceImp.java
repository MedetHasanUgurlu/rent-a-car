package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.dto.request.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import com.turkcell.rentacar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService {
    private final ModelMapper modelMapper;
    private final CarRepository repository;
    @Override
    public void createCar(CarCreateRequest carCreateRequest) {

    }

    @Override
    public CarResponse getCarById(Long id) {
        return null;
    }

    @Override
    public List<CarResponse> getCars() {
        return null;
    }

    @Override
    public void updateCar(Long id, CarUpdateRequest carUpdateRequest) {

    }

    @Override
    public void deleteCarById(Long id) {

    }
}
