package com.business.location.medicalcentre.dao;

import com.business.location.medicalcentre.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address, Long> {
}
