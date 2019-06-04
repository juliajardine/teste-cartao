package com.brq.testecartao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.testecartao.domain.Titular;
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

}
