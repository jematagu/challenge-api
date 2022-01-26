package com.entrevista.controller;

import com.entrevista.entity.Client;
import com.entrevista.entity.Loan;
import com.entrevista.service.LoansService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    private final LoansService loansService;

    public LoanController(LoansService loansService) {
        this.loansService = loansService;
    }

    @GetMapping("/loans")
    public List<Loan> getAll(){
        return loansService.findAll();
    }

    @GetMapping("/loan")
    public Loan findActiveByClient(@RequestParam Long id){
        return loansService.findActiveByClient(id.longValue());
    }

    @PostMapping("/loan")
    public ResponseEntity<Loan> save(@RequestBody Loan loan) {
        return loansService.saveLoan(loan);
    }


}
