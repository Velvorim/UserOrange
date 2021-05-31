package com.userOrange.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fipe {
    
    private String nome;
    private String codigo;
    private ArrayList<Object> modelos = new ArrayList<Object>();
    private ArrayList<Object> anos = new ArrayList<Object>();
    
    @JsonProperty("Marca")
    private String marca;

    @JsonProperty("Modelo")
    private String modelo;

    @JsonProperty("AnoModelo")
    private String ano;

    @JsonProperty("Valor")
    private String valor;

    public Fipe(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Object> getModelos() {
        return modelos;
    }

    public void setModelos(ArrayList<Object> modelos) {
        this.modelos = modelos;
    }

    public ArrayList<Object> getAnos() {
        return anos;
    }

    public void setAnos(ArrayList<Object> anos) {
        this.anos = anos;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
