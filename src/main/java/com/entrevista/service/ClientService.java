package com.entrevista.service;

import com.entrevista.beans.Session;
import com.entrevista.entity.Client;
import com.entrevista.beans.SignIn;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> findAll();
    Optional<Client> findById(Long id);
    ResponseEntity<Client> saveClient(Client client);

    Client validatedIfExist(Client client);

    ResponseEntity<Session> login(SignIn signIn);

    void deleteClient(Long id);

    Client updateClient(Long id, Client newClient);
}
