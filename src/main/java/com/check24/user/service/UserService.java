package com.check24.user.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.check24.common.model.transport.user.dto.UserDto;
import com.check24.user.model.User;

/**
 * User service to perform user related tasks
 * @author Ramzan_Zafar
 */
@Component
public interface UserService {
	
	/**
	 * Method to find User by username
	 * @param username String
	 * @return Optional<User>
	 */
	Optional<User> findByUsername(String username);
	
    /**
     * Method to find all users
     * @return list of {@link UserDto}
     */
    List<UserDto> findAllUsers();
    
    /**
     * Method to persist user
     * @param userDto {@link UserDto}
     * @return {@link UserDto}
     */
    UserDto saveUser(UserDto userDto);
    
    /**
     * Method to check if user already exist with the given username
     * @param username String
     * @return {@link Boolean}
     */
    Boolean existsByUsername(String username);
}
