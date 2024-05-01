package kairya.tga.tgaREST.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kairya.tga.tgaREST.dto.CategoriaDto;
import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.serviceimp.CategoriaServiceImp;

@RestController
@RequestMapping("api/tga")
public class TgaController {
	
	@Autowired
	private CategoriaServiceImp categoriaService;
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<CategoriaDto> findCategoria(@PathVariable int id){
		CategoriaDto categoria = new CategoriaDto(categoriaService.findCategoria(id));
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<ArrayList<CategoriaDto>> listCategorias(){
		ArrayList<Categoria> categorias = categoriaService.listCategorias();
		ArrayList<CategoriaDto> categoriasDto = new ArrayList<CategoriaDto>();
		for(Categoria categoria : categorias) {
			CategoriaDto categoriaDto = new CategoriaDto(categoria);
			categoriasDto.add(categoriaDto);
		}
		return new ResponseEntity<>(categoriasDto, HttpStatus.OK);
	}
	

}
