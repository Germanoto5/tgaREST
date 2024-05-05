package kairya.tga.tgaREST.serviceimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.model.Usuario;
import kairya.tga.tgaREST.repository.IUsuarioRepository;
import kairya.tga.tgaREST.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService{

	@Autowired
	IUsuarioRepository repository;
	
	@Override
	public Usuario findUsuario(String correo) {
		Optional<Usuario> usuario = repository.findByCorreo(correo);
		return usuario.isPresent() ? usuario.get() : new Usuario();
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		Usuario user = repository.save(usuario);
		return user;
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		Usuario user = repository.save(usuario);
		return user;
	}

}
