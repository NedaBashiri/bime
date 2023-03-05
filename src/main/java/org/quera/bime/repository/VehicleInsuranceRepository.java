package org.quera.bime.repository;

import org.quera.bime.model.VehicleInsuranceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInsuranceRepository extends CrudRepository<VehicleInsuranceEntity, Long> {
}
