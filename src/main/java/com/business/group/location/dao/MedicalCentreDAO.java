package com.business.group.location.dao;

import com.business.group.location.domain.entity.MedicalCentre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MedicalCentreDAO extends JpaRepository<MedicalCentre, Long> {
    @Query("""
                select mc
                from MedicalCentre mc
                join mc.address a
                join a.city c
                join c.region r
                where r.id = :regionId
                  and (
                       :cityName is null
                       or lower(c.name) like lower(concat('%', :cityName, '%'))
                  )
            """)
    Page<MedicalCentre> findByRegionAndCity(
            long regionId,
            String cityName,
            Pageable pageable
    );
}
