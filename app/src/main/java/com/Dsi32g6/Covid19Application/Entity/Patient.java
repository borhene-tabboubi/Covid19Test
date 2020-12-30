package com.Dsi32g6.Covid19Application.Entity;

import java.util.Date;

public class Patient {
    String cin,nom,prenom,test;
    int periode;
    Date dateTest;

    @Override
    public String toString() {
        return "Patient{" +
                "cin='" + cin + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", test='" + test + '\'' +
                ", periode=" + periode +
                ", dateTest=" + dateTest +
                '}';
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public void setPeriode(int periode) {
        this.periode = periode;
    }

    public void setDateTest(Date dateTest) {
        this.dateTest = dateTest;
    }

    public String getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTest() {
        return test;
    }

    public int getPeriode() {
        return periode;
    }

    public Date getDateTest() {
        return dateTest;
    }

    public Patient(String cin, String nom, String prenom, int periode,String test, Date dateTest) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.periode = periode;
        this.test = test;
        this.dateTest = dateTest;
    }
    public Patient()
    {

    }
}
