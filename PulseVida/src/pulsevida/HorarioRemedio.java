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
    String horario;
    
    public HorarioRemedio(String nomeRemedio, float dose, String diaSemana, String horario){
        this.nomeRemedio = nomeRemedio;
        this.dose = dose;
        this.diaSemana = diaSemana;
        this.horario = horario;

    }

    public void notificaRemedio(String horario, String nomeRemedio, float dose){
        System.out.println("São " + horario + " horas, você deve tomar o remédio " + nomeRemedio + " de " + dose + " mg!" );
    }

    public String getNomeRemedio() {
        return nomeRemedio;
    }

    public float getDose() {
        return dose;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setNomeRemedio(String nomeRemedio) {
        this.nomeRemedio = nomeRemedio;
    }

    public void setDose(float dose) {
        this.dose = dose;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    
    
    
}
