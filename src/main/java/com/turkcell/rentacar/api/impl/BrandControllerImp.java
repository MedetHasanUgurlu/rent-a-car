package com.turkcell.rentacar.api.impl;

import com.turkcell.rentacar.business.BrandService;
import com.turkcell.rentacar.business.dto.request.create.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.response.abstracts.BrandResponse;
import com.turkcell.rentacar.api.BrandController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brand")
public class BrandControllerImp implements BrandController {
    private final BrandService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> createBrand(@RequestBody @Valid BrandCreateRequest request) {
        service.createBrand(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<BrandResponse> getBrandById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getBrand(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BrandResponse>> getBrands() {
        return new ResponseEntity<>(service.getBrands(),HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBrand(@PathVariable Long id, @RequestBody @Valid BrandUpdateRequest brandUpdateRequest) {
        service.updateBrand(id,brandUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrandById(@PathVariable Long id) {
        service.deleteBrand(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
