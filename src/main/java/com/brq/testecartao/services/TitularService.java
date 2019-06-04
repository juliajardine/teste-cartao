package com.brq.testecartao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.testecartao.domain.Titular;
import com.brq.testecartao.dto.TitularDTO;
import com.brq.testecartao.repository.TitularRepository;
import com.brq.testecartao.services.exceptions.ObjectNotFoundException;

@Service
public class TitularService {

	@Autowired
	private TitularRepository repo;

	public List<Titular> findAll() {
		return repo.findAll();
	}

	public Titular findById(String id) {
		Optional<Titular> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Titular não encontrado"));
	}

	public Titular insert(Titular obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}

	/*
	 * este objeto como parâmetro, vem direto dos dados enviados pelo usuário, logo
	 * ainda não tem vinculo com o DB
	 */
	
	public Titular update(Titular obj) {
		Titular newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Titular newObj, Titular obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	public Titular fromDTO(TitularDTO objDto) {
		return new Titular(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
