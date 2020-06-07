/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor.Entities;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author JhonMZ
 */
public class Mensaje {
    private String mensaje;
    private Date fechaHora;

    public Mensaje(String mensaje, Date fechaHora) {
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
}
