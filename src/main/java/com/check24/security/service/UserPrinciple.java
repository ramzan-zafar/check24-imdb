package com.check24.security.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.check24.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserPrinciple implements UserDetails {
	
	private static final long serialVersionUID = 9213307411262790182L;

	private Long id;

	private String firstName;

	private String lastName;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserPrinciple(Long id, String firstName, String lastName, String username, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserPrinciple build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());

		return new UserPrinciple(user.getUserId(), user.getFirstName(), user.getLastName(), user.getUsername(),
				user.getEmail(), user.getPassword(), authorities);
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}