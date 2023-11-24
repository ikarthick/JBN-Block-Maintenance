package com.jbn.block.maintenance.residence.payment.repository;

import com.jbn.block.maintenance.residence.payment.entity.ResidentPaymentTrx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentPaymentTrxRepository extends JpaRepository<ResidentPaymentTrx, Integer> {
}
