package com.turkcell.rentacar.business.impl;

import com.sun.jdi.request.InvalidRequestStateException;
import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.MaintenanceService;
import com.turkcell.rentacar.business.dto.request.update.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.request.create.MaintenanceCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.MaintenanceUpdateRequest;
import com.turkcell.rentacar.business.dto.request.abstracts.MaintenanceRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import com.turkcell.rentacar.business.dto.response.getall.MaintenanceGetAllResponse;
import com.turkcell.rentacar.business.dto.response.get.MaintenanceGetResponse;
import com.turkcell.rentacar.entity.Car;
import com.turkcell.rentacar.entity.Maintenance;
import com.turkcell.rentacar.entity.enums.State;
import com.turkcell.rentacar.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImp implements MaintenanceService {

    private final MaintenanceRepository repository;
    private final CarService carService;
    private final ModelMapper modelMapper;

    Maintenance requestToEntity(MaintenanceRequest maintenanceRequest){
        return modelMapper.map(maintenanceRequest,Maintenance.class);
    }
    MaintenanceGetResponse entityToGetResponse(Maintenance maintenance){
        return modelMapper.map(maintenance,MaintenanceGetResponse.class);
    }
    MaintenanceGetAllResponse entityToGetAllResponse(Maintenance maintenance){
        return modelMapper.map(maintenance,MaintenanceGetAllResponse.class);
    }

    @Override
    public void createMaintenance(MaintenanceCreateRequest maintenanceCreateRequest) {
        Maintenance maintenance = requestToEntity(maintenanceCreateRequest);
        maintenance.setId(0l);
        CarResponse carResponse = carService.getCarById(maintenanceCreateRequest.getCarId());
        checkCreateMaintenance(carResponse);
        carResponse.setState(State.MAINTENANCE);
        CarUpdateRequest carUpdateRequest = modelMapper.map(carResponse,CarUpdateRequest.class);
        carService.updateCar(maintenanceCreateRequest.getCarId(), carUpdateRequest);
        repository.save(maintenance);
    }

    @Override
    public MaintenanceGetResponse getMaintenanceById(Long id) {
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<MaintenanceGetAllResponse> getAllMaintenance() {
        return repository.findAll().stream().map(maintenance -> entityToGetAllResponse(maintenance)).toList();
    }

    @Override
    public void updateMaintenance(Long id, MaintenanceUpdateRequest request) {
        Maintenance maintenance = requestToEntity(request);
        if(request.isRepaired()){
            CarResponse carResponse = carService.getCarById(request.getCarId());
            carResponse.setState(State.AVAILABLE);
            CarUpdateRequest carUpdateRequest = modelMapper.map(carResponse,CarUpdateRequest.class);
            carService.updateCar(request.getCarId(),carUpdateRequest);
        }
        maintenance.setId(id);
        repository.save(maintenance);
    }

    @Override
    public void deleteMaintenanceById(Long id) {
        Maintenance maintenance = repository.findById(id).orElseThrow();
        CarResponse carResponse = carService.getCarById(maintenance.getCar().getId());
        Car car = modelMapper.map(carResponse,Car.class);
        car.setState(State.AVAILABLE);
        CarUpdateRequest carUpdateRequest = modelMapper.map(car,CarUpdateRequest.class);
        carService.updateCar(car.getId(),carUpdateRequest);
        repository.deleteById(id);

    }

    void checkCreateMaintenance(CarResponse carResponse){
        checkCarInMaintenance(carResponse);
        checkCarIsRented(carResponse);

    }
    void checkCarInMaintenance(CarResponse carResponse){
        if(carResponse.getState()== State.MAINTENANCE){
            throw new InvalidRequestStateException(String.format("Id:%s car already in maintenance.",carResponse.getId()));
        }
    }
    void checkCarIsRented(CarResponse car){
        if(car.getState()== State.RENTED){
            throw new InvalidRequestStateException(String.format("Id:%s car already is rented.",car.getId()));
        }
    }
    void checkCarIsExist(){

    }


}
