/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Alejandro Feria
 */
public class Grupo {
    private String profesor, numeroGrupo;
    private String[] dias, horas;

    public Grupo(String profesor, String numeroGrupo , String[] dias, String[] horas) {
        this.profesor = profesor;
        this.numeroGrupo = numeroGrupo;
        this.dias = dias;
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "profesor: " + profesor + "\ndias: " + dias + "\nhoras: " + horas + "\n";
    }

    public String getProfesor() {
        return profesor;
    }

    public String[] getDias() {
        return dias;
    }

    public String[] getHoras() {
        return horas;
    }

    public String getNumeroGrupo() {
        return numeroGrupo;
    }

    /**
     * dia1: dd:dd
     * dia2: dd:dd
     * dia3: dd:dd
     */
    public String mostrarHorario() {
        int i = 0;
        String horarios = "";
        horarios += this.numeroGrupo + " - Profesor: " + this.profesor + "\n";
        //System.out.println(this.numeroGrupo + " - Profesor: " + this.profesor);
        for (String dia : dias) {
            horarios += dia + ": " + horas[i] + " a " + horas[i+1] + "\n";
            //System.out.println(dia + ": " + horas[i] + " a " + horas[i+1]);
            i += 2;
        }
        //System.out.println();
        horarios += "\n";
        return horarios;
    }
}
