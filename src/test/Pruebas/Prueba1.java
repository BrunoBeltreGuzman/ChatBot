/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.Pruebas;

/**
 *
 * @author diosl
 */
public class Prueba1 {

    /*public static void main(String[] args) {
        String pregunta = "Hola";
        String preguntaBD = "Hola";

        System.out.println("Pregunta: " + pregunta);
        System.out.println("PreguntaBD: " + preguntaBD);

        int contador = 0;

        final int PORC = 100;
        int caracteres = 0;
        int total = 0;

        char arrayPregunta[] = pregunta.toCharArray();
        char arrayPreguntaBD[] = preguntaBD.toCharArray();

        System.out.println("Tamaño = " + arrayPregunta.length);

        for (int i = 0; i < arrayPregunta.length; i++) {

            for (int j = 0; j < arrayPreguntaBD.length; j++) {
                if (arrayPregunta[i] == arrayPreguntaBD[j]) {
                    System.out.println(arrayPregunta[i] + " == " + arrayPreguntaBD[j]);
                    contador++;
                }
            }
        }

        System.out.println("Clantidad de caracteres iguales: " + contador);

        System.out.println("");

        caracteres = contador;
        total = arrayPreguntaBD.length;
        System.out.println(caracteres);
        System.out.println(total);
        int porc = caracteres * PORC / total;
        System.out.println("Porcentaje = " + porc);
    }*/
    public int getPorcentaje(String pregunta) {
        String preguntaBD = "Hola, Hola?";

        String originPregunta = pregunta;
        String originPreguntaBD = preguntaBD;

        preguntaBD = preguntaBD.trim();
        preguntaBD = preguntaBD.replaceAll(" ", "");

        pregunta = pregunta.trim();
        pregunta = pregunta.replaceAll(" ", "");

        System.out.println("Pregunta: " + originPregunta);
        System.out.println("PreguntaBD: " + originPreguntaBD);

        final int PORC = 100;
        int caracteresIguales = 0;
        int totalDeCaracteres = 0;

        int contador = 0;

        char arrayPregunta[] = pregunta.toCharArray();
        char arrayPreguntaBD[] = preguntaBD.toCharArray();

        for (int i = 0; i < arrayPregunta.length; i++) {

            for (int j = 0; j < arrayPreguntaBD.length; j++) {
                if (arrayPregunta[i] == arrayPreguntaBD[j]) {
                    System.out.println(j + ") " + arrayPregunta[i] + " == " + arrayPreguntaBD[j]);
                    contador++;
                }
            }
        }

        caracteresIguales = contador;
        totalDeCaracteres = arrayPreguntaBD.length;
        int porcentaje = caracteresIguales * PORC / totalDeCaracteres;

        System.out.println("Caracteres igulales (pregunta): " + caracteresIguales);
        System.out.println("Total de caracteres (preguntaBD): " + totalDeCaracteres);

        return porcentaje;

    }

    public static void main(String[] args) {
        int porc = new Prueba1().getPorcentaje("Hola");
        System.out.println(porc + "%");
    }

}
