package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.common.constants.Messages;
import com.turkcell.rentacar.core.exceptionnew.exceptions.BusinessException;
import com.turkcell.rentacar.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository repository;
    public void checkBrandNameExist(String name){
        if(repository.existsByNameIgnoreCase(name)){
            throw new BusinessException(Messages.Brand.Exists);
        }
    }

    public void checkEntityExist(Long id){
        if(repository.findById(id).isEmpty()){
            throw new BusinessException(Messages.Brand.NotExists);
        }
    }
}
