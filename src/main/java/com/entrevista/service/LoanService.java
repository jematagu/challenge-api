package com.entrevista.service;

import com.entrevista.entity.Loan;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LoanService {
    List<Loan> findAll();
    Loan findActiveByClient(Long idClient);
    ResponseEntity<Loan> saveLoan(Loan loan);
}
