/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

import java.util.ArrayList;
/**
 *
 * @author 
 */
public class Usuario extends Pessoa {
    private String email;
    private String senha;
    private ArrayList<FrequenciaCardiaca> historico;
    
    public Usuario(int id, String nome, String celular, String email, String senha,ArrayList<FrequenciaCardiaca> historico){
        super(id, nome, celular);
        this.email = email;
        this.senha = senha;
        this.historico = historico;
    }

    public ArrayList<FrequenciaCardiaca> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<FrequenciaCardiaca> historico) {
        this.historico = historico;
    }

    public Usuario(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
