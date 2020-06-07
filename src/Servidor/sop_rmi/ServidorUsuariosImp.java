/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor.sop_rmi;

import Cliente.sop_rmi.ICliente;
import Servidor.Entities.Mensaje;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JhonMZ
 */
public class ServidorUsuariosImp extends UnicastRemoteObject implements IServidorUsuarios{
    
    Hashtable<String, ICliente> clientes;
    ArrayList<Mensaje> mensajes;
    
    public ServidorUsuariosImp() throws RemoteException {
        super();
        this.clientes = new Hashtable<>();
        this.mensajes = new ArrayList<>();
    }
    
    /**
     * @brief Agrega un nuevo usuario al hastable del servidor
     * @param usuario Referencia al objeto remoto del usuario
     * @param nickName Nombre del usuario
     * @return Retorna True si el usuario se registra o False si el NickName ya esta registrado
     * @throws RemoteException 
     */
    @Override
    public synchronized boolean registrarCliente(ICliente usuario, String nickName) throws RemoteException {
        boolean res = false;
        System.out.println("Registrando nuevo usuario...");
        if(clientes.get(nickName)==null){
            clientes.put(nickName, usuario);
            System.out.println("Usuario "+nickName+" Registrado");
            enviarUsuariosConectados();
            enviarUsuarioConectado(nickName);
            res = true;
        }else{
            System.out.println("El NickName "+nickName+" ya esta en uso");
            res = false;
        }
        System.out.println("");
        return res;
    }
    
    /**
     * @brief Envia a todos los usuarios la lista de usuarios conectados
     * @throws RemoteException 
     */
    private void enviarUsuariosConectados(){
        ArrayList<String> keys = new ArrayList<>(clientes.keySet());
        for (String key  : keys) {
            try {
                clientes.get(key).actualizarListaContactos(keys);
            } catch (RemoteException ex) {
                System.err.println("Usuario "+key+" desconectado.");
            }
        }
    }
    
    /**
     * Envia a todos los usuarios conectados el NickName del usuario que se conecto
     * @param nickName nombre del usuario
     * @throws RemoteException 
     */
    private void enviarUsuarioConectado(String nickName){
        Set<String> keys = clientes.keySet();
        ArrayList<String> desconectados = new ArrayList<>();
        for (String key  : keys) {
            if(!key.equals(nickName)){
                try {
                    clientes.get(key).fijarContacto(nickName);
                } catch (RemoteException ex) {
                    System.err.println("Usuario "+key+" desconectado");
                    desconectados.add(key);
                }
            }
        }
        if(desconectados.size()>0)desconectarUsuarios(desconectados);
    }

    @Override
    public synchronized void enviarMensaje(String mensaje, String nickName){
        System.out.println("Mensaje de "+nickName+":"+mensaje);
        mensajes.add(new Mensaje(mensaje, new Date()));
        System.out.println("Enviando mensaje a:");
        Set<String> keys = clientes.keySet();
        ArrayList<String> desconectados = new ArrayList<>();
        
        for (String key  : keys) {
            if(!key.equals(nickName)){
                try {
                    ICliente clienteTmp = clientes.get(key);
                    clienteTmp.recibirMensaje(nickName, mensaje);
                    System.out.println(key);
                } catch (RemoteException ex) {
                    System.err.println("Usuario "+key+" desconectado");
                    desconectados.add(key);
                }
            }
        }
        if(desconectados.size()>0)desconectarUsuarios(desconectados);
        System.out.println("");
    }
        
    private void desconectarUsuarios(ArrayList<String> desconectados){
        for (String nickName : desconectados) {
            try {
                desconectar(clientes.get(nickName), nickName);
            } catch (RemoteException ex) {
                Logger.getLogger(ServidorUsuariosImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //enviarUsuariosConectados();
    }
    
    @Override
    public synchronized boolean desconectar(ICliente usuario, String nickName) throws RemoteException {
        boolean res = false;
        System.out.println("Desconectando usuario "+nickName);
        res = clientes.remove(nickName, usuario);
        enviarUsuariosConectados();
        return res;
    }
    
    public int getUsuariosConectados(){
        System.out.println("Usuarios conectados:"+clientes.size());
        return clientes.size();
    }
    
    public float getMensajesPorMinuto(){
        float numMensajes = 0;
        if(mensajes.size() > 0){
            if(mensajes.size()==1){
                numMensajes = 1;
            }else{
                Date finicial = mensajes.get(0).getFechaHora();
                Date ffinal = mensajes.get(mensajes.size()-1).getFechaHora();
                long diff = ffinal.getTime()-finicial.getTime();
                double minutos = (double)(diff/1000)/60;
                minutos = (int)Math.ceil(minutos);
                numMensajes = (float) (mensajes.size()/minutos);
            }
        }
        System.out.println("Mensajes por minuto:"+numMensajes);
        return numMensajes;
    }
}
