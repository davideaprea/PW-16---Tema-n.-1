package com.business.group.location.dao;

import com.business.group.location.domain.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressDAO extends CrudRepository<Address, Long> {
}
