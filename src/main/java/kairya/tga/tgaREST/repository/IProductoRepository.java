package kairya.tga.tgaREST.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto , Integer>{
	ArrayList<Producto> findByCategoria(Categoria categoria);
}
