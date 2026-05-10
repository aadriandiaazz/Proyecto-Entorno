package dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Organizador extends Usuario {
    private String telefono;

    // creamos el constructor
    public Organizador(String nombre, String correo, String constrasenia, String telefono) {
        super(nombre, correo, constrasenia);
        this.telefono = telefono;
    }

    // creamos un metodo para organizar un evento
    public Evento organizarEvento(String nombre, String descripcion, LocalDate fecha, LocalTime hora,
                                  int duracion, String ubicacion, Categoria categoria) {
    	// aqui he utilizado this ya que he estado viendo que hace referencia al objeto actual y creo que es más sencillo asi
        return new Evento(nombre, descripcion, fecha, hora, duracion, ubicacion, categoria, this);
    }

    // creamos los setters y getters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}