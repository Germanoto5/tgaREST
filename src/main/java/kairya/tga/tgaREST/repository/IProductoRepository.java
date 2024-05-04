package kairya.tga.tgaREST.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kairya.tga.tgaREST.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto , Integer>{
	
	@Query("SELECT p FROM Producto p WHERE p.idCategoria.id = :categoriaId")
	ArrayList<Producto> findByCategoria(@Param("categoriaId") int categoriaId);
}
