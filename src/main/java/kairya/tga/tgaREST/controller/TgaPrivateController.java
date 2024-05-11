package kairya.tga.tgaREST.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("tga/private/api")
public class TgaPrivateController {
	@PostMapping("/ok")
	public ResponseEntity<String> findCategoria(){
		return new ResponseEntity<>("Wlcome to private endpoint", HttpStatus.OK);
	}
	
}
