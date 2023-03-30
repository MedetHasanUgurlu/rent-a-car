package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.ModelCreateRequest;
import com.turkcell.rentacar.business.dto.request.ModelUpdateRequest;
import com.turkcell.rentacar.business.dto.response.ModelResponse;

import java.util.List;

public interface ModelService {
    void createModel(ModelCreateRequest modelCreateRequest);
    ModelResponse getModelById(Long id);
    List<ModelResponse> getModels();
    void updateModel(Long id, ModelUpdateRequest modelUpdateRequest);
    void deleteModelById(Long id);
}
