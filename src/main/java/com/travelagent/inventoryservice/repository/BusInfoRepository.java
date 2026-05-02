package com.travelagent.inventoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelagent.inventoryservice.entity.BusInfoEntity;

@Repository
public interface BusInfoRepository extends JpaRepository<BusInfoEntity,Long> {

   List<BusInfoEntity> findAllByCreatedBy(Long created_by);
    
}
