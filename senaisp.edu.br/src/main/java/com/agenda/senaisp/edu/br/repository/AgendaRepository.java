package com.agenda.senaisp.edu.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.agenda.senaisp.edu.br.model.AgendaModel;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaModel, Long>{
	
	

}
