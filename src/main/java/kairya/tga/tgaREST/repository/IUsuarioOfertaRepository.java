package kairya.tga.tgaREST.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kairya.tga.tgaREST.model.UsuarioOferta;
import kairya.tga.tgaREST.model.UsuarioOfertaId;

@Repository
public interface IUsuarioOfertaRepository extends JpaRepository<UsuarioOferta , UsuarioOfertaId>{

    @Query("SELECT u FROM UsuarioOferta u WHERE u.usuario.correo = :correo")
	ArrayList<UsuarioOferta> findByCorreo(@Param("correo") String correo);
}
