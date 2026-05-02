package com.travelagent.inventoryservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelagent.inventoryservice.entity.DriverInfoEntity;

@Repository
public interface DriverInfoRepository extends JpaRepository<DriverInfoEntity,Long>{
       List<DriverInfoEntity> findAllByOwnerId(Long created_by); 
}
