package kairya.tga.tgaREST.dto;

import kairya.tga.tgaREST.model.Categoria;

public class CategoriaDto {
	private Integer id;
    private String nombre;
    
    public CategoriaDto(Categoria categoria){
    	this.id = categoria.getId();
    	this.nombre = categoria.getNombre();
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
