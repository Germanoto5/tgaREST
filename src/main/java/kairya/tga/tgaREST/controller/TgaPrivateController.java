package kairya.tga.tgaREST.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kairya.tga.tgaREST.dto.CategoriaDto;
import kairya.tga.tgaREST.dto.OfertaDto;
import kairya.tga.tgaREST.dto.ProductoDto;
import kairya.tga.tgaREST.dto.UsuarioDto;
import kairya.tga.tgaREST.jwt.JwtService;
import kairya.tga.tgaREST.model.Categoria;
import kairya.tga.tgaREST.model.Oferta;
import kairya.tga.tgaREST.model.Producto;
import kairya.tga.tgaREST.model.Usuario;
import kairya.tga.tgaREST.model.UsuarioOferta;
import kairya.tga.tgaREST.service.IUsuarioOfertaService;
import kairya.tga.tgaREST.service.IUsuarioService;
import kairya.tga.tgaREST.serviceimp.CategoriaServiceImp;
import kairya.tga.tgaREST.serviceimp.OfertaServiceImp;
import kairya.tga.tgaREST.serviceimp.ProductoServiceImp;




@RestController
@RequestMapping("tga/api")
public class TgaPrivateController {

	@Autowired
    private JwtService jwtService;

	@Autowired
	private IUsuarioService usuarioService;

	@Autowired 
	private IUsuarioOfertaService UsuarioOfertaServiceImp;

	@Autowired
	private CategoriaServiceImp categoriaService;
	
	@Autowired
	private ProductoServiceImp productoService;
	
	@Autowired
	private OfertaServiceImp ofertaService;

	@GetMapping("/me")
    public ResponseEntity<UsuarioDto> getUserDetails(@RequestHeader(name = "Authorization") String token) {
		String correo = getUserFromToken(token);
        Usuario usuario = usuarioService.findUsuario(correo);
		UsuarioDto usuarioDto = new UsuarioDto(usuario);
        return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
    }

	@GetMapping("/redeem/{idPromotion}")
    public ResponseEntity<Object> redeemPromotion(@RequestHeader(name = "Authorization") String token, @PathVariable int idPromotion) {
		String correo = getUserFromToken(token);
        ArrayList<UsuarioOferta> usuariosOfertas = UsuarioOfertaServiceImp.findByCorreo(correo);
		for(UsuarioOferta usuarioOferta : usuariosOfertas){
			if(idPromotion == usuarioOferta.getOferta().getId()){
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
		UsuarioOferta usuarioOferta = new UsuarioOferta(correo,idPromotion,"123456",LocalDateTime.now().plusMinutes(15),true);
		UsuarioOfertaServiceImp.guardarUsuarioPromocion(usuarioOferta);
		changeActivoUsuarioOferta(usuarioOferta);
		return new ResponseEntity<>(usuarioOferta.getCodigo(),HttpStatus.CREATED);
    }

	private CompletableFuture<Void> changeActivoUsuarioOferta(UsuarioOferta usuarioOferta){
		return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MINUTES.sleep(15);  // Espera 15 minutos
                usuarioOferta.setActivo(false);
				UsuarioOfertaServiceImp.guardarUsuarioPromocion(usuarioOferta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
	}

	public String getUserFromToken(String token){
		String jwtToken = token.substring(7);
		String correo = jwtService.getUsernameFromToken(jwtToken);
        return correo;
	}

	HashMap<String, Object> body = new HashMap<String, Object>();
	
	@GetMapping("/categoria/{id}")
	public ResponseEntity<CategoriaDto> findCategoria(@PathVariable int id){
		CategoriaDto categoria = new CategoriaDto(categoriaService.findCategoria(id));
		return new ResponseEntity<>(categoria, HttpStatus.OK);
	}
	
	@GetMapping("/categorias")
	public ResponseEntity<HashMap<String,Object>> listCategorias(){
		ArrayList<Categoria> categorias = categoriaService.listCategorias();
		ArrayList<CategoriaDto> categoriasDto = new ArrayList<CategoriaDto>();
		for(Categoria categoria : categorias) {
			CategoriaDto categoriaDto = new CategoriaDto(categoria);
			categoriasDto.add(categoriaDto);
		}
		body.put("data", categoriasDto);
		return new ResponseEntity<>(body, HttpStatus.OK);
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
	public ResponseEntity<HashMap<String,Object>> listProductosByCategorias(@PathVariable int idCategoria){
		Categoria categoria = categoriaService.findCategoria(idCategoria);
		
		if(categoria != null && categoria.getId()!=null) {
			ArrayList<Producto> productos = productoService.listProductosByCategorias(categoria);
			ArrayList<ProductoDto> productosDto = new ArrayList<ProductoDto>();
			for(Producto producto : productos) {
				ProductoDto productoDto = new ProductoDto(producto);
				productosDto.add(productoDto);
			}
			body.put("data", productosDto);
			return new ResponseEntity<>(body, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@GetMapping("/oferta/{id}")
	public ResponseEntity<OfertaDto> findOferta(@RequestHeader(name = "Authorization") String token, @PathVariable int id){
		String correo = getUserFromToken(token);
		Oferta oferta = ofertaService.findOferta(id);
		if(oferta != null){
			ArrayList<UsuarioOferta> usuariosOfertas = UsuarioOfertaServiceImp.findByCorreo(correo);
		for(UsuarioOferta usuarioOferta : usuariosOfertas){
			if(oferta.getId() == usuarioOferta.getOferta().getId()){
				if(usuarioOferta.getActivo() == true){
					OfertaDto ofertaDto = new OfertaDto(oferta);
					ofertaDto.setActivo(usuarioOferta.getActivo());
					ofertaDto.setTiempoParaGastar(usuarioOferta.getTiempoParaGastar());
					ofertaDto.setCodigo(usuarioOferta.getCodigo());
					return new ResponseEntity<>(ofertaDto, HttpStatus.OK);
				}
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
		}
		OfertaDto ofertaDto = new OfertaDto(oferta);
		ofertaDto.setActivo(null);
		ofertaDto.setTiempoParaGastar(null);
		return new ResponseEntity<>(ofertaDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        
	}
	
	@GetMapping("/ofertas/{correo}")
	public ResponseEntity<HashMap<String,Object>> listOfertas(@PathVariable String correo){
		ArrayList<Oferta> ofertas = ofertaService.listOfertas();
		ArrayList<UsuarioOferta> usuarioOfertas = UsuarioOfertaServiceImp.findByCorreo(correo);
		ArrayList<OfertaDto> ofertasDto = new ArrayList<OfertaDto>();
		if(usuarioOfertas == null || usuarioOfertas.isEmpty()){
			for(Oferta oferta : ofertas) {
				OfertaDto ofertaDto = new OfertaDto(oferta);
				ofertasDto.add(ofertaDto);
			}
		}else{
			for(Oferta oferta : ofertas){
				boolean comprobadorExistencia = false;
				for(UsuarioOferta usuarioOferta : usuarioOfertas){
					if(usuarioOferta.getOferta().getId() == oferta.getId() && !usuarioOferta.getActivo()) comprobadorExistencia = true;
				}
				if(!comprobadorExistencia){
					OfertaDto ofertaDto = new OfertaDto(oferta);
					ofertasDto.add(ofertaDto);
				}
			}
		}
		body.put("data", ofertasDto);
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
}
