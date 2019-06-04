package com.brq.testecartao.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brq.testecartao.domain.Titular;
import com.brq.testecartao.dto.TitularDTO;
import com.brq.testecartao.services.TitularService;

@RestController
@RequestMapping(value="/titulares")
public class TitularController {
	
	@Autowired
	private TitularService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TitularDTO>> findAll() {
		List<Titular> list = service.findAll();
		List<TitularDTO> listDto = list.stream().map(x -> new TitularDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<TitularDTO> findById(@PathVariable String id) {
		Titular obj = service.findById(id);
		return ResponseEntity.ok().body(new TitularDTO(obj));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody TitularDTO objDto) {
		Titular obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		/* created retorna o código 201 - código de resposta HTTP quando cria-se um novo recurso */
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
