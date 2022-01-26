package com.entrevista.beans;

import java.time.LocalDate;

public class Session {
    private Long id;

    private String name;

    private String username;

    private String email;

    private String firstLastname;

    private String secondLastname;

    private LocalDate birthDate;

    public Session() {
    }

    public Session(Long id, String name, String username, String email, String firstLastname, String secondLastname, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstLastname() {
        return firstLastname;
    }

    public void setFirstLastname(String firstLastname) {
        this.firstLastname = firstLastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstLastname='" + firstLastname + '\'' +
                ", secondLastname='" + secondLastname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
