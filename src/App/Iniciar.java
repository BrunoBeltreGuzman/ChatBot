/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.Controlador;
import Modelo.Comandos.Comandos;
import Modelo.DataDAO.Data;
import Modelo.Pregunta.Pregunta;
import Modelo.Respuesta.RespuestaCoincidencia;
import Modelo.Respuesta.RespuestaExacta;
import Modelo.Respuesta.RespuestaFrecuencia;
import Modelo.Respuesta.RespuestaLike;
import Modelo.Respuesta.RespuestaValoracion;
import test.Pruebas.Respuesta;
import Vista.Ventanas.Ventana;

/**
 *
 * @author diosl
 */
public class Iniciar {

    public static void iniciar() {
        //Vistas
        Ventana ventana = new Ventana();

        //Modelos
        Data data = new Data();
        Pregunta pregunta = new Pregunta(data);

        //Respuesta respuesta = new Respuesta(data);
        RespuestaLike respuestaLike = new RespuestaLike(ventana, data);
        RespuestaExacta respuestaExacta = new RespuestaExacta(ventana, data);
        RespuestaValoracion respuestaValoracion = new RespuestaValoracion(ventana, data);
        RespuestaFrecuencia respuestaFrecuencia = new RespuestaFrecuencia(ventana, data);
        RespuestaCoincidencia respuestaCoincidencia = new RespuestaCoincidencia(ventana, data);
        Comandos comandos = new Comandos(data);

        //Controladores
        Controlador controlador = new Controlador(ventana, pregunta, respuestaLike, data, comandos);

        //Iniciar
        ventana.setVisible(true);
    }

}
