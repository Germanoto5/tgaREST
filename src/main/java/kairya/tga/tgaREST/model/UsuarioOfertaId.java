package kairya.tga.tgaREST.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioOfertaId implements Serializable {

    @Column(name = "correo")
    private String correo;

    @Column(name = "oferta_id")
    private Long promocionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioOfertaId that = (UsuarioOfertaId) o;
        return Objects.equals(correo, that.correo) &&
                Objects.equals(promocionId, that.promocionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo, promocionId);
    }

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getPromocionId() {
		return promocionId;
	}

	public void setPromocionId(Long promocionId) {
		this.promocionId = promocionId;
	}
}