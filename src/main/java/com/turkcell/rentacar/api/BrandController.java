package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.response.BrandResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface BrandController {
    ResponseEntity createBrand(BrandCreateRequest request);
    ResponseEntity<BrandResponse> getBrandById(Long id);
    ResponseEntity<List<BrandResponse>> getBrands();
    ResponseEntity updateBrand(Long id, BrandUpdateRequest brandUpdateRequest);
    ResponseEntity deleteBrandById(Long id);

}
