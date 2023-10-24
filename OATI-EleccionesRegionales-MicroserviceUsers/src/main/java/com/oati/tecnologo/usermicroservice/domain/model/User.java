package com.oati.tecnologo.usermicroservice.domain.model;

import java.time.LocalDate;


public class User {

    private Long id;
    private String numberDocument;
    private String name;
    private LocalDate dateBirth;
    private String phone;
    private String email;
    private Role role;

    public User() {

    }
    public User(Long id, String numberDocument, String name, LocalDate dateBirth, String phone, String email, Role role) {
        this.id = id;
        this.numberDocument = numberDocument;
        this.name = name;
        this.dateBirth = dateBirth;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
