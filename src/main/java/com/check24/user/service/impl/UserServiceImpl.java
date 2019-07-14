package com.check24.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.check24.common.model.transport.user.dto.UserDto;
import com.check24.exception.ResourceConflictException;
import com.check24.role.repository.RoleRepository;
import com.check24.security.jwt.JwtProvider;
import com.check24.user.mapper.UserMapper;
import com.check24.user.model.User;
import com.check24.user.repository.UserRepository;
import com.check24.user.service.UserService;

/**
 * Implementation of the UserService.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Override
	public List<UserDto> findAllUsers() {

		return null;
	}

	@Override
	public UserDto saveUser(UserDto userDto) {

		if (existsByUsername(userDto.getUsername())) {
			throw new ResourceConflictException(userDto.getUsername(), "User with this username already exist");
		}

		User user = userMapper.fromDto(userDto);

		user.setPassword(encoder.encode(user.getPassword()));

		userRepository.save(user);

		return userDto;
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}
}