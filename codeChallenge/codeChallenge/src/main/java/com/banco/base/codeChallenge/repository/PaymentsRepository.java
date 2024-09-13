package com.banco.base.codeChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banco.base.codeChallenge.dao.PaymentEntity;

@Repository
public interface PaymentsRepository extends JpaRepository<PaymentEntity, Long>{

}
