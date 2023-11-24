package com.jbn.block.maintenance.residence.repository;

import com.jbn.block.maintenance.residence.entity.ResidentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentDetailRepository extends JpaRepository<ResidentDetail, Long> {
}
