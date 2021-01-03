package com.Dsi32g6.Covid19Application.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class Patient implements Parcelable {
    String cin,nom,prenom,test,dateString;
    int periode;
    Date dateTest;

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    protected Patient(Parcel in) {
        cin = in.readString();
        nom = in.readString();
        prenom = in.readString();
        test = in.readString();
        periode = in.readInt();
        dateString=in.readString();
     //   dateTest=in.readString();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

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

    public Patient(String cin, String nom, String prenom, int periode,String test, Date dateTest,String dateString) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.periode = periode;
        this.test = test;
        this.dateTest = dateTest;
        this.dateString=dateString;
    }
    public Patient()
    {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cin);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(test);
        dest.writeInt(periode);
        dest.writeString(dateString);
        dest.writeString(String.valueOf(dateTest));
    }
}
