package persistencia;

import java.util.HashMap;

import dominio.Organizador;

public class OrganizadorDao {
	private static HashMap<String, Organizador> organizadores = new HashMap<String, Organizador>();
	
	// creamos el constructor y creamos dos nuevos organizadores
	public OrganizadorDao() {
		if(organizadores.isEmpty()) {
		organizadores.put("Florentino", new Organizador("Florentino","florentino@gmail.com","Champions15","612345678"));
		organizadores.put("Empresa", new Organizador("Empresa","empresa@gmail.com","GanasDinero","698765432"));
		}		
	}
	
	// creamos un metodo para que un organizador se pueda logear
	public Organizador login(String nombre, String contrasenia) {
		Organizador organizador = organizadores.get(nombre);
		
		if(organizador != null) {
			if(organizador.getConstrasenia().equals(contrasenia)) {
				return organizador;
			}
		}
		
		return null;
	}
	
	// creamos un metodo para que un organizador se pueda registrar
	public boolean registrar(Organizador organizador) {
		if(organizadores.containsKey(organizador.getNombre())) {
			return false;
		} else {
			organizadores.put(organizador.getNombre(), organizador);
			return true;
		}
	}
	
	// creamos un metodo para obtener un organizador
	public Organizador obtenerOrganizador(String nombre) {
		return organizadores.get(nombre);
	}
}
