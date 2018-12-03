/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

//import java.util.Random;

/**
 *
 * @author teste teste
 */
public class FrequenciaCardiaca {
    private int frequencia;
    private String data;
    private String hora;
    
    public FrequenciaCardiaca() {
        
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    
    public void atualizarFrequencia(int frequencia){
        this.frequencia = getFrequencia();
        setFrequencia(frequencia);
    }    

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    
    
}
