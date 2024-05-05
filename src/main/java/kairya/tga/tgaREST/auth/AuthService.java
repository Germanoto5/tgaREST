package kairya.tga.tgaREST.auth;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public AuthResponse login() {
		// TODO Auto-generated method stub
		return null;
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
