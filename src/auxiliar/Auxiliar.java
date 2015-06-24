package auxiliar;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.table.TableModel;

import beans.Proyecto;

public class Auxiliar {
	public static boolean sysOp = true;
	
	public static String dirWin = ".\\datos";
	public static String dirLin = "./datos";
	
	public static String ficUserWin = ".\\datos\\usuarios.json";
	public static String ficejerWin = ".\\datos\\ejercicios.json";
	public static String ficRutiWin = ".\\datos\\rutinas.json";
	public static String ficLogWin  = ".\\datos\\informe.log";
	
	public static String ficUserLin = "./datos/usuarios.json";
	public static String ficejerLin = "./datos/ejercicios.json";
	public static String ficRutiLin = "./datos/rutinas.json";
	public static String ficLogLin  = "./datos/informe.log";
	
	//public static DefaultListModel<String> modelo = new DefaultListModel<String>();
	public static TableModel modelo;
	
	public static ArrayList<Proyecto> lUsuarios = new ArrayList<Proyecto>();
}
