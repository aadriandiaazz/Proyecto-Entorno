package persistencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dominio.Evento;
import dominio.Organizador;
import dominio.Usuario;

public class EventoDao {
    private static HashMap<String, Evento> eventos = new HashMap<String, Evento>();
    private CategoriaDao categoriaDao;
    private OrganizadorDao organizadorDao;
    
    // creamos el constructor e instanciamos CategoriaDao y OrganizadorDao
    public EventoDao() {
        this.categoriaDao = new CategoriaDao();
        this.organizadorDao = new OrganizadorDao();

        // creamos dos nuevos eventos para hacer pruebas
        if (eventos.isEmpty()) {
            eventos.put("Final Champions", new Evento("Final Champions", "Final de la Champions League", LocalDate.of(2026, 5, 30), LocalTime.of(21, 0), 105, "Puskás Aréna", categoriaDao.obtenerCategoria("Partido de futbol"), organizadorDao.obtenerOrganizador("Florentino")));
            eventos.put("Concierto Rosalia", new Evento("Concierto Rosalia", "Viene la Rosalía a tocar. ¡Tra tra!.", LocalDate.of(2026, 4, 4), LocalTime.of(20, 30), 100, "WiZink Center", categoriaDao.obtenerCategoria("Concierto"), organizadorDao.obtenerOrganizador("Empresa")));
        }
    }

    // creamos un metodo para obtener todos los eventos que haya creados
    public HashMap<String, Evento> obtenerEventos() {
        return eventos;
    }

    // creamos un metodo para que se puedan crear eventos
    public boolean insertarEvento(Evento evento) {
        if (eventos.containsKey(evento.getNombre())) {
            return false;
        } else {
            eventos.put(evento.getNombre(), evento);
            return true;
        }
    }

    // creamos un metodo para obtener todos los eventos en el que participa un usuario
    public List<Evento> obtenerPorUsuario(Usuario usuario) {
        List<Evento> resultado = new ArrayList<Evento>();
        for (Evento evento : eventos.values()) {
            if (evento.getAsistentes().contains(usuario)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }

    // creamos un metodo para obtener todos los eventos organizados por unu mismo organizador
    public List<Evento> obtenerPorOrganizador(Organizador organizador) {
        List<Evento> resultado = new ArrayList<Evento>();
        for (Evento evento : eventos.values()) {
            if (evento.getOrganizador() != null && 
                evento.getOrganizador().getNombre().equals(organizador.getNombre())) {
                resultado.add(evento);
            }
        }
        return resultado;
    }
}