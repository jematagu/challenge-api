package com.entrevista.repository;

import com.entrevista.entity.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    List<Client> findAll();
    Client findByNameAndFirstLastnameAndSecondLastnameAndBirthDateAndUsername(
            String name, String firstLastname, String secondLastname, LocalDate birthDate, String username
    );

    Client findByUsername(String username);
}
