package kairya.tga.tgaREST.service;

import java.util.ArrayList;

import kairya.tga.tgaREST.model.Categoria;

public interface ICategoriaService {
	Categoria findCategoria(int id);
	ArrayList<Categoria> listCategorias();
	/*Categoria insertarCategoria(Categoria categoria);
	Categoria modificarCategoria(Categoria categoria);
	void eliminarCategoria(Categoria categoria);*/
	
}
