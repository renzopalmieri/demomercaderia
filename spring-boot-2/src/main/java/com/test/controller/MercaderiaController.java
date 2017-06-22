package com.test.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.BEAN.Mercaderia;
import com.test.SERVICE.IMercaderiaService;


@Controller
@RequestMapping("usuarios")
@CrossOrigin(origins = {"http://localhost:4200"})
public class MercaderiaController {
	
	
	@Autowired
	private IMercaderiaService mercaderiaService;
	
	
	@GetMapping("mercaderia")
	public ResponseEntity<Mercaderia> getMercaderiasById(@RequestParam("id") String id) {
		Mercaderia mercaderia = mercaderiaService.getMercaderiaById(Integer.parseInt(id));
		return new ResponseEntity<Mercaderia>(mercaderia, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("all-mercaderias")
	public ResponseEntity<List<Mercaderia>> getAllMercaderias() {
		List<Mercaderia> list = mercaderiaService.getAllMercaderia();
		return new ResponseEntity<List<Mercaderia>>(list, HttpStatus.OK);
	}
	
	
	
		
	@PostMapping("mercaderia")
	public ResponseEntity<Void> createArticle(@RequestBody Mercaderia mercaderia, UriComponentsBuilder builder) {
        boolean flag = mercaderiaService.createMercaderia(mercaderia);
        
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/mercaderia?id={id}").buildAndExpand(mercaderia.getmercaderiaId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        
        
	}
	
	
	
	@PutMapping("article")
	public ResponseEntity<Mercaderia> updateMercaderia(@RequestBody Mercaderia mercaderia) {
		mercaderiaService.updateMercaderia(mercaderia);
		return new ResponseEntity<Mercaderia>(mercaderia, HttpStatus.OK);
	}
	
}
