package com.Dsi32g6.Covid19Application.Helper.UserHelper;

public class AppItem {

    String name,prenom,cin,etat;
    String min_price;
    String photo;

    public AppItem() {
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public AppItem(String name, String min_price, String photo) {
        this.name = name;
        this.min_price = min_price;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public AppItem(String name, String min_price) {
        this.name = name;
        this.min_price = min_price;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMin_price() {
        return min_price;
    }

    public void setMin_price(String min_price) {
        this.min_price = min_price;
    }

    @Override
    public String toString() {
        return "AppItem{" +
                "name='" + name + '\'' +
                ", min_price='" + min_price + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
