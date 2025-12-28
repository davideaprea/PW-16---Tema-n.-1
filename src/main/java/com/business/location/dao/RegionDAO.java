package com.business.location.dao;

import com.business.location.entity.Region;
import org.springframework.data.repository.CrudRepository;

public interface RegionDAO extends CrudRepository<Region, Long> {
}
