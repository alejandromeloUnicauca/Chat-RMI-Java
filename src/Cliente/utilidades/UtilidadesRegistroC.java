/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.utilidades;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author David Calle
 */
public class UtilidadesRegistroC
{   
    
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