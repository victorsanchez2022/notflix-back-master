package com.app.movie.repository;

import com.app.movie.entities.Movie;
import com.app.movie.entities.Client;
import com.app.movie.interfaces.IClientRepository;
import com.app.movie.interfaces.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Andres
 */
@Repository
public class ClientRepository {

    @Autowired
    IClientRepository repository;

    public Iterable<Client> getAll(){
        return repository.findAll();
    }

    public List<Client> getByEmail(String email){
        return repository.getClientByEmail(email);
    }


    public Optional<Client> findById(String id){
        Optional<Client> response= repository.findById(id);
        return response;
    }

    public Boolean existsById(String id){
        return repository.existsById(id);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public Client save(Client client){
        return repository.save(client);
    }

}

