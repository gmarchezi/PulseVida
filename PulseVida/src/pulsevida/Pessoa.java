/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

/**
 *
 * @author 
 */
public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private String celular;
    
    public Pessoa(){}
    
    public Pessoa(int id, String nome, String email, String celular){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.celular = celular;
    }
    
    public Pessoa(String nome, String celular, String email){
        this.nome = nome;
        this.celular = celular;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
