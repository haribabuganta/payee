package com.hcl.payee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.payee.entity.Payee;

public interface PayeeRepository extends JpaRepository<Payee, Integer> {

}
