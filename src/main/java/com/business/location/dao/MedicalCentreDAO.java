package com.business.location.dao;

import com.business.location.entity.MedicalCentre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicalCentreDAO extends CrudRepository<MedicalCentre, Long> {
    @Query("""
                select distinct mc from MedicalCentre mc
                join fetch mc.address
                join fetch mc.floors f
                join fetch f.rooms
                where mc.id = :id
            """)
    Optional<MedicalCentre> findByIdWithRelations(Long id);
}
