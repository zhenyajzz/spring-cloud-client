package com.example.springcloudclient.controller;

import com.example.springcloudclient.model.Client;
import com.example.springcloudclient.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientRepo clientRepo;

    @GetMapping("/clients")
    private List<Client> findClients(){
        return clientRepo.findAll();
    }

    @GetMapping("client/{id}")
    private Client findClientById(@PathVariable Long id){
        return clientRepo.findById(id).orElse(null);
    }

    @PostMapping("/clients")
    private Client createClient(@RequestBody Client client){
        return clientRepo.save(client);
    }

    @PutMapping("/client/{id}")
    private Client updateClient(@RequestBody Client client,@PathVariable Long id){
        clientRepo.findById(id);
        client.setFirstName(client.getFirstName());
        client.setLastName(client.getLastName());
        return clientRepo.save(client);
    }

    @DeleteMapping("/{id}")
    private String removeClient(@PathVariable Long id){
        clientRepo.deleteById(id);
        return "We deleted client of id: " + id;
    }
}
