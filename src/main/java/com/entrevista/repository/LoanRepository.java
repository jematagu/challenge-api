package com.entrevista.repository;

import com.entrevista.entity.Loan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LoanRepository extends PagingAndSortingRepository<Loan, Long> {
    List<Loan> findAll();

    Loan findByIdClientAndStatus(Long idClient, String status);
}
