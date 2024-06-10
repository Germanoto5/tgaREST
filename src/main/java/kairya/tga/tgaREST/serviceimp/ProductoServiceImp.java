package kairya.tga.tgaREST.serviceimp;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.model.Producto;
import kairya.tga.tgaREST.repository.IProductoRepository;
import kairya.tga.tgaREST.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService{
	
	@Autowired
	private IProductoRepository repository;
	
	@Override
	public Producto findProducto(int id) {
		Optional<Producto> producto = repository.findById(id);
		return producto.isPresent() ? producto.get() : new Producto();
	}
	
	@Override
	public ArrayList<Producto> listProductos() {
		return (ArrayList<Producto>) repository.findAll();
	}

	@Override
	public ArrayList<Producto> listProductosByCategorias(Categoria categoria) {
		return (ArrayList<Producto>) repository.findByCategoria(categoria.getId());
	}

}
