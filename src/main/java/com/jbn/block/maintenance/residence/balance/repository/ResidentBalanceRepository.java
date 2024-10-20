package com.jbn.block.maintenance.residence.balance.repository;

import com.jbn.block.maintenance.residence.balance.entity.ResidentBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentBalanceRepository extends JpaRepository<ResidentBalance, Integer> {

    public ResidentBalance findByResidentId(Integer residentId);
}
