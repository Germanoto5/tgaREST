package kairya.tga.tgaREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kairya.tga.tgaREST.model.UsuarioOferta;
import kairya.tga.tgaREST.model.UsuarioOfertaId;

@Repository
public interface IUsuarioOfertaRepository extends JpaRepository<UsuarioOferta , UsuarioOfertaId>{

}
