/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DataDAO;

/**
 *
 * @author diosl
 */
public class Data {

    private String pregunta;

    private String respuesta;

    private String message;

    private String messageDefault;

    private String tab = "                                                      ";

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDefault() {
        return messageDefault;
    }

    public void setMessageDefault(String messageDefault) {
        this.messageDefault = messageDefault;
    }

    public String getTab() {
        return tab;
    }
}
