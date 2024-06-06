package kairya.tga.tgaREST.dto;

import kairya.tga.tgaREST.model.Usuario;

public class UsuarioDto {
    private String correo;
    private String nombre;
    private String apellidos;

    public UsuarioDto(Usuario usuario) {
    	this.correo = usuario.getCorreo();
    	this.nombre = usuario.getNombre();
    	this.apellidos = usuario.getApellidos();
    }
    public UsuarioDto(){}

    public String getCorreo(){
        return this.correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
}
