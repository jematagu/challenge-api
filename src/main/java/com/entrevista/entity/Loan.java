package com.entrevista.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    private Integer amount;

    @Column(name = "id_client")
    private Long idClient;

    @Column(length = 50)
    private String status;

    @Column(name = "date")
    private LocalDate date;

    public Loan(){}

    public Loan(Long id, Integer amount, Long idClient, String status, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.idClient = idClient;
        this.status = status;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", amount=" + amount +
                ", idClient='" + idClient + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
