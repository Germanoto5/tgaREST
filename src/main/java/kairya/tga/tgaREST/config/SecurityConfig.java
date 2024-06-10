package kairya.tga.tgaREST.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import kairya.tga.tgaREST.jwt.JwtAuthenticationFilter;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Autowired
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	@Autowired
	private final AuthenticationProvider authProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		try {
			return http.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests(authRequest ->
				authRequest
					.requestMatchers("/tga/common/**").permitAll()
					.anyRequest().authenticated())
					.sessionManagement(sessionManagement -> 
					sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.authenticationProvider(authProvider)
					.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
