package trataJSON;

import java.io.StringWriter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import tratafichero.EscribeFichero;
import tratafichero.LeeFichero;

import auxiliar.Auxiliar;
import beans.Usuario;

public class UsuarioJSON {
	private Usuario usuario;
	private static String fichero;
	
	
	//Constructor de clase
	public UsuarioJSON()
	{
		if (Auxiliar.sysOp == true) {
			fichero = Auxiliar.ficUserWin;
		} else {
			fichero = Auxiliar.ficUserLin;
		}
	}
	
	public UsuarioJSON(Usuario usuario)
	{
		this.usuario = usuario;	
		
		if (Auxiliar.sysOp == true) {
			fichero = Auxiliar.ficUserWin;
		} else {
			fichero = Auxiliar.ficUserLin;
		}
	}
	
	//Metodo para generar fichero de usuarios en formato JSON
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void escribirUsuariosJSON ()
	{						
		
		//Mapa para mantener el orden deseado a la hora de generar el registro JSON
		Map obj=new LinkedHashMap();

		//Definicion de campos de usuario para el JSON
		obj.put("ID",      usuario.getIdUsuario());	
		obj.put("Nombre",  usuario.getNombre());
		obj.put("Ape1",    usuario.getApe1());
		obj.put("Ape2",    usuario.getApe2());
		obj.put("Rutinas", usuario.getRutinas());
		
		try {
			StringWriter out = new StringWriter();
			JSONValue.writeJSONString(obj, out);
			String jsonText = out.toString();
			
			EscribeFichero ef = new EscribeFichero(fichero);
			ef.escribeLinea(jsonText+"\n");
						
		} catch (Exception e) {e.printStackTrace();}				
	}
	
	//Metodo para generar lista de usuarios a partir de fichero en formato JSON
	@SuppressWarnings({ "unchecked" })
	public ArrayList<Usuario> consultaUsuariosJSON ()
	{			
		ArrayList<Usuario> listUser = new ArrayList<Usuario>();
		LeeFichero lf = new LeeFichero(fichero);
		int totLineas = lf.numeroLineas();
		Usuario u = null;
		
		
		//Se recorre el fichero para montar un listado de usuarios en formato Usuario
		try {	
			JSONParser jsonParser = new JSONParser();			

			for (int i = 1; i <= totLineas; i++)
			{
				u = new Usuario();
				
				JSONObject jsonObj = (JSONObject) jsonParser.parse(lf.leerLinea(i));
				
				int idUsuario = (Integer.parseInt(jsonObj.get("ID").toString()));							
				u.setIdUsuario(idUsuario);
 
				String nombre = (String) jsonObj.get("Nombre");
				u.setNombre(nombre);
			
				String ape1 = (String) jsonObj.get("Ape1");
				u.setApe1(ape1);
				
				String ape2 = (String) jsonObj.get("Ape2");
				u.setApe2(ape2);
	 						
				JSONArray rutinas = (JSONArray) jsonObj.get("Rutinas");				
				u.setRutinas((ArrayList<Integer>) rutinas);					

				listUser.add(u);
			}			
			
		} catch (NullPointerException e) {
			System.out.println("Null Pointer: " + e.getMessage() + " - " + e.getCause());
			e.printStackTrace();
			
		} catch (ParseException e) {
			System.out.println("Parse Excp");
			e.printStackTrace();
		
		} catch (Exception e) {
			System.out.println("Error General");
			e.printStackTrace();
		} 		
		
		return listUser;		
	}
}
