package com.oati.tecnologo.usermicroservice.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Client {
    private Long id;
    private String numberDocument;
    private double ratingCinepacho;
    private int points;
    public Client(){
    }
    public Client(Long id, String numberDocument, double ratingCinepacho, int points) {
        this.id = id;
        this.numberDocument = numberDocument;
        this.ratingCinepacho = ratingCinepacho;
        this.points = points;
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

    public double getRatingCinepacho() {
        return ratingCinepacho;
    }

    public void setRatingCinepacho(double ratingCinepacho) {
        this.ratingCinepacho = ratingCinepacho;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
