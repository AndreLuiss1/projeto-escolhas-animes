package com.filme.crm;


public class Anime {
    private String titulo;
    private String genero;
    private int ano;
    private int episodios;
    private boolean filme;

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

