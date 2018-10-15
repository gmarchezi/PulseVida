/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

/**
 *
 * @author 20161BSI0012
 */
public class PulseVida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Monitor pulseira = new Monitor();
        HorarioRemedio remedio = new HorarioRemedio("Atlansil", 200, "terca/quinta", "21:00");
        pulseira.simularFrequencia();
        remedio.notificaRemedio();
    }
    
}
