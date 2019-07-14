package com.check24.user.mapper;


import com.check24.common.model.transport.user.dto.UserDto;
import com.check24.user.model.User;


public interface UserMapper {

	public User fromDto(UserDto userDto);
	
	public UserDto toDto(User user);
}