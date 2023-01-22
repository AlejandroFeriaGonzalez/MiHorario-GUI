/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author Alejandro Feria
 */
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraerDatos {
    public static String extraerProfesor(String linea) {
        char[] arrayLinea = linea.toCharArray();
        int lenghtNombre = (linea.length()-1) - 10;
        char[] arraynombre = new char[lenghtNombre];
        int j = 0;

        for (int i = 10; i < linea.length() - 1; i++) { //menos 1 para quitar punto
            arraynombre[j] = arrayLinea[i];
            j++;
        }

        return String.valueOf(arraynombre);
    }



    public static String buscarDiaSemana(String p) {
        String[] diasSemana = {"LUNES", "MARTES", "MIÉRCOLES", "JUEVES", "VIERNES", "SÁBADO", "DOMINGO"};
        for (String diaSemana : diasSemana) {
            if (p.contains(diaSemana)) {
                return diaSemana;
            }
        }
        return "";
    }

    public static String[][] extraerHorario(String linea) {
        String[] arrayLinea = linea.split(" ");
        ArrayList<String> listaDias = new ArrayList<String>();
        ArrayList<String> listaHoras = new ArrayList<String>();
        Pattern patronHora = Pattern.compile("\\d\\d:\\d\\d"); //00:00
        Matcher matcherHora;


        for (String p : arrayLinea) {
            // System.out.println(p);
            //* devuelve dia de un parrafo
            if (!buscarDiaSemana(p).isEmpty()) {
                listaDias.add(buscarDiaSemana(p));
            };
            
            //* da las horas de un grupo
            matcherHora = patronHora.matcher(p);
            if (matcherHora.find()) {
                listaHoras.add(matcherHora.group());
            }
        }

        String arrayDias[] = crearArray(listaDias);
        String arrayhoras[] = crearArray(listaHoras);

        String[][] output = {arrayDias, arrayhoras};
        return output;
    }

    public static String[] crearArray(ArrayList<String> lista) {
        String[] array = new String[lista.size()];
        array = lista.toArray(array);
        return array;
    }


    }
