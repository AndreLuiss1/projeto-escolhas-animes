package com.filme.crm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private int ano;
    private int episodios;
    private boolean filme;

    // Construtores, getters e setters

    public Anime() {
        // Construtor padrão necessário para deserialização JSON
    }

    public Anime(String titulo, String genero, int ano, int episodios, boolean filme) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
        this.episodios = episodios;
        this.filme = filme;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public boolean isFilme() {
        return filme;
    }

    public void setFilme(boolean filme) {
        this.filme = filme;
    }
}
