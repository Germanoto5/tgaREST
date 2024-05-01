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
import kairya.tga.tgaREST.dto.ProductoDto;
import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.model.Producto;
import kairya.tga.tgaREST.serviceimp.CategoriaServiceImp;
import kairya.tga.tgaREST.serviceimp.ProductoServiceImp;

@RestController
@RequestMapping("api/tga")
public class TgaController {
	
	@Autowired
	private CategoriaServiceImp categoriaService;
	
	@Autowired
	private ProductoServiceImp productoService;
	
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
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<ProductoDto> findProducto(@PathVariable int id){
		ProductoDto producto = new ProductoDto(productoService.findProducto(id));
		return new ResponseEntity<>(producto, HttpStatus.OK);
	}
	
	@GetMapping("/productos")
	public ResponseEntity<ArrayList<ProductoDto>> listProductos(){
		ArrayList<Producto> productos = productoService.listProductos();
		ArrayList<ProductoDto> productosDto = new ArrayList<ProductoDto>();
		for(Producto producto : productos) {
			ProductoDto productoDto = new ProductoDto(producto);
			productosDto.add(productoDto);
		}
		return new ResponseEntity<>(productosDto, HttpStatus.OK);
	}
	@GetMapping("/productos/categoria/{idCategoria}")
	public ResponseEntity<ArrayList<ProductoDto>> listProductosByCategorias(@PathVariable int idCategoria){
		Categoria categoria = categoriaService.findCategoria(idCategoria);
		
		if(categoria != null && categoria.getId()!=null) {
			ArrayList<Producto> productos = productoService.listProductosByCategorias(categoria);
			ArrayList<ProductoDto> productosDto = new ArrayList<ProductoDto>();
			for(Producto producto : productos) {
				ProductoDto productoDto = new ProductoDto(producto);
				productosDto.add(productoDto);
			}
			return new ResponseEntity<>(productosDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}

}
