package tratafichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
* LeeFichero: Clase para lectura de ficheros
*    @author  IceDrek
*    @version 0.1
*/
public class LeeFichero {
	//Declaración e inicialización de las variables utilizadas.
	private File           archivo = null;
	private String         fichero = null;
    private FileReader     fr      = null;
    private BufferedReader br      = null;
    
    /**
     * Constructor de clase:
     *    @param  fichero    Nombre del fichero a tratar
     */
    public LeeFichero(String fichero)
    {
    	this.fichero = fichero;
    }
    
    /**
     * Metodo leerLinea: Devuelve la linea del fichero indicada por parámetros.
     *    @param  numLinea   Número de línea del fichero que se va a leer
     *    @return linea      Línea seleecionada del fichero.
     */
    public String leerLinea(int numLinea)
    {    	 
    	int cLinea = 0;
    	String linea = null;
    	String linaux;
            	
    	try 
    	{    		
    		archivo = new File (fichero);
    		fr      = new FileReader (archivo);       
    		br      = new BufferedReader(fr);

    		// Lectura del fichero
                     
    		while((linaux=br.readLine())!=null)        
    		{    	
    			cLinea++;
    			
    			if (cLinea == numLinea) 
    			{
    				linea = linaux;
    			}       
    		}
              
    	} catch(FileNotFoundException e) {
    		System.out.println("Fichero " + fichero + " no encontrado.");
    		
    	} catch(NullPointerException e) {
    		System.out.println("Error puntero nulo");
    		
    	} catch(Exception e) {       
    		e.printStackTrace();
    		
    	} finally {    	    		
    		try    	
    		{                                  		
    			if( null != fr )    		
    			{                   			
    				fr.close();                   		
    			}                  
          	
    		} catch (Exception e2) {             	
    			e2.printStackTrace();           			
    		}    
    	}
	
    	return linea;    
    }
    
    /**
     * Metodo numeroLineas: Devuelve el número total de lineas que contiene el fichero.     
     *    @return numLinea   Número de lineas que contiene el fichero.
     */
    public int numeroLineas()
    {    	 
    	int numLinea = 0;
            	
    	try 
    	{    		
    		archivo = new File (fichero);
    		fr = new FileReader (archivo);       
    		br = new BufferedReader(fr);

    		// Lectura del fichero                     
    		while(br.readLine()!=null)        
    		{    	
    			numLinea++;    			      
    		}
              
    	} catch(FileNotFoundException e) {
    		System.out.println("Fichero " + fichero + " no encontrado.");
    		
    	} catch(NullPointerException e) {
    		System.out.println("Fichero " + fichero + " vacio.");
    		
    	} catch(Exception e) {       
    		e.printStackTrace();
    		
    	} finally {    	    		
    		try    	
    		{                                  		
    			if( null != fr )    		
    			{                   			
    				fr.close();                   		
    			}                  
          	
    		} catch (Exception e2) {             	
    			e2.printStackTrace();           			
    		}    
    	}
	
    	return numLinea;    
    }
}
