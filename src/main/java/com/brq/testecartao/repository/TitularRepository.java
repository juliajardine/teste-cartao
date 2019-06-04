package com.brq.testecartao.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brq.testecartao.domain.Titular;

@Repository
public interface TitularRepository extends MongoRepository<Titular, String>{

}
