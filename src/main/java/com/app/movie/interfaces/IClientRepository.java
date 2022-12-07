package com.app.movie.interfaces;

import com.app.movie.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 *

 */
public interface IClientRepository extends MongoRepository<Client, String> {
    @Query(value= "{email : ?0}") // SQL Equivalent : SELECT * FROM Client select * from Client where email=?
    List<Client> getClientByEmail(String email);
}

