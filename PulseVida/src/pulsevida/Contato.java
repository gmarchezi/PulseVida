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
public class Contato extends Pessoa {
    int id_usuario;
    
    public Contato(int id, int id_usuario, String nome, String email, String celular){
        super(id, nome, email, celular);
        this.id_usuario = id_usuario;
    }  

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Contato(){};
}