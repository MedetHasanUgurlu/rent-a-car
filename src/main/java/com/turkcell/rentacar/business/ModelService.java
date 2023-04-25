package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.create.ModelCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.ModelUpdateRequest;
import com.turkcell.rentacar.business.dto.response.abstracts.ModelResponse;

import java.util.List;

public interface ModelService {
    void createModel(ModelCreateRequest modelCreateRequest);
    ModelResponse getModelById(Long id);
    List<ModelResponse> getModels();
    void updateModel(Long id, ModelUpdateRequest modelUpdateRequest);
    void deleteModelById(Long id);


}
