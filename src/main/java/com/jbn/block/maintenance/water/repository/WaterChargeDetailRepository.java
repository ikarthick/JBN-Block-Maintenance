package com.jbn.block.maintenance.water.repository;

import com.jbn.block.maintenance.water.entity.WaterChargeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterChargeDetailRepository extends JpaRepository<WaterChargeDetail, Integer> {
}
