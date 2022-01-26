package com.entrevista.service;

import com.entrevista.entity.Loan;
import com.entrevista.repository.LoanRepository;
import com.entrevista.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.entrevista.utils.Asserts.validateAmount;

@Service
public class LoansService implements LoanService{

    private final LoanRepository loanRepository;

    public LoansService(LoanRepository loanRepository){
        this.loanRepository = loanRepository;
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public ResponseEntity<Loan> saveLoan(Loan loan){
        HttpStatus responseStatus;
        Loan responseLoan;
        if (findActiveByClient(loan.getIdClient()) == null && validateAmount(loan.getAmount())){
            responseStatus = HttpStatus.CREATED;
            responseLoan = loanRepository.save(loan);
        }
        else {
            responseStatus = HttpStatus.CONFLICT;
            responseLoan = loan;
        }
        return new ResponseEntity<>(responseLoan, responseStatus);
    }

    @Override
    public Loan findActiveByClient(Long idClient) {
        return loanRepository.findByIdClientAndStatus(idClient, Constants.LOAN_STATUS_ACTIVE);
    }


}
