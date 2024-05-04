package kairya.tga.tgaREST.dto;

import java.math.BigDecimal;
import java.util.Date;

import kairya.tga.tgaREST.model.Oferta;


public class OfertaDto {
	private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal descuento;
    private Date fechaInicio;
    private Date fechaFin;
    
    public OfertaDto(Oferta oferta) {
		this.id = oferta.getId();
		this.nombre = oferta.getNombre();
		this.descripcion = oferta.getDescripcion();
		this.descuento = oferta.getDescuento();
		this.fechaInicio = oferta.getFechaInicio();
		this.fechaFin = oferta.getFechaFin();
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}
