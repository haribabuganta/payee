package com.hcl.payee.repository;


import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.payee.entity.Payee;
@Repository
public interface PayeeRepository extends JpaRepository<Payee, Integer>{

	Payee payeeRepository.findById(payeeId);


}