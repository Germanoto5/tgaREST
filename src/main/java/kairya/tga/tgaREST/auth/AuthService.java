package kairya.tga.tgaREST.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.errorHandler.AuthenticationException;
import kairya.tga.tgaREST.errorHandler.UserRegistrationException;
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
		try {
			UsernamePasswordAuthenticationToken a = new UsernamePasswordAuthenticationToken(request.getCorreo(),
					request.getContrasenia());
			authenticationManager.authenticate(a);
		} catch (Exception e) {
			throw new AuthenticationException("El correo o la contraseña són incorrectos.");
		}

		Usuario usuario = repository.findByCorreo(request.getCorreo())
				.orElseThrow(() -> new AuthenticationException("Usuario no encontrado"));
		String token = jwtService.getToken(usuario);
		return AuthResponse.builder()
				.token(token)
				.message("Login succesfull")
				.build();
	}

	public RegisterResponse register(RegisterRequest request) {
		if (repository.findByCorreo(request.getCorreo()).isPresent()) {
			throw new UserRegistrationException("El correo está en uso");
		}
		if (request.getContrasenia().length() < 8) {
			throw new UserRegistrationException("Contraseña con poca longitud");
		}
		Usuario usuario = Usuario.builder()
				.correo(request.getCorreo())
				.contrasenia(passwordEncoder.encode(request.getContrasenia()))
				.nombre(request.getNombre())
				.apellidos(request.getApellidos())
				.rol(Rol.USER)
				.build();

		repository.save(usuario);
		return RegisterResponse.builder()
				.message("Sign in succesfull")
				.statusCode(HttpStatus.CREATED.value())
				.build();
	}

}
