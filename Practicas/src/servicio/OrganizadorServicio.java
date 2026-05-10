package servicio;

import java.util.Scanner;

import dominio.Organizador;
import persistencia.OrganizadorDao;

public class OrganizadorServicio implements IOrganizadorServicio {
    private final Scanner sc;
    private OrganizadorDao organizadorDao;

    // creamos el constructor
    public OrganizadorServicio(Scanner sc) {
        this.sc = sc;
        this.organizadorDao = new OrganizadorDao();
    }

    // creamos un metodo para que nos pida los datos de un organizador para hacer el login
    @Override
    public Organizador hacerLogin() {
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasenia = sc.nextLine();
        Organizador organizador = organizadorDao.login(nombre, contrasenia);
        if (organizador == null) {
            System.out.println("Inicio de sesion fallido");
        }
        return organizador;
    }

    // creamos un metodo para que un organizador se pueda registrar
    @Override
    public void registrarOrganizador() {
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Correo:");
        String correo = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasenia = sc.nextLine();
        System.out.println("Teléfono:");
        String telefono = sc.nextLine();
        boolean registrado = organizadorDao.registrar(new Organizador(nombre, correo, contrasenia, telefono));
        if (registrado) {
            System.out.println("Organizador registrado");
        } else {
            System.out.println("Ya existe un organizador con ese nombre");
        }
    }
}