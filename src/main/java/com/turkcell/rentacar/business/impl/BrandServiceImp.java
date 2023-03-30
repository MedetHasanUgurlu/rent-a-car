package com.turkcell.rentacar.business.impl;

import com.turkcell.rentacar.business.BrandService;
import com.turkcell.rentacar.business.dto.request.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.BrandRequest;
import com.turkcell.rentacar.business.dto.request.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.response.BrandResponse;
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

    public Brand requestToEntity(BrandRequest brandRequest){
        return modelMapper.map(brandRequest,Brand.class);
    }
    public BrandResponse entityToResponse(Brand brand){
        return modelMapper.map(brand,BrandResponse.class);
    }


    @Override
    public void createBrand(BrandCreateRequest request) {
        repository.save(requestToEntity(request));
    }

    @Override
    public BrandResponse getBrand(Long id) {
        return entityToResponse(repository.findById(id).orElseThrow());
    }

    @Override
    public List<BrandResponse> getBrands() {
        List<Brand> brands = repository.findAll();
        List<BrandResponse> responses = brands.stream().map(brand -> entityToResponse(brand)).toList();
        return responses;
    }

    @Override
    public void updateBrand(Long id, BrandUpdateRequest brandUpdateRequest) {
        Brand brand = repository.findById(id).orElseThrow();
        brand.setName(brandUpdateRequest.getName());
        repository.save(brand);
    }

    @Override
    public void deleteBrand(Long id) {
        repository.deleteById(id);
    }
}
