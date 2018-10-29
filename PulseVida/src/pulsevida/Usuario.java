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
    
    public Usuario(String nome, String celular, String email, String senha){
        super(nome, celular);
        this.email = email;
        this.senha = senha;
    }
}
