package com.switchfully.youcoach.api.mappers;

import com.switchfully.youcoach.api.dtos.UserDTO;
import com.switchfully.youcoach.domain.entities.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserDTOMapper extends BidirectionalDTOMapper<User, UserDTO> {
}
