package com.entrevista.controller;

import com.entrevista.beans.Session;
import com.entrevista.entity.Client;
import com.entrevista.service.ClientsService;
import com.entrevista.beans.SignIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    private final ClientsService clientService;

    public ClientController(ClientsService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> findAll(){
        return clientService.findAll();
    }

    @GetMapping("/client")
    public Optional<Client> findById(@RequestParam Long id){
        return clientService.findById(id);
    }

    @PostMapping("/client")
    public ResponseEntity<Client> save(@RequestBody Client newClient) {
        return clientService.saveClient(newClient);
    }

    @GetMapping("/exist")
    private Client validatedIfExist(@RequestBody Client client){
        return clientService.validatedIfExist( client );
    }

    @PostMapping("/login")
    public ResponseEntity<Session> login(@RequestBody SignIn signIn) {
        return clientService.login(signIn);
    }

    @PutMapping("/client/{id}")
    Client updateClient(@PathVariable(value = "id") Long id, @RequestBody Client newClient){
        return clientService.updateClient(id, newClient);
    }

    @DeleteMapping("/client")
    void deleteClient(@RequestParam Long id){
        clientService.deleteClient(id);
    }
}
