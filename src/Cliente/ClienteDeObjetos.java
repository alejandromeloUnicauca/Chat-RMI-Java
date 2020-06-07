package Cliente;


import Administrador.*;
import Administrador.vista.GUIAdmin;
import Cliente.utilidades.UtilidadesRegistroC;
import Cliente.vista.GUICliente;
import Servidor.sop_rmi.IServidorAdmin;
import Servidor.sop_rmi.IServidorUsuarios;
import Servidor.utilidades.UtilidadesConsola;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDeObjetos
{

	private static IServidorUsuarios objRemoto;
        
	public static void main(String[] args)
	{
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";        
               
            System.out.print("Cual es el la dirección ip donde se encuentra  el rmiregistry:");
            direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
            System.out.print("Cual es el número de puerto por el cual escucha el rmiregistry:");
            numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
            
            objRemoto = (IServidorUsuarios) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "servidorUsuarios");
            GUICliente objGUICliente = new GUICliente(objRemoto);
            objGUICliente.getContentPane().setBackground(Color.DARK_GRAY);
            objGUICliente.setVisible(true);
            //MenuPrincipal();
		
        }
}

