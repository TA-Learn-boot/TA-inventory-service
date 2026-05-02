package com.travelagent.inventoryservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.travelagent.inventoryservice.dto.BusInfoDto;
import com.travelagent.inventoryservice.entity.BusInfoEntity;
import com.travelagent.inventoryservice.mappers.BusInfoMapper;
import com.travelagent.inventoryservice.repository.BusInfoRepository;

@Service
public class BusService {

  @Autowired
  private BusInfoRepository busInfoRepository;

  private BusInfoMapper busInfoMapper = BusInfoMapper.INSTANCE;

  public BusInfoDto createBus(BusInfoDto busInfoDto) {

    if (busInfoDto == null) {
      return null;
    }
    try {
      BusInfoEntity busInfoEntity = busInfoMapper.toEntity(busInfoDto);
      BusInfoEntity savedBus = busInfoRepository.save(busInfoEntity);
      return busInfoMapper.toDto(savedBus);
    } catch (IllegalArgumentException e) {
      return null;
    }

  }

  public List<BusInfoDto> getAllBus(Long createdBy) {
    List<BusInfoEntity> allBusesEntity = busInfoRepository.findAllByCreatedBy(createdBy);
    List<BusInfoDto> allBusesDto = busInfoMapper.toDtos(allBusesEntity);
    return allBusesDto;
  }

  public BusInfoDto getBus(Long busId) {
    Optional<BusInfoEntity> busInfoEntity = busInfoRepository.findById(busId);
    if (busInfoEntity.isPresent()) {
      BusInfoDto busDto = busInfoMapper.toDto(busInfoEntity.get());
      return busDto;
    } else {
      return null;
    }
  }

  public void deleteBus(Long busId) {
    busInfoRepository.deleteById(busId);
  }

  public BusInfoDto updateBusInfo(BusInfoDto busInfoDto) {
    Optional<BusInfoEntity> busInfoEntityOptional = busInfoRepository.findById(busInfoDto.getBus_id());
    if (busInfoEntityOptional.isPresent()) {
      return null;
    }

    var busEntity = busInfoEntityOptional.get();
    var name = busInfoDto.getName();
    var capacity = busInfoDto.getSeating_capacity();

    if (name != null && name.isEmpty() && name.isBlank()) {
      busEntity.setName(name);
    }
    if (capacity != null && capacity > 0) {
      busEntity.setSeating_capacity(capacity);
    }
    var savedEntity = busInfoRepository.save(busEntity);
    return busInfoMapper.toDto(savedEntity);

  }

}
