/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Esta clase implementa los metodos de la interfaz IServidorAdmin
 * @author JhonMZ
 */
public class ServidorAdminImp extends UnicastRemoteObject implements IServidorAdmin{

    ServidorUsuariosImp objServidor;
    
    public ServidorAdminImp(ServidorUsuariosImp objServidor) throws RemoteException {
        super();
        this.objServidor = objServidor;
    }
    
    /**
     * Retorna la cantidad de usuarios conectados al chat
     * @return Cantidad de usuarios conectados
     * @throws RemoteException 
     */
    @Override
    public int usuariosConectados() throws RemoteException {
           return objServidor.getUsuariosConectados();
    }

    /**
     * Retorna los mensajes que llegan al servidor por minuto
     * @return Cantidad de mensajes por minuto
     * @throws RemoteException 
     */
    @Override
    public float mensajesPorMinuto() throws RemoteException {
        return objServidor.getMensajesPorMinuto();
    }
    
}
