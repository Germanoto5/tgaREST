package kairya.tga.tgaREST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kairya.tga.tgaREST.dto.UsuarioDto;
import kairya.tga.tgaREST.jwt.JwtService;
import kairya.tga.tgaREST.model.Usuario;
import kairya.tga.tgaREST.service.IUsuarioService;




@RestController
@RequestMapping("tga/private/api")
public class TgaPrivateController {

	@Autowired
    private JwtService jwtService;

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping("/")
	public ResponseEntity<String> findCategoria(){
		return new ResponseEntity<>("Wlcome to private endpoint", HttpStatus.OK);
	}

	@GetMapping("/me")
    public ResponseEntity<UsuarioDto> getUserDetails(@RequestHeader(name = "Authorization") String token) {
        String jwtToken = token.substring(7);
		String correo = jwtService.getUsernameFromToken(jwtToken);
        Usuario usuario = usuarioService.findUsuario(correo);
		UsuarioDto usuarioDto = new UsuarioDto(usuario);
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }
	
}
