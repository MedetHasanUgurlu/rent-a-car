package com.turkcell.rentacar.api.impl;

import com.turkcell.rentacar.api.CarController;
import com.turkcell.rentacar.business.CarService;
import com.turkcell.rentacar.business.dto.request.CarCreateRequest;
import com.turkcell.rentacar.business.dto.request.CarUpdateRequest;
import com.turkcell.rentacar.business.dto.response.CarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarControllerImp implements CarController {
    private final CarService service;


    @Override
    @PostMapping
    public ResponseEntity createCar(@RequestBody CarCreateRequest carCreateRequest) {
        service.createCar(carCreateRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getCarById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CarResponse>> getCars() {
        return new ResponseEntity<>(service.getCars(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarById(@PathVariable Long id) {
        service.deleteCarById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity updateCar(@PathVariable Long id,@RequestBody CarUpdateRequest carUpdateRequest) {
        service.updateCar(id,carUpdateRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
}
