package kairya.tga.tgaREST.auth;

import kairya.tga.tgaREST.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	String correo;
	String contrasenia;
	String nombre;
	String apellidos;
	Rol rol;
}
