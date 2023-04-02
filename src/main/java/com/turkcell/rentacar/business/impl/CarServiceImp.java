package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.dto.request.CarCreateRequest;

import com.turkcell.rentacar.business.dto.request.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import com.turkcell.rentacar.entity.Car;
import com.turkcell.rentacar.entity.enums.State;
import com.turkcell.rentacar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService {
    private final ModelMapper modelMapper;
    private final CarRepository repository;
    @Override
    public void createCar(CarCreateRequest carCreateRequest) {
        Car car = modelMapper.map(carCreateRequest,Car.class);
        car.setId(0l);
        repository.save(car);
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

    @Override
    public List<CarResponse> findByState(String state) {
        List<Car> cars = repository.findAll();
        List<Car> response = new ArrayList<>();
        if(state.equalsIgnoreCase("AVAILABLE")){

            return response.stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
        }else if(state.equalsIgnoreCase("RENTED")){

            for (Car car : cars) {
                if(car.getState().name().equals("RENTED")){
                    response.add(car);
                }

            }
            return response.stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
        }else{

            for (Car car : cars) {
                if(car.getState().name().equals("MAINTANCE")){
                    response.add(car);
                }

            }
            return response.stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
        }



    }

    @Override
    public void sentToMaintance(Long id) {
        Car car = repository.findById(id).orElseThrow();

        if (car.getState() == State.RENTED  ) {
            throw new RuntimeException("Car already has rented so you can not sent maintance");
        }else if(car.getState() == State.MAINTENANCE){
            throw new RuntimeException("Car already has maintanced");
        }

        car.setState(State.MAINTENANCE);
        repository.save(car);
    }

    @Override
    public List<CarResponse> getCarsInRentedOrAvailable() {
        return repository.stateRentedOrAvailable().stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
    }

    @Override
    public List<CarResponse> getCarsByStateCondition(Boolean isClicked) {
        if(isClicked){
            return repository.stateRentedOrAvailable().stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
        }
        return repository.findAll().stream().map(car -> modelMapper.map(car,CarResponse.class)).toList();
    }
}
