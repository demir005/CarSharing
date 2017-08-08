package com.crud.entities;

import java.io.Serializable;

public class Posts implements Serializable {

    private int id;

    public String getMjestoPolaska() {
        return mjestoPolaska;
    }

    public void setMjestoPolaska(String mjestoPolaska) {
        this.mjestoPolaska = mjestoPolaska;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMjestoOdredista() {
        return mjestoOdredista;
    }

    public void setMjestoOdredista(String mjestoOdredista) {
        this.mjestoOdredista = mjestoOdredista;
    }

    public int getBrojMjesta() {
        return brojMjesta;
    }

    public void setBrojMjesta(int brojMjesta) {
        this.brojMjesta = brojMjesta;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    private String mjestoPolaska;
    private String mjestoOdredista;
    private int brojMjesta;
    private double cijena;



}
