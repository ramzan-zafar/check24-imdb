package com.check24.user.mapper.impl;

import org.springframework.stereotype.Component;

import com.check24.common.model.transport.user.dto.UserDto;
import com.check24.user.mapper.UserMapper;
import com.check24.user.model.User;

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public User fromDto(UserDto userDto) {

		User user = new User();
		user.setUserId(userDto.getId());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		return user;
	}

	@Override
	public UserDto toDto(User user) {

		UserDto userDto = new UserDto();
		userDto.setId(user.getUserId());
		userDto.setUsername(user.getUsername());
		userDto.setPassword(user.getPassword());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}

}