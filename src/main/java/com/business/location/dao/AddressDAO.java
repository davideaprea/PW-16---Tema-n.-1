package com.business.location.dao;

import com.business.location.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address, Long> {
}
