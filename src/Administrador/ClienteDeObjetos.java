package Administrador;


import Administrador.vista.GUIAdmin;
import Cliente.utilidades.UtilidadesRegistroC;
import Servidor.sop_rmi.IServidorAdmin;
import Servidor.utilidades.UtilidadesConsola;
import java.awt.Color;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDeObjetos
{

	private static IServidorAdmin objRemoto;
        
	public static void main(String[] args)
	{
            int numPuertoRMIRegistry = 0;
            String direccionIpRMIRegistry = "";        
               
            System.out.print("Cual es el la dirección ip donde se encuentra  el rmiregistry:");
            direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
            System.out.print("Cual es el número de puerto por el cual escucha el rmiregistry:");
            numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
            
            //se obtiene la referencia al objeto remoto del servidor
            objRemoto = (IServidorAdmin) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,numPuertoRMIRegistry, "servidorAdmin");
            
            GUIAdmin objGui = new GUIAdmin(objRemoto);
            objGui.getContentPane().setBackground(Color.darkGray);
            objGui.setVisible(true);
                
            //Descomentar la linea de menu y comentar las 3 lineas anteriores si se quiere probar 
            //por medio de la consola
            //MenuPrincipal();
		
	}
	
	
	private static void MenuPrincipal()
	{
		int opcion = 0;
		do
		{
			System.out.println("==Menu==");
			System.out.println("1. Consultar usuarios conectados");			
			System.out.println("2. Consultar mensajes por minuto");
			System.out.println("3. Salir");
			
			opcion = UtilidadesConsola.leerEntero();
			
			switch(opcion)
			{
				case 1:
					Opcion1();
					break;
				case 2:
					Opcion2();
					break;
				case 3:
					System.out.println("Salir...");
					break;
				default:
					System.out.println("Opción incorrecta");
			}
			
		}while(opcion != 4);
	}

	private static void Opcion1() 
	{
            try {
                int usuarios = objRemoto.usuariosConectados();
                System.out.println("Usuarios conectados:"+usuarios);
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

        private static void Opcion2() 
	{
            try {
                float mensajes = objRemoto.mensajesPorMinuto();
                System.out.println("Mensajes por minuto:"+mensajes);
            } catch (RemoteException ex) {
                Logger.getLogger(ClienteDeObjetos.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}

