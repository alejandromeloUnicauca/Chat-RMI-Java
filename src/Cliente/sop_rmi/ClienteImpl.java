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
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JhonMZ
 */
public class ClienteImpl extends UnicastRemoteObject implements ICliente{
    
    private GUICliente objGUICliente;

    public ClienteImpl(GUICliente objGUICliente) throws RemoteException {
        super();
        this.objGUICliente = objGUICliente;
    }

    @Override
    public void recibirMensaje(String nickName, String mensaje) throws RemoteException {
        objGUICliente.fijarTexto(nickName+":"+mensaje+"-"+LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss yyyy/MM/dd")));
    }

    @Override
    public void actualizarListaContactos(ArrayList<String> Contactos) throws RemoteException {
        objGUICliente.fijarContactos(Contactos);
    }

    @Override
    public void fijarContacto(String nickName) throws RemoteException {
        try {
            objGUICliente.fijarContacto(nickName);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClienteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
