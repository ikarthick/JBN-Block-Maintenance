package com.jbn.block.maintenance.Repository;

import com.jbn.block.maintenance.Entity.HouseOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseOwnerRepository extends JpaRepository<HouseOwner, Long> {
}
