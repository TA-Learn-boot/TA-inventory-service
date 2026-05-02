package com.travelagent.inventoryservice.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.travelagent.inventoryservice.dto.BusInfoDto;
import com.travelagent.inventoryservice.entity.BusInfoEntity;


@Mapper(componentModel = "spring")
public interface BusInfoMapper {
    BusInfoMapper INSTANCE = Mappers.getMapper(BusInfoMapper.class);

    BusInfoEntity toEntity(BusInfoDto dto);

    BusInfoDto toDto(BusInfoEntity entity);

    List<BusInfoDto> toDtos(List<BusInfoEntity> entities);
    List<BusInfoEntity> toEntities(List<BusInfoDto> dtos);

}
