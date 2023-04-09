package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.ModelService;
import com.turkcell.rentacar.business.dto.request.create.ModelCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.ModelUpdateRequest;
import com.turkcell.rentacar.business.dto.response.ModelResponse;
import com.turkcell.rentacar.entity.Model;
import com.turkcell.rentacar.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImp implements ModelService{
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;


    @Override
    public void createModel(ModelCreateRequest modelCreateRequest) {
        Model model = modelMapper.map(modelCreateRequest, Model.class);
        model.setId(0l);
        modelRepository.save(model);


    }

    @Override
    public ModelResponse getModelById(Long id) {
        return modelMapper.map(modelRepository.findById(id).orElseThrow(), ModelResponse.class);
    }

    @Override
    public List<ModelResponse> getModels() {
        return modelRepository.findAll().stream().map(model -> modelMapper.map(model, ModelResponse.class)).toList();
    }

    @Override
    public void updateModel(Long id, ModelUpdateRequest modelUpdateRequest) {
        Model model = modelMapper.map(modelUpdateRequest,Model.class);
        model.setId(id);
        modelRepository.save(model);

    }

    @Override
    public void deleteModelById(Long id) {
        modelRepository.deleteById(id);
    }
}
