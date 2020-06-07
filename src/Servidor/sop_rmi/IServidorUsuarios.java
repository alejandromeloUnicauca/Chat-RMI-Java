/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor.sop_rmi;

import Cliente.sop_rmi.ICliente;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author JhonMZ
 */
public interface IServidorUsuarios extends Remote{
    public boolean registrarCliente(ICliente usuario, String nickName)throws RemoteException;
    public void enviarMensaje(String mensaje,String nickName)throws RemoteException;
    public boolean desconectar(ICliente usuario, String nickName)throws RemoteException;
}
