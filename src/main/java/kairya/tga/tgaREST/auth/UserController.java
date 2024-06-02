package kairya.tga.tgaREST.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("tga/common/api/user")
@RequiredArgsConstructor
public class UserController {
	
	private final AuthService authService;
	
	@PostMapping(value = "login")
	public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(authService.login(request));
	}
	
	@PostMapping(value = "register")
	public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
		RegisterResponse response = authService.register(request);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
}
