/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

import javax.swing.JOptionPane;

/**
 *
 * @author 20161BSI0012
 */
public class Monitor {
    
    public Monitor(){
    }
    
    public void disparaNotificacao(int freq){
        //Exemplo de notificação que será enviada via sms e/ou e-mail.
        //Notificacao notificacao = new Notificacao(nomeUsuario, celularContato, mensagem, dataHora, localizacao);
        System.out.println("Atenção! Notificacão enviada pois o paciente #xyz registrou uma frequência de " + freq + "bpm.");
        //JOptionPane.ShowMessageDialog(null, "Atenção! Notificacão enviada pois o paciente #xyz registrou uma frequência de " + freq + "bpm.");
    }
    
    public void monitoraFrequencia(int freq){        
        if ((freq < 60) || (freq > 100)){
            this.disparaNotificacao(freq);
        }
    }    
    
    public void simularFrequencia(){
        //Random freq = new Random();
        int timer = 0;
        FrequenciaCardiaca freq = new FrequenciaCardiaca();
        while(timer < 500)
        {
            freq.atualizarFrequencia(45 + (int)(Math.random() * (120 - 50)));
            this.monitoraFrequencia(freq.getFrequencia());
            timer++;
        }        
    }
}
