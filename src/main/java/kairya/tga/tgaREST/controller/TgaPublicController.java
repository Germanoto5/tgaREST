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
import kairya.tga.tgaREST.dto.OfertaDto;
import kairya.tga.tgaREST.dto.ProductoDto;
import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.model.Oferta;
import kairya.tga.tgaREST.model.Producto;
import kairya.tga.tgaREST.serviceimp.CategoriaServiceImp;
import kairya.tga.tgaREST.serviceimp.OfertaServiceImp;
import kairya.tga.tgaREST.serviceimp.ProductoServiceImp;

@RestController
@RequestMapping("tga/common/api/read")
public class TgaPublicController {
	
	@Autowired
	private CategoriaServiceImp categoriaService;
	
	@Autowired
	private ProductoServiceImp productoService;
	
	@Autowired
	private OfertaServiceImp ofertaService;
	
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
	@GetMapping("/oferta/{id}")
	public ResponseEntity<OfertaDto> findOferta(@PathVariable int id){
		OfertaDto oferta = new OfertaDto(ofertaService.findOferta(id));
		return new ResponseEntity<>(oferta, HttpStatus.OK);
	}
	
	@GetMapping("/ofertas")
	public ResponseEntity<ArrayList<OfertaDto>> listOfertas(){
		ArrayList<Oferta> ofertas = ofertaService.listOfertas();
		ArrayList<OfertaDto> ofertasDto = new ArrayList<OfertaDto>();
		for(Oferta oferta : ofertas) {
			OfertaDto ofertaDto = new OfertaDto(oferta);
			ofertasDto.add(ofertaDto);
		}
		return new ResponseEntity<>(ofertasDto, HttpStatus.OK);
	}

}
