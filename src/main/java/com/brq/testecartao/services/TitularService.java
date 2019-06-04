package com.brq.testecartao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brq.testecartao.domain.Titular;
import com.brq.testecartao.repository.TitularRepository;

@Service
public class TitularService {
	
	@Autowired
	private TitularRepository repo;
	
	public List<Titular> findAll() {
		return repo.findAll();
	}

}
