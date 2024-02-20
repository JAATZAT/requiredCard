package com.tarea.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthResponse {

	private String token;

	private String status;
	private Object result;

	public static AuthResponse success(String token) {
		return AuthResponse.builder().status("ok").result("Inicio de sesión correcto").token(token).build();
	}

	public static AuthResponse error(String message) {
		return AuthResponse.builder().status("error").result(message).token(null).build();
	}
}
