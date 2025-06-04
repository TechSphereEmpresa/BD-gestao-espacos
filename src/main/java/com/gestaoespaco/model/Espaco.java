package com.gestaoespaco.model;

public class Espaco {

    private Long id;
    private String nome;
    private String tipo;
    private String localizacao;
    private double metragem;
    private Integer capacidade;

    public Espaco() {
    }

    public Espaco(String nome, String tipo, String localizacao, double metragem, Integer capacidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.localizacao = localizacao;
        this.metragem = metragem;
        this.capacidade = capacidade;
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
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public double getMetragem() {
        return metragem;
    }
    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }
    public Integer getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

}
