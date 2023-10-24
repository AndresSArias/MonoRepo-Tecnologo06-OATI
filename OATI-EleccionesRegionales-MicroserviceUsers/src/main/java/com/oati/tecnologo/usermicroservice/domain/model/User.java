package com.oati.tecnologo.usermicroservice.domain.model;

public class User {

    private Long id;
    private String numberDocument;
    private String name;
    private String password;
    private Role role;

    public User() {

    }
    public User(Long id, String numberDocument, String name, String password, Role role) {
        this.id = id;
        this.numberDocument = numberDocument;
        this.name = name;
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
