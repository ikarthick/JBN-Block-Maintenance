package com.jbn.block.maintenance.block.repository;

import com.jbn.block.maintenance.block.entity.BlockExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockExpenseRepository extends JpaRepository<BlockExpense, Integer> {
}
