package persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dominio.Usuario;

public class UsuarioDao {
    private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();

    // creamos el constructor y metemos a unos usuarios para hacer pruebas
    public UsuarioDao() {
        if (usuarios.isEmpty()) {
            usuarios.put("Pepito", new Usuario("Pepito", "pepito@gmail.com", "PepitoElMejor"));
            usuarios.put("Juanito", new Usuario("Juanito", "juanito@gmail.com", "JuanitoElMejor"));
            usuarios.put("Ana", new Usuario("Ana", "ana@gmail.com", "AnaLaMejor"));
            usuarios.put("Paula", new Usuario("Paula", "paula@gmail.com", "PaulaLaMejor"));
            usuarios.put("Pedrito", new Usuario("Pedrito", "pedrito@gmail.com", "PedritoElMejor"));
        }
    }

	// creamos un metodo para que un usuario se pueda logear
    public Usuario login(String nombre, String contrasenia) {
        Usuario usuario = usuarios.get(nombre);
        if (usuario != null) {
            if (usuario.getConstrasenia().equals(contrasenia)) {
                return usuario;
            }
        }
        return null;
    }

 // creamos un metodo para que un usuario se pueda registrar
    public boolean registrar(Usuario usuario) {
        if (usuarios.containsKey(usuario.getNombre())) {
            return false;
        } else {
            usuarios.put(usuario.getNombre(), usuario);
            return true;
        }
    }

    // creamos un metodo para obtener a todos los usuarios
    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios.values());
    }
}