package com.jbn.block.maintenance.residence.details.repository;

import com.jbn.block.maintenance.residence.details.entity.ResidentDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentDetailRepository extends JpaRepository<ResidentDetail, Long> {
}
