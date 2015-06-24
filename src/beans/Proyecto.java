package beans;

import java.util.ArrayList;

public class Proyecto implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String nombre, ape1, ape2;
	private ArrayList<Integer> rutinas;
	
	public Proyecto(){}	
	
	public Proyecto(int idUsuario, String nombre, String ape1, String ape2, ArrayList<Integer> rutinas)
	{
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.rutinas = rutinas;			
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public ArrayList<Integer> getRutinas() {
		return rutinas;
	}

	public void setRutinas(ArrayList<Integer> rutinas) {
		this.rutinas = rutinas;
	}	
	
	
}
