package com.business.group.location.dao;

import com.business.group.location.domain.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityDAO extends CrudRepository<City, Long> {
}
