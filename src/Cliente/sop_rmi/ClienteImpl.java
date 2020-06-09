/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente.sop_rmi;

import Cliente.vista.GUICliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase implementa la interfaz ICliente para que los usuarios puedan conectarse
 * y enviar mensajes
 * @author JhonMZ
 */
public class ClienteImpl extends UnicastRemoteObject implements ICliente{
    
    private GUICliente objGUICliente;

    public ClienteImpl(GUICliente objGUICliente) throws RemoteException {
        super();
        this.objGUICliente = objGUICliente;
    }

    /**
     * Recibe un mensaje del servidor
     * @param nickName Nombre del usuario que envio el mensaje al servidor
     * @param mensaje Mensaje del usuario
     * @throws RemoteException 
     */
    @Override
    public void recibirMensaje(String nickName, String mensaje) throws RemoteException {
        objGUICliente.fijarTexto(nickName+":"+mensaje+"-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd")));
    }
    
    /**
     * Recibe una lista de los usuarios conectados y actualiza la GUI
     * con los usuarios que hay en linea
     * @param Contactos arrayList de usuarios conectados
     * @throws RemoteException 
     */
    @Override
    public void actualizarListaContactos(ArrayList<String> Contactos) throws RemoteException {
        objGUICliente.fijarContactos(Contactos);
    }

    /**
     * Recibe el nickName de un usuario que se acaba de conectar 
     * e invoca un metodo para mostrar una notificacion
     * @param nickName nombre del usuario que se conecto
     * @throws RemoteException 
     */
    @Override
    public void fijarContacto(String nickName) throws RemoteException {
        try {
            objGUICliente.fijarContacto(nickName);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
