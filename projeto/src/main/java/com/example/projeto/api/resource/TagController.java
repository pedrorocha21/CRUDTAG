package com.example.projeto.api.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TagController {
	
	@GetMapping("/tag")
	public String findAll() {
		return "Funcionando 2";
	}
	
	
	
	
}
