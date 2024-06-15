package com.agenda.senaisp.edu.br.service;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agenda.senaisp.edu.br.model.AgendaModel;
import com.agenda.senaisp.edu.br.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	AgendaRepository repository;
	
	public AgendaModel salvar(AgendaModel agenda) {
		
		return repository.save(agenda); 
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public AgendaModel atualizar(AgendaModel agenda, Long id){
		AgendaModel at = repository.getById(id);
		
		at.setNome(agenda.getNome());
		at.setTelefone(agenda.getTelefone());
		return repository.save(at);
	}
	
	public List <AgendaModel> listando (){
		return repository.findAll();
	}
	  
	
}
