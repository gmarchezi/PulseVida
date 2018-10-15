/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pulsevida;

public class Notificacao {
    private String nomeUsuario;
    private String nomeContato;
    private String mensagem;
    private String dataHora;
    private String localizacao;
    
    public Notificacao(String nomeUsuario, String nomeContato, String mensagem, String dataHora, String localizacao){
        this.nomeUsuario = nomeUsuario;
        this.nomeContato = nomeContato;
        this.mensagem = mensagem;
        this.dataHora = dataHora;
        this.localizacao = localizacao;
    }
}
