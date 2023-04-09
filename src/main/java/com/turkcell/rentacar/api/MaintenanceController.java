package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.MaintenanceCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.MaintenanceUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.MaintenanceGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.MaintenanceGetAllResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface MaintenanceController {
    ResponseEntity<Void> createMaintenance(MaintenanceCreateRequest maintenanceCreateRequest);
    ResponseEntity<MaintenanceGetResponse> getMaintenanceById(Long id);
    ResponseEntity<List<MaintenanceGetAllResponse>> getAllMaintenances();
    ResponseEntity<Void> deleteMaintenance(Long id);
    ResponseEntity<Void> updateMaintenance(Long id,MaintenanceUpdateRequest maintenanceUpdateRequest);
    ResponseEntity<MaintenanceGetResponse> returnCarFromMaintenance(Long carId);
}
