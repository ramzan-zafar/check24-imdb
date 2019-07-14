package com.check24.common.model.transport.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Validated
@ApiModel(value = "User")
public class UserDto {

	private Long id;

	@NotBlank
	@Size(min=6)
	private String username;

	@NotBlank
	@Size(min=6)
	private String password;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@Email
	private String email;
}
