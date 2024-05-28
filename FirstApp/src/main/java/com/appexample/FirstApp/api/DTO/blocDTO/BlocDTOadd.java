package com.appexample.FirstApp.api.DTO.blocDTO;

public class BlocDTOadd {
    long id;
    String nume;
    String numeStrada;
    int numar;
    String scara;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getNumeStrada() {
        return numeStrada;
    }

    public void setNumeStrada(String numeStrada) {
        this.numeStrada = numeStrada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getScara() {
        return scara;
    }

    public void setScara(String scara) {
        this.scara = scara;
    }
}
