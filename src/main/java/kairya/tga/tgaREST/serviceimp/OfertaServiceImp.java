package kairya.tga.tgaREST.serviceimp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.model.Oferta;
import kairya.tga.tgaREST.repository.IOfertaRepository;
import kairya.tga.tgaREST.service.IOfertaService;

@Service
public class OfertaServiceImp implements IOfertaService {

	@Autowired
	IOfertaRepository repository;

	public Oferta findOferta(int id) {
		Optional<Oferta> oferta = repository.findById(id);
		return oferta.isPresent() ? oferta.get() : new Oferta();
	}

	public ArrayList<Oferta> listOfertas() {
		ArrayList<Oferta> ofertas = (ArrayList<Oferta>) repository.findAll();
		ArrayList<Oferta> ofertaFiltrada = new ArrayList<Oferta>();
		if (ofertas != null && ofertas.size() > 0) {
			for (Oferta oferta : ofertas) {
				if(oferta.getFechaFin().isAfter(LocalDateTime.now()) || oferta.getFechaFin().isEqual(LocalDateTime.now())){
					ofertaFiltrada.add(oferta);
				}
			}
		}
		return ofertaFiltrada;
	}
}
