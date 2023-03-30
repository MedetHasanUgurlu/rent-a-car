package com.turkcell.rentacar.controller;

import com.turkcell.rentacar.business.dto.request.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.request.ModelCreateRequest;
import com.turkcell.rentacar.business.dto.request.ModelUpdateRequest;
import com.turkcell.rentacar.business.dto.response.BrandResponse;
import com.turkcell.rentacar.business.dto.response.ModelResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ModelController {
    ResponseEntity createModel(ModelCreateRequest request);
    ResponseEntity<ModelResponse> getModelById(Long id);
    ResponseEntity<List<ModelResponse>> getBrands();
    ResponseEntity updateModel(Long id, ModelUpdateRequest modelUpdateRequest);
    ResponseEntity deleteModelById(Long id);
}
