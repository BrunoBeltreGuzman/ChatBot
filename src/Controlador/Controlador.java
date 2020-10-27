/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Comandos.Comandos;
import Modelo.DataDAO.Data;
import Modelo.Default.Default;
import Modelo.Pregunta.Pregunta;
import Modelo.Respuesta.IRespuesta;
import test.Pruebas.Respuesta;
import Vista.Ventanas.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author diosl
 */
public class Controlador implements ActionListener, KeyListener {

    private Ventana ventana;
    private Pregunta pregunta;
    private IRespuesta respuesta;
    private Comandos comandos;
    private Data data;

    private String[] cmdComandos = {
        "do-preguntas-f",
        "do-limpiar",
        "do-cerrar",
        "do-preguntas-v"
    };

    public Controlador(Ventana ventana, Pregunta pregunta, IRespuesta respuesta, Data data, Comandos comandos) {
        this.ventana = ventana;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.data = data;
        this.comandos = comandos;

        ventana.getBtnSend().addActionListener(this);
        ventana.getTextMessage().addKeyListener(this);

        respuesta.sendWelcome(ventana);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ventana.getBtnSend()) {
            pregunta.sendPregunta(ventana);

            if (data.getPregunta().startsWith("do-")) {
                for (int i = 0; i < cmdComandos.length; i++) {
                    if (data.getPregunta().equalsIgnoreCase(cmdComandos[i])) {
                        comandos.cmd(cmdComandos[i], ventana);
                        break;
                    }
                }
            } else {
                respuesta.sendRespuesta(data.getPregunta(), ventana);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == ventana.getTextMessage()) {
            if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                ventana.getBtnSend().doClick();
            }
        }
    }
}
