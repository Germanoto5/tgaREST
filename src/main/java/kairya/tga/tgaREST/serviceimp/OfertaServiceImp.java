package kairya.tga.tgaREST.serviceimp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.model.Oferta;
import kairya.tga.tgaREST.repository.IOfertaRepository;
import kairya.tga.tgaREST.service.IOfertaService;

@Service
public class OfertaServiceImp implements IOfertaService{
	
	@Autowired
	IOfertaRepository repository;

	
	public Oferta findOferta(int id) {
		Optional<Oferta> oferta = repository.findById(id);
		return oferta.isPresent() ? oferta.get() : new Oferta();
	}

	
	public ArrayList<Oferta> listOfertas() {
		return (ArrayList<Oferta>) repository.findAll();
	}
}
