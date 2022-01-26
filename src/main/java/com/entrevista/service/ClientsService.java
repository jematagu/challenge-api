package com.entrevista.service;

import com.entrevista.beans.Session;
import com.entrevista.entity.Client;
import com.entrevista.repository.ClientRepository;
import com.entrevista.utils.Asserts;
import com.entrevista.utils.Constants;
import com.entrevista.beans.SignIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsService implements ClientService{

    private final ClientRepository clientRepository;

    public ClientsService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public ResponseEntity<Client> saveClient(Client client) {
        HttpStatus responseStatus;
        Client responseClient;
        if (validatedIfExist(client) == null && Asserts.validateAge(client.getBirthDate())){
            responseStatus = HttpStatus.CREATED;
            responseClient = clientRepository.save(client);
        } else {
            responseStatus = HttpStatus.CONFLICT;
            responseClient = client;
        }
        return new ResponseEntity<>(responseClient, responseStatus);
    }

    @Override
    public Client validatedIfExist(Client client) {
        return clientRepository.findByNameAndFirstLastnameAndSecondLastnameAndBirthDateAndUsername(
                client.getName(),
                client.getFirstLastname(),
                client.getSecondLastname(),
                client.getBirthDate(),
                client.getUsername()
        );
    }

    @Override
    public ResponseEntity<Session> login(SignIn signIn) {
        Client client = clientRepository.findByUsername(signIn.getUsername());
        if (client == null) new ResponseEntity<Session>(new Session(), HttpStatus.NOT_FOUND);
        if (!client.getPassword().equals(signIn.getPassword())) return new ResponseEntity<Session>(new Session(), HttpStatus.CONFLICT);

        return new ResponseEntity<>(new Session(
                client.getId(),
                client.getName(),
                client.getUsername(),
                client.getEmail(),
                client.getFirstLastname(),
                client.getSecondLastname(),
                client.getBirthDate()
        ), HttpStatus.OK);
    }

    @Override
    public Client updateClient(Long id, Client newClient) {
        Optional<Client> client = findById(id);

        if (validatedIfExist(newClient) == null && Asserts.validateAge(newClient.getBirthDate())){
            client.orElseThrow(RuntimeException::new).setName(newClient.getName());
            client.orElseThrow(RuntimeException::new).setFirstLastname(newClient.getFirstLastname());
            client.orElseThrow(RuntimeException::new).setSecondLastname(newClient.getSecondLastname());
            client.orElseThrow(RuntimeException::new).setUsername(newClient.getUsername());
            client.orElseThrow(RuntimeException::new).setPassword(newClient.getPassword());
            client.orElseThrow(RuntimeException::new).setBirthDate(newClient.getBirthDate());
            client.orElseThrow(RuntimeException::new).setEmail(newClient.getEmail());
        }
        return clientRepository.save(client.orElse(new Client()));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

}
