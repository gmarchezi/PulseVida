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

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    
}
