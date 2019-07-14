package com.check24.common.model;

public class JwtResponse {
    private String token;
    private String name;
    private String type = "Bearer";

    public JwtResponse(String accessToken,String name) {
        this.token = accessToken;
        this.setName(name);
        
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}