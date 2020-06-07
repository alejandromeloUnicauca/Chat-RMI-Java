/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author JhonMZ
 */
public class ServidorAdminImp extends UnicastRemoteObject implements IServidorAdmin{

    ServidorUsuariosImp objServidor;
    
    public ServidorAdminImp(ServidorUsuariosImp objServidor) throws RemoteException {
        super();
        this.objServidor = objServidor;
    }
    
    @Override
    public int usuariosConectados() throws RemoteException {
           return objServidor.getUsuariosConectados();
    }

    @Override
    public float mensajesPorMinuto() throws RemoteException {
        return objServidor.getMensajesPorMinuto();
    }
    
}
