package com.jbn.block.maintenance.eb.repository;

import com.jbn.block.maintenance.eb.entity.EbChargeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EbChargeDetailRepository extends JpaRepository<EbChargeDetail, Integer> {
}
