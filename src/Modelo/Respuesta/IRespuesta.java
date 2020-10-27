/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Respuesta;

import Vista.Ventanas.Ventana;

/**
 *
 * @author diosl
 */
public interface IRespuesta {

    public void sendRespuesta(String pregunta, Ventana ventana);

    public String getRespuesta(String pregunta);

    public void sendWelcome(Ventana ventana);
}
