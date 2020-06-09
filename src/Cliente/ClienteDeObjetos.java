package Cliente;


import Cliente.utilidades.UtilidadesRegistroC;
import Cliente.vista.GUICliente;
import Servidor.sop_rmi.IServidorUsuarios;
import Servidor.utilidades.UtilidadesConsola;
import java.awt.Color;

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
            
            //se obtiene la referencia al objeto remoto del servidor
            objRemoto = (IServidorUsuarios) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "servidorUsuarios");
            GUICliente objGUICliente = new GUICliente(objRemoto);
            objGUICliente.getContentPane().setBackground(Color.DARK_GRAY);
            objGUICliente.setVisible(true);
            
        }
}

