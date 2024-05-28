package com.appexample.FirstApp.domain.apartament;

import jakarta.persistence.*;

@Entity
@Table
public class Apartament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    int etaj;
    String scaraBloc;
    int numar;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getEtaj() {
        return etaj;
    }

    public void setEtaj(int etaj) {
        this.etaj = etaj;
    }

    public String getScaraBloc() {
        return scaraBloc;
    }

    public void setScaraBloc(String scaraBloc) {
        this.scaraBloc = scaraBloc;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }
}
