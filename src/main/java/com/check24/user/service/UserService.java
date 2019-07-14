package com.check24.user.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.check24.common.model.transport.user.dto.UserDto;
import com.check24.user.model.User;



/**
 * User service
 */
@Component
public interface UserService {
	 
	Optional<User> findByUsername(String username);
	
    List<UserDto> findAllUsers();
    
    UserDto saveUser(UserDto userDto);
    
    Boolean existsByUsername(String username);
}
