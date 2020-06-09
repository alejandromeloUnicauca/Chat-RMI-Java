/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * En esta interfaz se definen los metodos para el cliente Administrador
 * @author JhonMZ
 */
public interface IServidorAdmin extends Remote{

    public int usuariosConectados()throws RemoteException;
    public float mensajesPorMinuto()throws RemoteException;
}
