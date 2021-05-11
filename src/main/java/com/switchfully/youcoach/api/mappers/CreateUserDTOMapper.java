package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.dtos.CreateUserDTO;
import com.switchfully.youcoach.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface CreateUserDTOMapper extends BidirectionalDTOMapper<User, CreateUserDTO> {
}
