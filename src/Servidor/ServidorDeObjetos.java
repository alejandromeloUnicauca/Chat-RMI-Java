package Servidor;

import Servidor.sop_rmi.ServidorAdminImp;
import Servidor.sop_rmi.ServidorUsuariosImp;
import Servidor.utilidades.UtilidadesConsola;
import servidor.utilidades.UtilidadesRMIServidor;

public class ServidorDeObjetos {
    public static void main(String args[])
    {         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
        System.out.print("Cual es el la dirección ip donde se encuentra  el rmiregistry:");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.print("Cual es el número de puerto por el cual escucha el rmiregistry:");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
        try
        {
            //objeto remoto para el usuario
            ServidorUsuariosImp objRemoto = new ServidorUsuariosImp();
            
            //objeto remoto para el admin
            ServidorAdminImp objRemoto2 = new ServidorAdminImp(objRemoto);
            
            UtilidadesRMIServidor.ArrancarNS(numPuertoRMIRegistry);
            
            //registro de los dos objetos remotos
            UtilidadesRMIServidor.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry,"servidorUsuarios");  
            UtilidadesRMIServidor.RegistrarObjetoRemoto(objRemoto2, direccionIpRMIRegistry, numPuertoRMIRegistry,"servidorAdmin");  
            System.out.println("Objeto remoto registrado, esperado peticiones ...");
        } catch (Exception e){
            System.err.println("No se pudo Arrancar el NS o Registrar el objeto remoto");
        }                
    }
}
