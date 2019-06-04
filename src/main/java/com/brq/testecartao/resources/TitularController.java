package com.brq.testecartao.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brq.testecartao.domain.Titular;
import com.brq.testecartao.services.TitularService;

@RestController
@RequestMapping(value="/titulares")
public class TitularController {
	
	@Autowired
	private TitularService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Titular>> findAll() {
		List<Titular> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	

}
