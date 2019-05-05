package com.hcl.payee.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

import com.hcl.payee.entity.Payee;
@Repository
public interface PayeeRepository extends JpaAttributeConverter<Payee, Integer>{

}
