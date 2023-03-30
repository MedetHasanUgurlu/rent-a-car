package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.dto.request.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import com.turkcell.rentacar.entity.Car;
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
        repository.save(modelMapper.map(carCreateRequest, Car.class));
    }

    @Override
    public CarResponse getCarById(Long id) {
        return modelMapper.map(repository.findById(id).orElseThrow(),CarResponse.class);
    }

    @Override
    public List<CarResponse> getCars() {
        return repository.findAll().stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
    }

    @Override
    public void updateCar(Long id, CarUpdateRequest carUpdateRequest) {
        Car car = modelMapper.map(carUpdateRequest,Car.class);
        car.setId(id);
        repository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        repository.deleteById(id);
    }
}
