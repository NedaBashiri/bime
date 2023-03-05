package org.quera.bime.repository;

import org.quera.bime.model.InsuranceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends CrudRepository<InsuranceEntity , Long> {
}
