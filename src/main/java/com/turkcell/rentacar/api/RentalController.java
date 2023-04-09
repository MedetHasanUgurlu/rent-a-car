package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.RentalCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.RentalUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.RentalGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.RentalGetAllResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RentalController {
    ResponseEntity<Void> createRental(RentalCreateRequest request);
    ResponseEntity<RentalGetResponse> getRentalById(Long id);
    ResponseEntity<List<RentalGetAllResponse>> getAllRentals();
    ResponseEntity<Void> deleteRental(Long id);
    ResponseEntity<Void> updateRental(Long id, RentalUpdateRequest request);
    ResponseEntity<RentalGetResponse> returnCarFromRental(Long carId);
}
