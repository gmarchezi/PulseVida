/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

//import java.util.Random;

/**
 *
 * @author 
 */
public class FrequenciaCardiaca {
    private int frequencia;
    
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
