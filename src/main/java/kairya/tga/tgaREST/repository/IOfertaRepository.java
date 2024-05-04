package kairya.tga.tgaREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kairya.tga.tgaREST.model.Oferta;

@Repository
public interface IOfertaRepository extends JpaRepository<Oferta , Integer>{}
