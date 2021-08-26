package com.contactura.contactura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactura.contactura.model.Contactura;
import com.contactura.contactura.repository.ContacturaRepository;

@Service
public class ContacturaService {
	@Autowired
	private ContacturaRepository repository;

	public Optional<Contactura> findById(Long id) {
		return this.repository.findById(id);
	}

	public String deleteById(Long id) throws Exception {
		this.findById(id).orElseThrow(() -> new NullPointerException("Contato inexistente"));
		this.repository.deleteById(id);
		Optional<Contactura> contact = this.findById(id);
		if(contact.isPresent()){
			throw new Exception("Ocorreu um erro... contato não deletado");
		}
		return "Contato deletado com Sucesso!";
	}
}


