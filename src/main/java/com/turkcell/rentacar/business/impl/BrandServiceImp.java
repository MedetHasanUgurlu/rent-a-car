package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.BrandService;
import com.turkcell.rentacar.business.dto.request.create.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.abstracts.BrandRequest;
import com.turkcell.rentacar.business.dto.request.update.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.response.abstracts.BrandResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.common.constants.Messages;
import com.turkcell.rentacar.core.exceptionnew.exceptions.BusinessException;
import com.turkcell.rentacar.entity.Brand;
import com.turkcell.rentacar.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImp implements BrandService {
    private final BrandRepository repository;
    private final ModelMapper modelMapper;
    private final BrandBusinessRules rules;

    public Brand requestToEntity(BrandRequest brandRequest){
        return modelMapper.map(brandRequest,Brand.class);
    }
    public BrandResponse entityToResponse(Brand brand){
        return modelMapper.map(brand,BrandResponse.class);
    }


    @Override
    public void createBrand(BrandCreateRequest request) {
        rules.checkBrandNameExist(request.getName());
        repository.save(requestToEntity(request));
    }

    @Override
    public BrandResponse getBrand(Long id) {
        return entityToResponse(repository.findById(id).orElseThrow(()->new BusinessException(Messages.Brand.NotExists)));
    }

    @Override
    public List<BrandResponse> getBrands() {
        List<Brand> brands = repository.findAll();
        return brands.stream().map(this::entityToResponse).toList();

    }

    @Override
    public void updateBrand(Long id, BrandUpdateRequest brandUpdateRequest) {
        Brand brand = repository.findById(id).orElseThrow();
        brand.setName(brandUpdateRequest.getName());
        repository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        rules.checkEntityExist(id);
        repository.deleteById(id);
    }
}
