package com.turkcell.rentacar.repository;

import com.turkcell.rentacar.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance,Long> {

    @Query("select m from Maintenance m where m.isPaid=true")
    List<Maintenance> getIsPaidTrue();

    Maintenance  findMaintenanceByCarIdAndIsCompletedFalse(Long id);
    boolean  existsByCarIdAndIsCompletedIsFalse(Long carId);


}
