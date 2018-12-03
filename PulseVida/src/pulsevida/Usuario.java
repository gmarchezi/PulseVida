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
    private String login;
    private String senha;
    private ArrayList<FrequenciaCardiaca> historico;
    
    public Usuario(String nome, String celular, String email, String login, String senha,ArrayList<FrequenciaCardiaca> historico){
        super(nome, email, celular);
        this.login = login;
        this.senha = senha;
        this.historico = historico;
    }
    public Usuario(){}
     
    public ArrayList<FrequenciaCardiaca> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<FrequenciaCardiaca> historico) {
        this.historico = historico;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
