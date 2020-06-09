/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
/**
 * Esta interfaz define los metodos para que el  servidor pueda hacer sus callbacks
 * @author JhonMZ
 */
public interface ICliente extends Remote{
    public void recibirMensaje(String nickName, String mensaje)throws RemoteException;
    public void actualizarListaContactos(ArrayList<String> Contactos)throws RemoteException;
    public void fijarContacto(String nickName)throws RemoteException;
}
