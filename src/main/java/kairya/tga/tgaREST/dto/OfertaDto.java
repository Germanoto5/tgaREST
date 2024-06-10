package kairya.tga.tgaREST.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import kairya.tga.tgaREST.model.Oferta;


public class OfertaDto {
	private Integer id;
    private String nombre;
    private String descripcion;
    private BigDecimal descuento;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
	private String imagen;
	private Boolean activo;
	private LocalDateTime tiempoParaGastar;
	private String codigo;
    
    public OfertaDto(Oferta oferta) {
		this.id = oferta.getId();
		this.nombre = oferta.getNombre();
		this.descripcion = oferta.getDescripcion();
		this.descuento = oferta.getDescuento();
		this.fechaInicio = oferta.getFechaInicio();
		this.fechaFin = oferta.getFechaFin();
		this.imagen = oferta.getImagen();
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
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

	public void setTiempoParaGastar(LocalDateTime tiempoParaGastar) {
		this.tiempoParaGastar = tiempoParaGastar;
	}
	public LocalDateTime getTiempoParaGastar() {
		return tiempoParaGastar;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Boolean getActivo() {
		return activo;
	}

	public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
	
}
