package com.check24.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResourceConflictException extends RuntimeException {
	
	private static final long serialVersionUID = 1791564636123821405L;
	
	private String resource;

	public ResourceConflictException(String resource, String message) {
		super(message);
		this.resource = resource;
	}

}
