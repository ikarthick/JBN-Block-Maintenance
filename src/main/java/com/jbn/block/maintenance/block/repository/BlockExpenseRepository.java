package com.jbn.block.maintenance.block.repository;

import com.jbn.block.maintenance.block.entity.BlockExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Repository
public interface BlockExpenseRepository extends JpaRepository<BlockExpense, Integer> {

    // Query method to find the latest record based on recordDate
    Optional<BlockExpense> findFirstByIsActiveTrueOrderByRecordDateDesc();
}
