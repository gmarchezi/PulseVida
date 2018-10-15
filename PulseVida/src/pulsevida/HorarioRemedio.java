/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pulsevida;

/**
 *
 * @author i5
 */
public class HorarioRemedio {
    private String nomeRemedio;
    private float dose;
    private String diaSemana;
    private String horario;
    
    public HorarioRemedio(String nomeRemedio, float dose, String diaSemana, String horario){
        this.nomeRemedio = nomeRemedio;
        this.dose = dose;
        this.diaSemana = diaSemana;
        this.horario = horario;

    }

    public void notificaRemedio(){
        System.out.println("São " + horario + " horas, você deve tomar o remédio " + nomeRemedio + " de " + dose + " mg!" );
    }

}
