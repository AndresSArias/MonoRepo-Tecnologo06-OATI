package com.oati.tecnologo.usermicroservice.domain.model;

import java.time.LocalDate;

public class Member {
    private Long id;
    private String numberDocument;
    private String codeEmployee;
    private long idMultiplex;
    private int salary;
    private LocalDate dateContract;
    private String password;

    public Member(Long id, String numberDocument, String codeEmployee, long idMultiplex, int salary, LocalDate dateContract, String password) {
        this.id = id;
        this.numberDocument = numberDocument;
        this.codeEmployee = codeEmployee;
        this.idMultiplex = idMultiplex;
        this.salary = salary;
        this.dateContract = dateContract;
        this.password = password;
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

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public long getIdMultiplex() {
        return idMultiplex;
    }

    public void setIdMultiplex(long idMultiplex) {
        this.idMultiplex = idMultiplex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getDateContract() {
        return dateContract;
    }

    public void setDateContract(LocalDate dateContract) {
        this.dateContract = dateContract;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
