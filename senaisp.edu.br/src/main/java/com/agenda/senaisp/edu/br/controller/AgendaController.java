package com.agenda.senaisp.edu.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.senaisp.edu.br.model.AgendaModel;
import com.agenda.senaisp.edu.br.service.AgendaService;

@RestController
@RequestMapping("/agenda")
public class AgendaController {
	@Autowired
	AgendaService repository;
	
	@PostMapping 
	public AgendaModel criacao(@RequestBody AgendaModel agenda) {
		
		return repository.salvar(agenda);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) { 
		repository.delete(id);
	
	}
	
	@PutMapping("/{id}")
	public AgendaModel atualizando (@PathVariable Long id, @RequestBody AgendaModel agenda){
		return repository.atualizar(agenda, id);
	}
	
	@GetMapping
	public List <AgendaModel> puxando(){
		return repository.listando();
	}
	
	
}
