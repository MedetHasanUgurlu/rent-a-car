package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.common.constants.Messages;
import com.turkcell.rentacar.core.exceptionnew.exceptions.BusinessException;
import com.turkcell.rentacar.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;

    public void checkModelNameExist(String name){
        if(repository.existsByNameIgnoreCase(name)){
            throw new BusinessException(Messages.Model.Exists);
        }
    }
    public void checkEntityExist(Long id){
        if(repository.findById(id).isEmpty()){
            throw new BusinessException(Messages.Model.NotExists);
        }
    }

}
