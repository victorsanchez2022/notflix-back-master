package com.app.movie.controller;

import com.app.movie.dto.ReportClientDto;
import com.app.movie.dto.ResponseDto;
import com.app.movie.service.ClientService;
import com.app.movie.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 */
@RestController
@RequestMapping("/api/client")
@CrossOrigin(origins = "*")
public class ClientController {

    @Autowired
    ClientService service;

    @GetMapping("")
    public Iterable<Client> get() {
        return service.get();
    }




    @PostMapping("")

    public ResponseEntity<ResponseDto> create(@RequestBody Client request) {
        ResponseDto responseDto = service.create(request);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto,HttpStatus.CONFLICT);


        //@ResponseStatus(HttpStatus.CREATED)
        //public Client create(@RequestBody Client request) {
        // return service.create(request);
        //}

        if(responseDto.status.booleanValue()==true){
            response = new ResponseEntity<>(responseDto,HttpStatus.CREATED);
        }

        return response;
    }



    @PutMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Client update(@RequestBody Client request) {
        return service.update(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }

}

