package com.wikimedieval.model;

public class Midia {
    private int id;
    private String titulo;
    private String tipo;
    private String descricao;
    private String autor_diretor;
    private int ano_lancamento;

    public Midia( String titulo, String tipo, String descricao, String autor_diretor, int ano_lancamento) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.autor_diretor = autor_diretor;
        this.ano_lancamento = ano_lancamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutor_diretor() {
        return autor_diretor;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }
}