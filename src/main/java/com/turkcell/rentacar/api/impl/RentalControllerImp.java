package com.turkcell.rentacar.api.impl;

import com.turkcell.rentacar.api.RentalController;
import com.turkcell.rentacar.business.RentalService;
import com.turkcell.rentacar.business.dto.request.create.RentalCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.RentalUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.RentalGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.RentalGetAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/rental")
public class RentalControllerImp implements RentalController {
    private final RentalService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> createRental(@RequestBody RentalCreateRequest request) {
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RentalGetResponse> getRentalById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);

    }

    @Override
    @GetMapping
    public ResponseEntity<List<RentalGetAllResponse>> getAllRentals() {
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRental(@PathVariable Long id,@RequestBody RentalUpdateRequest request) {
        service.updateById(id,request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/return")
    public ResponseEntity<RentalGetResponse> returnCarFromRental(@RequestParam Long carId) {
        return new ResponseEntity<>(service.returnToHome(carId),HttpStatus.OK);
    }
}
