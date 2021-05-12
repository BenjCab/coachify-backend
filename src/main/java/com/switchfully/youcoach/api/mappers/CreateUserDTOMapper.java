package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.dtos.CreateUserDTO;
import com.switchfully.youcoach.domain.entities.Coachee;
import org.mapstruct.Mapper;

@Mapper
public interface CreateUserDTOMapper extends BidirectionalDTOMapper<Coachee, CreateUserDTO> {
}
