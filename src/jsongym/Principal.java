package jsongym;

import java.io.File;

import auxiliar.Auxiliar;

import visual.VentanaPrincipal;

public class Principal {

	public static void main(String[] args) 
	{	
		String dirAux;

		String sisOper = System.getProperty("os.name");
		
		if(sisOper.substring(0, 3).equals("Win"))
		{
			Auxiliar.sysOp = true;
			dirAux = Auxiliar.dirWin;
		} else {
			Auxiliar.sysOp = false;
			dirAux = Auxiliar.dirLin;
		}
		
		File directorio = new File(dirAux);
		
		if (!directorio.exists())
		{
			directorio.mkdir();
		}			
		
		// Se genera la ventana principal.
		VentanaPrincipal vp = new VentanaPrincipal();
		vp.setVisible(true);
	}
}
