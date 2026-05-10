package servicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Categoria;
import dominio.Evento;
import dominio.Organizador;
import dominio.Usuario;
import persistencia.EventoDao;
import util.Util;

public class EventoServicio implements IEventoServicio {
    private final Scanner sc;
    private static EventoDao eventoDao = new EventoDao();
    private CategoriaServicio categoriaServicio;

    // creamos el constructor
    public EventoServicio(Scanner sc) {
        this.sc = sc;
        this.categoriaServicio = new CategoriaServicio(sc);
    }

    // creamos un metodo para mostrar los eventos que hay creados
    @Override
    public void mostrarEventos() {
        List<Evento> eventos = new ArrayList<>(eventoDao.obtenerEventos().values());
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos disponibles");
        } else {
            for (int i = 0; i < eventos.size(); i++) {
                System.out.println((i + 1) + ".- " + eventos.get(i));
            }
        }
    }

    // creamos un constructor para mostrar en que eventos esta inscrito el usuario
    @Override
    public void mostrarEventosUsuario(Usuario usuario) {
        List<Evento> eventos = eventoDao.obtenerPorUsuario(usuario);
        if (eventos.isEmpty()) {
            System.out.println("No estás inscrito en ningún evento");
        } else {
            for (Evento e : eventos) {
                System.out.println(e);
            }
        }
    }

    // creamos un metodo para poder inscribir a un usuario a un nuevo evento
    @Override
    public void inscribirUsuario(Usuario usuario) {
        List<Evento> eventos = new ArrayList<>(eventoDao.obtenerEventos().values());
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos disponibles");
            return;
        }
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ".- " + eventos.get(i));
        }
        int opcion = Util.pedirNumeroEntero(sc, "Seleccione el número del evento:") - 1;
        if (opcion < 0 || opcion >= eventos.size()) {
            System.out.println("Evento inválido");
            return;
        }
        usuario.inscribirEvento(eventos.get(opcion));
        System.out.println("Inscripción realizada");
    }

    // creamos un metodo para pocder cancelar la inscripcion de un usuario a un evento
    @Override
    public void cancelarInscripcion(Usuario usuario) {
        List<Evento> eventos = eventoDao.obtenerPorUsuario(usuario);
        if (eventos.isEmpty()) {
            System.out.println("No estás inscrito en ningún evento");
            return;
        }
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ".- " + eventos.get(i));
        }
        int opcion = Util.pedirNumeroEntero(sc, "Seleccione el número del evento:") - 1;
        if (opcion < 0 || opcion >= eventos.size()) {
            System.out.println("Evento inválido");
            return;
        }
        usuario.cancelarInscripcion(eventos.get(opcion));
        System.out.println("Inscripción cancelada");
    }

    // creamos un metodo para mostrar los eventos que tiene el organizador
    @Override
    public void mostrarEventosOrganizador(Organizador organizador) {
        List<Evento> eventos = eventoDao.obtenerPorOrganizador(organizador);
        if (eventos.isEmpty()) {
            System.out.println("No hay ningun evento");
        } else {
            for (Evento e : eventos) {
                System.out.println(e + " Asistentes: " + e.getAsistentes().size());
            }
        }
    }

    // creamos un metodo que solo puede utiizar el organizador que consiste en crear un evento
    @Override
    public void crearEvento(Organizador organizador) {
        try {
            System.out.println("Nombre del evento:");
            String nombre = sc.nextLine();
            System.out.println("Descripción:");
            String descripcion = sc.nextLine();
            System.out.println("Fecha:");
            LocalDate fecha = LocalDate.parse(sc.nextLine());
            System.out.println("Hora:");
            LocalTime hora = LocalTime.parse(sc.nextLine());
            int duracion = Util.pedirNumeroEntero(sc, "Duracion:");
            System.out.println("Ubicación:");
            String ubicacion = sc.nextLine();
            Categoria categoria = categoriaServicio.buscarCategoria();
            if (categoria == null) {
                System.out.println("No se pudo crear el evento");
                return;
            }
            Evento evento = organizador.organizarEvento(nombre, descripcion, fecha, hora, duracion, ubicacion, categoria);
            if (eventoDao.insertarEvento(evento)) {
                System.out.println("Evento creado");
            } else {
                System.out.println("Ya existe un evento con ese nombre");
            }
        } catch (Exception e) {
            System.out.println("Error. Acuerdese del formato de fecha (AAAA-MM-DD) y hora (HH:MM)");
        }
    }
}