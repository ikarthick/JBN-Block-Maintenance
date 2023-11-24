package com.jbn.block.maintenance.residence.charges.repository;

import com.jbn.block.maintenance.residence.charges.entity.ResidentCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentChargeRepository extends JpaRepository<ResidentCharge, Integer> {
}
