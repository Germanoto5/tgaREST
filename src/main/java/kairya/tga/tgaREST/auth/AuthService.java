package kairya.tga.tgaREST.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.jwt.JwtService;
import kairya.tga.tgaREST.model.Rol;
import kairya.tga.tgaREST.model.Usuario;
import kairya.tga.tgaREST.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	

	@Autowired
	private final IUsuarioRepository repository;

	private final JwtService jwtService;

	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;
	
	public AuthResponse login(LoginRequest request) {
		UsernamePasswordAuthenticationToken a = new UsernamePasswordAuthenticationToken(request.getCorreo(), request.getContrasenia());
		authenticationManager.authenticate(a);
		UserDetails usuario = repository.findByCorreo(request.getCorreo()).orElseThrow();
		String token = jwtService.getToken(usuario);
		return AuthResponse.builder()
		.token(token)
		.build();
	}

	public AuthResponse register(RegisterRequest request) {
		// TODO Auto-generated method stub
		Usuario usuario = Usuario.builder()
				.correo(request.getCorreo())
				.contrasenia(passwordEncoder.encode(request.getContrasenia()))
				.nombre(request.getNombre())
				.apellidos(request.getApellidos())
				.rol(Rol.USER)
				.build();
		
		repository.save(usuario);
		return AuthResponse.builder()
			.token(jwtService.getToken(usuario))
			.build();
	}

}
