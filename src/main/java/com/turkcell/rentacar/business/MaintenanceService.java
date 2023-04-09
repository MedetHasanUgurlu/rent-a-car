package com.turkcell.rentacar.business;

import com.turkcell.rentacar.business.dto.request.create.MaintenanceCreateRequest;
import com.turkcell.rentacar.business.dto.request.update.MaintenanceUpdateRequest;
import com.turkcell.rentacar.business.dto.response.getall.MaintenanceGetAllResponse;
import com.turkcell.rentacar.business.dto.response.get.MaintenanceGetResponse;
import java.util.List;
public interface MaintenanceService {
    void createMaintenance(MaintenanceCreateRequest maintenanceCreateRequest);
    MaintenanceGetResponse getMaintenanceById(Long id);
    List<MaintenanceGetAllResponse> getAllMaintenance();
    void updateMaintenance(Long id, MaintenanceUpdateRequest request);
    void deleteMaintenanceById(Long id);
    MaintenanceGetResponse returnCarFromMaintenance(Long carId);



}
