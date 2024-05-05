package kairya.tga.tgaREST.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kairya.tga.tgaREST.model.Usuario;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario , String>{

	@Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
	Optional<Usuario> findByCorreo(@Param("correo") String correo);
}
