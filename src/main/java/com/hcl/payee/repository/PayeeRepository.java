package com.hcl.payee.repository;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;

import com.hcl.payee.entity.Payee;

public interface PayeeRepository extends JpaAttributeConverter<Payee, Integer>{

}
