package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.create.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.response.abstracts.BrandResponse;

import java.util.List;

public interface BrandService {
    void createBrand(BrandCreateRequest request);
    BrandResponse getBrand(Long id);
    List<BrandResponse> getBrands();
    void updateBrand(Long id, BrandUpdateRequest brandUpdateRequest);
    void deleteBrand(Long id);


}
