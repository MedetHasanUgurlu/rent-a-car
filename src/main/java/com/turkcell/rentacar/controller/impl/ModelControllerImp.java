package com.turkcell.rentacar.controller.impl;

import com.turkcell.rentacar.business.ModelService;
import com.turkcell.rentacar.business.dto.request.ModelCreateRequest;
import com.turkcell.rentacar.business.dto.request.ModelUpdateRequest;
import com.turkcell.rentacar.business.dto.response.ModelResponse;
import com.turkcell.rentacar.controller.ModelController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/models")
public class ModelControllerImp implements ModelController {
    private final ModelService service;
    @Override
    @PostMapping
    public ResponseEntity createModel(@RequestBody ModelCreateRequest request) {
        service.createModel(request);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ModelResponse> getModelById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getModelById(id),HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ModelResponse>> getBrands() {
        return new ResponseEntity<>(service.getModels(),HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity updateModel(@PathVariable Long id,@RequestBody ModelUpdateRequest modelUpdateRequest) {
        service.updateModel(id, modelUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity deleteModelById(@PathVariable Long id) {
        service.deleteModelById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
