package com.brq.testecartao.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brq.testecartao.domain.Titular;

@RestController
@RequestMapping(value="/titulares")
public class TitularController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Titular>> findAll() {
		Titular maria = new Titular("1", "Maria Silva", "maria@gmail.com");
		Titular alex = new Titular("2", "Alex Green", "alex@gmail.com");
		List<Titular> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	}
	
	

}
