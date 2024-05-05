package kairya.tga.tgaREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kairya.tga.tgaREST.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria , Integer>{}

