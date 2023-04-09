package com.turkcell.rentacar.business.impl;

import com.sun.jdi.request.InvalidRequestStateException;
import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.RentalService;
import com.turkcell.rentacar.business.dto.request.abstracts.RentalRequest;
import com.turkcell.rentacar.business.dto.request.create.RentalCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.RentalUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.RentalGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.RentalGetAllResponse;
import com.turkcell.rentacar.entity.Rental;
import com.turkcell.rentacar.entity.enums.State;
import com.turkcell.rentacar.exception.exceptions.ResourceNotFoundException;
import com.turkcell.rentacar.repository.RentalRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository repository;
    private final ModelMapper modelMapper;
    private final CarService carService;

    Rental requestToEntity(RentalRequest rentalRequest){
        return modelMapper.map(rentalRequest,Rental.class);
    }
    RentalGetResponse entityToGetResponse(Rental rental){
        return modelMapper.map(rental,RentalGetResponse.class);
    }
    RentalGetAllResponse entityToGetAllResponse(Rental rental){
        return modelMapper.map(rental, RentalGetAllResponse.class);
    }
    @Override
    public void add(RentalCreateRequest request) {
        checkCarForAvailable(request.getCarId());
        Rental rental = requestToEntity(request);
        rental.setId(0l);
        rental.setStartDate(LocalDateTime.now());
        rental.setTotalPrice(rental.getDailyPrice()*rental.getRentedDays());
        carService.changeStatus(request.getCarId(),State.RENTED);
        repository.save(rental);
    }

    @Override
    public RentalGetResponse getById(Long id) {
        checkRentalExist(id);
        return entityToGetResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(Long id) {
        checkRentalExist(id);
        Rental rental = repository.findById(id).orElseThrow();
        Long carId = rental.getCar().getId();
        forDeleteProcess(carId);
        repository.deleteById(id);
    }

    @Override
    public void updateById(Long id, RentalUpdateRequest request) {
        checkRentalExist(id);
        Rental rental = requestToEntity(request);
        rental.setId(id);
        rental.setTotalPrice(rental.getTotalPrice());
        repository.save(rental);
    }

    @Override
    public List<RentalGetAllResponse> getAll() {
        return repository.findAll().stream().map(rental -> entityToGetAllResponse(rental)).toList();
    }

    @Override
    public RentalGetResponse returnToHome(Long carId) {
        checkCarIdExist(carId);
        checkForReturn(carId);
        Rental rental = repository.findByCarId(carId);
        carService.changeStatus(carId,State.AVAILABLE);
        return entityToGetResponse(rental);
    }

    private void checkRentalExist(Long id){
        if (!repository.findById(id).isPresent()) {
            throw new ResourceNotFoundException("Rental",id);
        }
    }
    private void checkCarIdExist(Long carId){
        if(!repository.existsByCarId(carId)){
            throw new ResourceNotFoundException("Rental",carId);
        }
    }
    private void checkCarForAvailable(Long carId){
        if(carService.getCarById(carId).getState() != State.AVAILABLE){
            throw new ResourceNotFoundException("Car",carId);
        }
    }
    private void forDeleteProcess(Long carId){
        if(carService.getCarById(carId).getState() == State.RENTED){
            carService.changeStatus(carId,State.AVAILABLE);
        }
    }
    private void checkForReturn(Long carId){
        if(carService.getCarById(carId).getState() == State.MAINTENANCE){
            throw new InvalidRequestStateException(String.format("[Can not return Home]->Id:%s car already is maintenance.",carId));
        }
        if(carService.getCarById(carId).getState() == State.AVAILABLE){
            throw new InvalidRequestStateException(String.format("[Can not return Home]->Id:%s car already is Available.",carId));
        }
    }


}
