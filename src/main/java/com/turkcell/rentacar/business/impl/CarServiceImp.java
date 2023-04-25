package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.dto.request.create.CarCreateRequest;

import com.turkcell.rentacar.business.dto.request.update.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.abstracts.CarResponse;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.entity.Car;
import com.turkcell.rentacar.entity.enums.State;
import com.turkcell.rentacar.core.exceptionold.exceptions.ResourceNotFoundException;
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
    private final CarBusinessRules rules;
    @Override
    public void createCar(CarCreateRequest carCreateRequest) {
        Car car = modelMapper.map(carCreateRequest,Car.class);
        car.setState(State.AVAILABLE);
        car.setId(0L);
        repository.save(car);
    }

    @Override
    public CarResponse getCarById(Long id) {
        rules.checkEntityExist(id);
        return modelMapper.map(repository.findById(id).orElseThrow(),CarResponse.class);
    }

    @Override
    public List<CarResponse> getCars(boolean includeMaintenance) {
        if(!includeMaintenance){
            return repository.findAllByStateIsNot(State.MAINTENANCE).stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
        }
        return repository.findAll().stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
    }

    @Override
    public void updateCar(Long id, CarUpdateRequest carUpdateRequest) {
        rules.checkEntityExist(id);
        Car car = modelMapper.map(carUpdateRequest,Car.class);
        car.setId(id);
        repository.save(car);
    }

    @Override
    public void deleteCarById(Long id) {
        rules.checkEntityExist(id);
        repository.deleteById(id);
    }

    @Override
    public void changeStatus(Long id, State state) {
        rules.checkEntityExist(id);
        Car car = repository.findById(id).orElseThrow();
        car.setId(id);
        car.setState(state);
        repository.save(car);
    }


}
