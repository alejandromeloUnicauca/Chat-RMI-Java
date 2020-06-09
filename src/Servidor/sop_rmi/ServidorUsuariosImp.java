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
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase inplementa los  metodos de la interfaz IservidorUsuarios
 * @author JhonMZ
 */
public class ServidorUsuariosImp extends UnicastRemoteObject implements IServidorUsuarios{
    
    /*Hashtable para almacenar las referencias de los 
    usuarios que se conectan al servidor*/
    Hashtable<String, ICliente> clientes;
    /* 
    ArrayList para almacenar los mensajes que llegan al servidor
    */
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
     * Envia a todos los usuarios la lista de usuarios conectados
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
    
    /**
     * Recibe un mensaje de un usuario y lo reenvia a todos los usuarios conectados
     * @param mensaje mensaje del usuario
     * @param nickName nombre del usuario
     */
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
    
    /**
     * Desconecta todos los usuarios que estan en el ArrayList
     * @param desconectados ArrayList con los nickName de los usuarios que se van a desconectar
     */
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
    
    /**
     * Desconecta a un usuario
     * @param usuario referencia del objeto remoto del usuario
     * @param nickName nombre del usuario
     * @return retorna true si se remueve al cliente de la lista de usuarios o false de lo contrario
     * @throws RemoteException 
     */
    @Override
    public synchronized boolean desconectar(ICliente usuario, String nickName) throws RemoteException {
        boolean res = false;
        System.out.println("Desconectando usuario "+nickName);
        res = clientes.remove(nickName, usuario);
        enviarUsuariosConectados();
        return res;
    }
    
    /**
     * obtiene el numero de usuarios conectados
     * @return Cantidad de usuarios conectados
     */
    public int getUsuariosConectados(){
        System.out.println("Usuarios conectados:"+clientes.size());
        return clientes.size();
    }
    
    /**
     * Retorna el numero de mensajes por minuto que llegan al servidor
     * @return Cantidad de mensajes que llegan al servidor por minuto
     */
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
