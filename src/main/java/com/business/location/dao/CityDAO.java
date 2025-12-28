package com.business.location.dao;

import com.business.location.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityDAO extends CrudRepository<City, Long> {
}
