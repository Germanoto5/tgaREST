package kairya.tga.tgaREST.service;

import kairya.tga.tgaREST.model.Usuario;

public interface IUsuarioService {
	Usuario findUsuario(String correo);
	Usuario addUsuario(Usuario usuario);
	Usuario updateUsuario(Usuario usuario);
}
