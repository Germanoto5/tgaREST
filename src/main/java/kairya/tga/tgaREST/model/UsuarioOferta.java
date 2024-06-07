package kairya.tga.tgaREST.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_oferta")
public class UsuarioOferta {

    @EmbeddedId
    private UsuarioOfertaId id;

    @ManyToOne
    @JoinColumn(name = "correo", referencedColumnName = "correo", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "oferta_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Oferta oferta;

    @Column(name = "codigo", unique = true, nullable = false)
    private String codigo;

    @Column(name = "tiempo_para_gastar")
    private LocalDateTime tiempoParaGastar;

    @Column(name = "tiempo_para_canjear_nuevamente")
    private LocalDateTime tiempoParaCanjearNuevamente;

	@Column(name = "activo")
	private Boolean activo;

	public UsuarioOfertaId getId() {
		return id;
	}

	public void setId(UsuarioOfertaId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getTiempoParaGastar() {
		return tiempoParaGastar;
	}

	public void setTiempoParaGastar(LocalDateTime tiempoParaGastar) {
		this.tiempoParaGastar = tiempoParaGastar;
	}

	public LocalDateTime getTiempoParaCanjearNuevamente() {
		return tiempoParaCanjearNuevamente;
	}

	public void setTiempoParaCanjearNuevamente(LocalDateTime tiempoParaCanjearNuevamente) {
		this.tiempoParaCanjearNuevamente = tiempoParaCanjearNuevamente;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
