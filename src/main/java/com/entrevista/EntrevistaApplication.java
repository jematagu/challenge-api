package com.entrevista;

import com.entrevista.repository.ClientRepository;
import com.entrevista.repository.LoanRepository;
import com.entrevista.repository.ProductRepository;
import com.entrevista.service.ClientService;
import com.entrevista.service.LoanService;
import com.entrevista.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EntrevistaApplication{

	private ClientService clientService;
	private ClientRepository clientRepository;
	private LoanService loanService;
	private LoanRepository loanRepository;
	private ProductService productService;
	private ProductRepository productRepository;

	public EntrevistaApplication(ClientService clientService,
								 ClientRepository clientRepository,
								 LoanService loanService,
								 LoanRepository loanRepository,
								 ProductService productService,
								 ProductRepository productRepository) {
		this.clientService = clientService;
		this.clientRepository = clientRepository;
		this.loanService = loanService;
		this.loanRepository = loanRepository;
		this.productService = productService;
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EntrevistaApplication.class, args);
	}
}
