package com.mikescherbakov.jobinterviewbase.repository;

import com.mikescherbakov.jobinterviewbase.model.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
