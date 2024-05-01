package kairya.tga.tgaREST.service;

import java.util.ArrayList;

import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.model.Producto;

public interface IProductoService {
	Producto findProducto(int id);
	ArrayList<Producto> listProductos();
	ArrayList<Producto> listProductosByCategorias(Categoria categoria);
}
