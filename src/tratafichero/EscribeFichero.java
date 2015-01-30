package tratafichero;

import java.io.FileWriter;
import java.io.RandomAccessFile;

/**
* EscribeFichero: Clase para Escritura de ficheros
*    @author  IceDrek
*    @version 0.1
*/
public class EscribeFichero {
	//Declaración e inicialización de las variables utilizadas.
		private String           fichero = null;
	    private FileWriter       fw      = null;
	    private RandomAccessFile raf     = null;

	    /**
	     * Constructor de clase:
	     *    @param  fichero    Nombre del fichero a tratar
	     */
	    public EscribeFichero(String fichero)
	    {
	    	this.fichero = fichero;
	    }	    
	    
	    

	    public void escribeLinea(String linea)
	    {
	    	try
	    	{
	    		fw = new FileWriter(fichero, true);
	    		fw.write(linea);
				
				fw.flush();
				fw.close();
				
	    	} catch (Exception e) {
	    		System.out.println("ERROR: " + e.getMessage());
	    		e.printStackTrace();
	    	}
	    }
	    
	    public void escribeLinea(String linea, int posicion)
	    {
	    	try
	    	{	            
	            // Abrimos el fichero de acceso aleatorio
	            raf = new RandomAccessFile(fichero,"rw");
	            // Nos vamos al final del fichero
	            raf.seek(posicion);
	            // Incorporamos la cadena al fichero     
	            raf.writeBytes(linea);
	            // Cerramos el fichero
	            raf.close();
	            
				
	    	} catch (Exception e) {
	    		System.out.println("ERROR: " + e.getMessage());
	    		e.printStackTrace();
	    	}
	    }
	    
	    
}
