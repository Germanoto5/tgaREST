package kairya.tga.tgaREST.dto;

import java.math.BigDecimal;

import kairya.tga.tgaREST.model.Producto;

public class ProductoDto {
	private Integer id;
    private String nombre;
    private String urlImagen;
    private String ingredientes;
    private BigDecimal precio;
    private CategoriaDto idCategoria;
    
    public ProductoDto(Producto producto) {
    	this.id = producto.getId();
    	this.nombre = producto.getNombre();
    	this.urlImagen = producto.getUrlImagen();
    	this.ingredientes = producto.getIngredientes();
    	this.precio = producto.getPrecio();
    	this.idCategoria = new CategoriaDto(producto.getIdCategoria());
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
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public CategoriaDto getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(CategoriaDto idCategoria) {
		this.idCategoria = idCategoria;
	}
}
