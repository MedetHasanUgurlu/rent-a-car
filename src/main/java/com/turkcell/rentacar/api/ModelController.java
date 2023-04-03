package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.ModelCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.ModelUpdateRequest;
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
