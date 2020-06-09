/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrador.utilidades;

import java.rmi.Naming;
import java.rmi.Remote;

public class UtilidadesRegistroC
{   
    /**
     * Retorna una referencia del objeto remoto
     * @param dirIP direccion ip el RMI registry
     * @param puerto puerto del RMI registry
     * @param nameObjReg Nombre del objeto remoto 
     * @return Retorna una referencia del objeto remoto o null si no se encuentra el objeto
     */
    public static Remote obtenerObjRemoto(String dirIP,int puerto, String nameObjReg)
    {
        String URLRegistro;
        URLRegistro  = "rmi://" + dirIP + ":" + puerto + "/"+nameObjReg;
        try
        {
            return Naming.lookup(URLRegistro);
        }
        catch (Exception e)
        {
            System.out.println("Excepcion en obtencion del objeto remoto"+ e);
            return null;
        }
    }
    
}