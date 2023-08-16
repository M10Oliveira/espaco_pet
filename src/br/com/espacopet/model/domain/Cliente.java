/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.espacopet.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Matheus Oliveira
 */
public class Cliente {
    
    private int id;
    private String nome;
    private String nomeTutor;
    private String endereco;
    private String celular;
    private String raca;
    private LocalDate dataRegistro;

    public Cliente() {
    }
    
    

    public Cliente(int id, String nome, String nomeTutor, String endereco, String celular, String raca, LocalDate dataRegistro) {
        this.id = id;
        this.nome = nome;
        this.nomeTutor = nomeTutor;
        this.endereco = endereco;
        this.celular = celular;
        this.raca = raca;
        this.dataRegistro = dataRegistro;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }
    
    
    
    
}
