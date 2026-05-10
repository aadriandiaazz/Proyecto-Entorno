package servicio;

import java.util.Scanner;

import dominio.Usuario;
import persistencia.UsuarioDao;

public class UsuarioServicio implements IUsuarioServicio {
    private final Scanner sc;
    private UsuarioDao usuarioDao;

    // creamos el constructor
    public UsuarioServicio(Scanner sc) {
        this.sc = sc;
        this.usuarioDao = new UsuarioDao();
    }

    // creamos un metodo en el que nos pide los datos de un usuario para que haga login
    @Override
    public Usuario hacerLogin() {
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasenia = sc.nextLine();
        Usuario usuario = usuarioDao.login(nombre, contrasenia);
        if (usuario == null) {
            System.out.println("Inicio de sesion fallido");
        }
        return usuario;
    }

    // creamos un metodo para que un usuario pueda registrarse
    @Override
    public void registrarUsuario() {
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Correo:");
        String correo = sc.nextLine();
        System.out.println("Contraseña:");
        String contrasenia = sc.nextLine();
        boolean registrado = usuarioDao.registrar(new Usuario(nombre, correo, contrasenia));
        if (registrado) {
            System.out.println("Usuario registrado");
        } else {
            System.out.println("Ya existe un usuario con ese nombre");
        }
    }
}