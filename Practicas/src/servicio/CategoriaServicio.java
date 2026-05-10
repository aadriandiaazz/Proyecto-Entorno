package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dominio.Categoria;
import persistencia.CategoriaDao;
import util.Util;

public class CategoriaServicio implements ICategoriaServicio {
    private final Scanner sc;
    private CategoriaDao categoriaDao;

    // creamos el constructor
    public CategoriaServicio(Scanner sc) {
        this.sc = sc;
        this.categoriaDao = new CategoriaDao();
    }

    // creamos un metodo para que nos pase una lista de todas las categorias y despues nos pide seleccionar en que categoria queremos meter el evento
    @Override
    public Categoria buscarCategoria() {
        List<Categoria> lista = new ArrayList<>(categoriaDao.obtenerCategorias().values());

        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ".- " + lista.get(i).getNombre());
        }

        int opcion = Util.pedirNumeroEntero(sc, "Seleccione una categoría:") - 1;

        if (opcion < 0 || opcion >= lista.size()) {
            System.out.println("Categoría inválida");
            return null;
        }

        return lista.get(opcion);
    }
}