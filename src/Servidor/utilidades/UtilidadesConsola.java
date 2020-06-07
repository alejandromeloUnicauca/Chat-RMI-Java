
package Servidor.utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UtilidadesConsola
{
    public static Integer leerEntero(){
    	String linea = "";
    	Integer num = 0;
        try
        {
            BufferedReader br = new BufferedReader(new
            InputStreamReader(System.in));
            linea = br.readLine();
            num = Integer.parseInt(linea);
        }
        catch(Exception e)
        {
                System.out.println("Error intente nuevamente...");
                num = null;
        }
    	return num;
    }
	
	public static String leerCadena()
    {
    	String linea = "";
    	boolean valido = false;
    	do
    	{
    		try
    		{
                    BufferedReader br = new BufferedReader(new
                    InputStreamReader(System.in));
                    linea = br.readLine();
                    valido = true;
    		}
    		catch(Exception e)
    		{
    			System.out.println("Error intente nuevamente...");
    			valido = false;
    		}
    	}while(!valido);
    	return linea;
    }
}

