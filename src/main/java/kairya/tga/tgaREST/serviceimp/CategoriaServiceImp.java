package kairya.tga.tgaREST.serviceimp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.repository.ICategoriaRepository;
import kairya.tga.tgaREST.service.ICategoriaService;

@Service
public class CategoriaServiceImp implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepository repository;

	@Override
	public Categoria findCategoria(int id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.isPresent() ? categoria.get() : new Categoria();
	}

	@Override
	public ArrayList<Categoria> listCategorias() {
		return (ArrayList<Categoria>) repository.findAll();
	}

}
