package com.check24.user.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.check24.common.model.transport.user.dto.UserDto;
import com.check24.user.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * User Controller
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Returns list of users", produces = "application/json")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation", response = UserDto.class),
			@ApiResponse(code = 400, message = "Bad Request - Invalid request", responseContainer = "List") })
	@GetMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE })
	ResponseEntity<List<UserDto>> readAllUsers() {

		return ResponseEntity.ok(userService.findAllUsers());

	}

	@PostMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto, UriComponentsBuilder ucBuilder) {

		userService.saveUser(userDto);

		return ResponseEntity.ok().body("User registered successfully!");
	}

}