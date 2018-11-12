/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 20161BSI0012
 */
public class Monitor {
    
    public Monitor(){
    }
    
    public boolean disparaNotificacao(int freq, String nomePessoa,String nomeContato, String celular) throws Exception {
        //Exemplo de notificação que será enviada via sms e/ou e-mail
        
        if (freq < 0) {
                throw new Exception("Frequencia invalida. Verificar sensor de frequencia.");
            }
        
        String mensagem = "O paciente " + nomePessoa + " registrou uma frequencia cardiaca de " + freq + " bpm.";
        
        
        
        java.util.Date data = new Date();
        String dataF = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);        
        try{
            
            
            
            
            Notificacao notificacao = new Notificacao(nomePessoa,nomeContato, mensagem, dataF);
            
            System.out.println("Atenção! Notificacão enviada pois o paciente " + nomePessoa + " registrou uma frequência de " + freq + "bpm.");
            
            return true;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            
            return false;
        }        
        //JOptionPane.ShowMessageDialog(null, "Atenção! Notificacão enviada pois o paciente #xyz registrou uma frequência de " + freq + "bpm.");        
    }
    
    public void monitoraFrequencia(int freq, Pessoa pessoa,String nomeContato){        
        if ((freq < 60) || (freq > 100)){
            try {
                this.disparaNotificacao(freq, pessoa.getNome(),nomeContato, pessoa.getCelular());
            } catch (Exception ex) {
                Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
    public void simularFrequencia(){
        //Random freq = new Random();
        //ePssoa pessoa = new Pessoa(11, "Joaomanel","27 99969999");
//        String nomeContato = "Higor";
//        int timer = 0;
//        FrequenciaCardiaca freq = new FrequenciaCardiaca();
//        while(timer < 500)
//        {
//            freq.atualizarFrequencia(45 + (int)(Math.random() * (120 - 50)));
//            this.monitoraFrequencia(freq.getFrequencia(),pessoa, nomeContato);
//            timer++;
//        }        
    }
}
