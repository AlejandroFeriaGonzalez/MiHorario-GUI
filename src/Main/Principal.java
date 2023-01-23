/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Alejandro Feria
 */
public class Principal {

    public String leerInput(String[] arrayLineas, String nombreProfesor) {
        String profesor = "";
        String[] dias;
        String[] horas;
        String grupoProfesor = "";

        Pattern patronGrupo = Pattern.compile("Grupo \\d{1,2}", Pattern.CASE_INSENSITIVE); //patron grupo

        ArrayList<Grupo> listaGrupo = new ArrayList<Grupo>();

        ArrayList<String> listaProfesores = new ArrayList<String>();
        ArrayList<String> listagrupoProfesor = new ArrayList<String>();
        ArrayList<String[]> listaDias = new ArrayList<String[]>();
        ArrayList<String[]> listaHoras = new ArrayList<String[]>();
        
        
        for (int i = 0; i < arrayLineas.length; i++) {
            String linea = arrayLineas[i];
            
            //codigo pegado
            if (linea == null) {continue;}

            if (linea.contains("Profesor")) {
                profesor = ExtraerDatos.extraerProfesor(linea);
                listaProfesores.add(profesor);
            }

            Matcher matcherGrupo = patronGrupo.matcher(linea);
            if (matcherGrupo.find()) {
                grupoProfesor = matcherGrupo.group();
                listagrupoProfesor.add(grupoProfesor);
            }

            if (linea.contains("Horarios")) {
                String[][] matrizHorario = ExtraerDatos.extraerHorario(linea);
                dias = matrizHorario[0];
                listaDias.add(dias);

                horas = matrizHorario[1];
                listaHoras.add(horas);
            }
            
        }
        // todas las listas tienen el mismo tamaño
        for (int i = 0; i < listagrupoProfesor.size(); i++) {
            listaGrupo.add(new Grupo(listaProfesores.get(i), listagrupoProfesor.get(i), listaDias.get(i), listaHoras.get(i)));
        }
        
        String horarioFinal = "";
        for (Grupo grupo : listaGrupo) {
            if (nombreProfesor.isEmpty()) {
                horarioFinal += grupo.mostrarHorario();
            } else {
                if (grupo.getProfesor().contains(nombreProfesor)) {
                    horarioFinal += grupo.mostrarHorario();
                }
            }
            

        }

        return horarioFinal;
    }
    
}
