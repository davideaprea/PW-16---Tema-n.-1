package com.business.location.medicalcentre.dao;

import com.business.location.medicalcentre.entity.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionDAO extends CrudRepository<Region, Long> {
}
