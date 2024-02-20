package com.tarea.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	//private final Customer userRepository;
	
/*	private final AuthenticationManager authenticationManager;*/
	
    /*public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
            		new UsernamePasswordAuthenticationToken(
            				request.getUsername(), 
            				request.getPassword()));
            
            UserDetails user = userRepository.findByUsername(
            		request.getUsername())
            		.orElseThrow();
            String token = jwtService.getToken(user);
            return AuthResponse.success(token);
        } catch (AuthenticationException e) {
            return AuthResponse.error("Inicio de sesión fallido. Credenciales incorrectas");
        }
    }*/
	
	/*public AuthResponse register(RegisterRequest request) {
		try {
		User user = User.builder()
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.country(request.getCountry())
				.role(Role.USER)
				.build();
		
		userRepository.save(user);
		
		return AuthResponse.success(jwtService.getToken(user));
		 } catch (Exception e) {
			 return AuthResponse.error("Error al registrar usuario");
	        }
		 }
*/
}
