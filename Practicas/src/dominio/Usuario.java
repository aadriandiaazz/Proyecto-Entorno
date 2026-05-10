package dominio;

public class Usuario {
    private String nombre;
    private String correo;
    private String constrasenia;

    // creamos el constructor
    public Usuario(String nombre, String correo, String constrasenia) {
        this.nombre = nombre;
        this.correo = correo;
        this.constrasenia = constrasenia;
    }

    // creamos los setters y getters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getConstrasenia() {
        return constrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setConstrasenia(String constrasenia) {
        this.constrasenia = constrasenia;
    }

    // creamos el toString
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", correo=" + correo + ", constrasenia=" + constrasenia + "]";
	}

	// creamos un metodo para que el usuario se inscriba al evento
    public void inscribirEvento(Evento evento) {
        evento.getAsistentes().add(this);
    }

    // creamos un metodo para que el usuario pueda cancelar la inscripcion del evento
    public void cancelarInscripcion(Evento evento) {
        evento.getAsistentes().remove(this);
    }
}