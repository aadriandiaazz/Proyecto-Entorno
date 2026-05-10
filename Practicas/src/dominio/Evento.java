package dominio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

public class Evento {
	// le damos todos los atributos
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private int duracion;
    private String ubicacion;
    private Categoria categoria;
    private Organizador organizador;
    private HashSet<Usuario> asistentes;

    // hacemos el constructor
    public Evento(String nombre, String descripcion, LocalDate fecha, LocalTime hora,
                  int duracion, String ubicacion, Categoria categoria, Organizador organizador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.organizador = organizador;
        this.asistentes = new HashSet<>();
    }

    // creamos los setters y getters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public HashSet<Usuario> getAsistentes() {
        return asistentes;
    }

    // creamos el toString
	@Override
	public String toString() {
		return "Evento [nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha + ", hora=" + hora
				+ ", duracion=" + duracion + ", ubicacion=" + ubicacion + ", categoria=" + categoria.getNombre() + ", organizador="
				+ organizador.getNombre() + " " + organizador.getCorreo() + ", asistentes=" + asistentes + "]";
	}

	// añadimos al usuario
	public boolean aniadirUsuario(Usuario usuario) {
	    return asistentes.add(usuario);
	}

	// liminamos al usuario
	public boolean eliminarUsuario(Usuario usuario) {
	    return asistentes.remove(usuario);
	}
}