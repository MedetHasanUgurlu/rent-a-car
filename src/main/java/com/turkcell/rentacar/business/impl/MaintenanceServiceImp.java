package com.turkcell.rentacar.business.impl;

import com.sun.jdi.request.InvalidRequestStateException;
import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.MaintenanceService;
import com.turkcell.rentacar.business.dto.request.create.MaintenanceCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.MaintenanceUpdateRequest;
import com.turkcell.rentacar.business.dto.request.abstracts.MaintenanceRequest;
import com.turkcell.rentacar.business.dto.response.getall.MaintenanceGetAllResponse;
import com.turkcell.rentacar.business.dto.response.get.MaintenanceGetResponse;
import com.turkcell.rentacar.entity.Maintenance;
import com.turkcell.rentacar.entity.enums.State;
import com.turkcell.rentacar.exception.exceptions.ResourceNotFoundException;
import com.turkcell.rentacar.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public void createMaintenance(MaintenanceCreateRequest request) {
        checkCarAvailableForMaintenance(request.getCarId());
        Maintenance maintenance = requestToEntity(request);
        maintenance.setId(0l);
        maintenance.setEntryDate(LocalDateTime.now());
        maintenance.setPaid(false);
        carService.changeStatus(request.getCarId(),State.MAINTENANCE);
        repository.save(maintenance);
    }

    @Override
    public MaintenanceGetResponse getMaintenanceById(Long id) {
        checkMaintenanceExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<MaintenanceGetAllResponse> getAllMaintenance() {
        return repository.findAll().stream().map(this::entityToGetAllResponse).toList();
    }

    @Override
    public void updateMaintenance(Long id, MaintenanceUpdateRequest request) {
        checkMaintenanceExist(id);
        Maintenance maintenance = requestToEntity(request);
        maintenance.setId(id);
        repository.save(maintenance);
    }

    @Override
    public void deleteMaintenanceById(Long id) {
        checkMaintenanceExist(id);
        beforeDelete(id);
        repository.deleteById(id);

    }

    @Override
    public MaintenanceGetResponse returnCarFromMaintenance(Long carId) {
        checkCarForReturn(carId);
        Maintenance maintenance = repository.findMaintenanceByCarIdAndIsCompletedFalse(carId);
        maintenance.setCompleted(true);
        maintenance.setPaid(true);
        maintenance.setExitDate(LocalDateTime.now());
        repository.save(maintenance);
        carService.changeStatus(carId,State.AVAILABLE);
        return entityToGetResponse(maintenance);
    }



    void checkMaintenanceExist(Long id){
        if(!repository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Maintenance",id);
        }
    }

    public void checkCarAvailableForMaintenance(Long carId){
        if(carService.getCarById(carId).getState()==State.RENTED){
            throw new InvalidRequestStateException(String.format("[Can not go maintenance]->Id:%s car already is rented.",carId));
        }else if(carService.getCarById(carId).getState()==State.MAINTENANCE) {
            throw new InvalidRequestStateException(String.format("[Can not go maintenance]->Id:%s car already is maintenance.",carId));
        }
    }
    public void checkCarForReturn(Long carId){
        if(!repository.existsByCarIdAndIsCompletedIsFalse(carId)){
            throw new ResourceNotFoundException("Maintenance",carId);
        }
    }
    public void beforeDelete(Long id){
        Long carId = repository.findById(id).orElseThrow().getCar().getId();
        if(repository.existsByCarIdAndIsCompletedIsFalse(carId)){
            carService.changeStatus(carId,State.AVAILABLE);
        }
    }


}
