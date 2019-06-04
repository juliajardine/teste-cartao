package com.brq.testecartao.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brq.testecartao.domain.Titular;
import com.brq.testecartao.repository.TitularRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private TitularRepository tir;
	
	@Override
	public void run(String... args) throws Exception {
		
		tir.deleteAll();
		
		Titular maria = new Titular(null, "Maria Silva", "maria@gmail.com");
		Titular alex = new Titular(null, "Alex Green", "alex@gmail.com");
		Titular bob = new Titular(null, "Bob Brown", "bob@gmail.com");
		
		tir.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
