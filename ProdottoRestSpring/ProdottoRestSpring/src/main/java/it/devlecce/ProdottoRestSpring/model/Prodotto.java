package it.devlecce.ProdottoRestSpring.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Prodotto {


        @Id
        @GeneratedValue
        private Long id;
        private String nome;
        private float prezzo;
        public Date datadinascita;

    public Prodotto(String nome, float prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public Prodotto(String nome, float prezzo, Date datadinascita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.datadinascita = datadinascita;
    }

    public Prodotto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public Date getDatadinascita() {
        return datadinascita;
    }

    public void setDatadinascita(Date datadinascita) {
        this.datadinascita = datadinascita;
    }

    public Prodotto(Long id, String nome, float prezzo, Date datadinascita) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.datadinascita = datadinascita;
    }
}


