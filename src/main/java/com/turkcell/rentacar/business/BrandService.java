package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.response.BrandResponse;
import com.turkcell.rentacar.entity.Brand;

import java.util.List;

public interface BrandService {
    void createBrand(BrandCreateRequest request);
    BrandResponse getBrand(Long id);
    List<BrandResponse> getBrands();
    void updateBrand(Long id, BrandUpdateRequest brandUpdateRequest);
    void deleteBrand(Long id);


}
