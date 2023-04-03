package com.turkcell.rentacar.api;

import com.turkcell.rentacar.business.dto.request.create.MaintenanceCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.MaintenanceUpdateRequest;
import com.turkcell.rentacar.business.dto.response.get.MaintenanceGetResponse;
import com.turkcell.rentacar.business.dto.response.getall.MaintenanceGetAllResponse;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface MaintenanceController {
    ResponseEntity createMaintenance(MaintenanceCreateRequest maintenanceCreateRequest);
    ResponseEntity<MaintenanceGetResponse> getMaintenanceById(Long id);
    ResponseEntity<List<MaintenanceGetAllResponse>> getAllMaintenance();
    ResponseEntity deleteMaintenance(Long id);
    ResponseEntity updateMaintenance(Long id,MaintenanceUpdateRequest maintenanceUpdateRequest);
}
