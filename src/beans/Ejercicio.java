package beans;

public class Ejercicio implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idEjercicio;
	private String tipo, nombre, descripcion;	
	
	public Ejercicio(){}	
	
	public Ejercicio(int idEjercicio, String tipo, String nombre, String descripcion)
	{
		this.idEjercicio = idEjercicio;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;						
	}

	public int getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
