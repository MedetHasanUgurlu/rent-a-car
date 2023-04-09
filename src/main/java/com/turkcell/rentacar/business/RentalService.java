package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.create.RentalCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.RentalUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.RentalGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.RentalGetAllResponse;

import java.util.List;

public interface RentalService {
    void add(RentalCreateRequest rentalCreateRequest);
    RentalGetResponse getById(Long id);
    void deleteById(Long id);
    void updateById(Long id, RentalUpdateRequest rentalUpdateRequest);
    List<RentalGetAllResponse> getAll();
    RentalGetResponse returnToHome(Long carId);


}
