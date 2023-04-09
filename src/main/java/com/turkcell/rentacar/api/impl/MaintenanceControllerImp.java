package com.turkcell.rentacar.api.impl;

import com.turkcell.rentacar.api.MaintenanceController;
import com.turkcell.rentacar.business.MaintenanceService;
import com.turkcell.rentacar.business.dto.request.create.MaintenanceCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.MaintenanceUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.MaintenanceGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.MaintenanceGetAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/maintenance")
public class MaintenanceControllerImp implements MaintenanceController {

    private final MaintenanceService maintenanceService;
    @Override
    @PostMapping
    public ResponseEntity<Void> createMaintenance(@RequestBody MaintenanceCreateRequest maintenanceCreateRequest) {
        maintenanceService.createMaintenance(maintenanceCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceGetResponse> getMaintenanceById(@PathVariable Long id) {
        return new ResponseEntity<>(maintenanceService.getMaintenanceById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MaintenanceGetAllResponse>> getAllMaintenances() {
        return new ResponseEntity<>(maintenanceService.getAllMaintenance(),HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaintenance(@PathVariable Long id) {
        maintenanceService.deleteMaintenanceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateMaintenance(@PathVariable Long id,@RequestBody MaintenanceUpdateRequest maintenanceUpdateRequest) {
        maintenanceService.updateMaintenance(id,maintenanceUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @GetMapping("/return")
    public ResponseEntity<MaintenanceGetResponse> returnCarFromMaintenance(@RequestParam(required = false) Long carId) {
        return new ResponseEntity<>(maintenanceService.returnCarFromMaintenance(carId),HttpStatus.OK);
    }
}
