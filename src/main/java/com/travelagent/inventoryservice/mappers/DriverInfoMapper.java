package com.travelagent.inventoryservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.travelagent.inventoryservice.dto.DriverInfoDto;
import com.travelagent.inventoryservice.entity.DriverInfoEntity;

@Mapper(componentModel = "spring")
public interface DriverInfoMapper {
    DriverInfoMapper INSTANCE = Mappers.getMapper(DriverInfoMapper.class);

    DriverInfoEntity toEntity(DriverInfoDto dto);
    DriverInfoDto toDto(DriverInfoEntity entity);
    
    List<DriverInfoEntity> toEntities(List<DriverInfoDto> dto);
    List<DriverInfoDto> toDtos(List<DriverInfoEntity> entity);
    
}
