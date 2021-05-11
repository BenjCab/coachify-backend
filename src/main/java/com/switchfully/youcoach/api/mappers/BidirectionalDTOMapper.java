package com.switchfully.youcoach.api.mappers;

import java.util.List;

public interface BidirectionalDTOMapper<ENTITY, DTO> {
    DTO toDTO(ENTITY entity);

    List<DTO> toDTO(List<ENTITY> entity);

    ENTITY toEntity(DTO dto);

    List<ENTITY> toEntity(List<DTO> dtoList);
}
