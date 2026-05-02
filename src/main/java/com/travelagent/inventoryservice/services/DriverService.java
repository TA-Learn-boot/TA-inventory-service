package com.travelagent.inventoryservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagent.inventoryservice.dto.DriverInfoDto;
import com.travelagent.inventoryservice.entity.DriverInfoEntity;
import com.travelagent.inventoryservice.mappers.DriverInfoMapper;
import com.travelagent.inventoryservice.repository.DriverInfoRepository;

@Service
public class DriverService {

  @Autowired
  private DriverInfoRepository driverInfoRepository;

  @Autowired
  private DriverInfoMapper driverInfoMapper;

  public List<DriverInfoDto> getAll(Long owner_id) {
    List<DriverInfoEntity> allDriversEntity = driverInfoRepository.findAllByOwnerId(owner_id);
    if (allDriversEntity != null) {
      return driverInfoMapper.toDtos(allDriversEntity);
    }
    return null;
  }

  public DriverInfoDto createDriver(DriverInfoDto driverInfoDto) {

    if (driverInfoDto == null) {
      return null;
    } else {
      DriverInfoEntity dEntity = driverInfoMapper.toEntity(driverInfoDto);
      try {
        DriverInfoEntity savedDriver = driverInfoRepository.save(dEntity);
        return driverInfoMapper.toDto(savedDriver);
      } catch (IllegalArgumentException ex) {
        // Write the logs here.
      }
      return null;
    }

  }

}
