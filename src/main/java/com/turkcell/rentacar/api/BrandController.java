package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.BrandCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.BrandUpdateRequest;
import com.turkcell.rentacar.business.dto.response.abstracts.BrandResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface BrandController {
    ResponseEntity<Void> createBrand(BrandCreateRequest request);
    ResponseEntity<BrandResponse> getBrandById(Long id);
    ResponseEntity<List<BrandResponse>> getBrands();
    ResponseEntity<Void> updateBrand(Long id, BrandUpdateRequest brandUpdateRequest);
    ResponseEntity<Void> deleteBrandById(Long id);

}
