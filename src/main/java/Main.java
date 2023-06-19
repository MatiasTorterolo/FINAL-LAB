import Gestor.GestionProducto;
import Repository.UsuarioRepo;
import usuario.InicioSesion;
import usuario.Usuario;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        InicioSesion inicioSesion=new InicioSesion();
        String bucle;
        Usuario usuario=new Usuario();
        do {
            String opcions = JOptionPane.showInputDialog("1:Iniciar sesion     2:Registrarse");
            int opcion = Integer.parseInt(opcions);
            switch (opcion) {
                case 1:
                    String mail = JOptionPane.showInputDialog("INGRESE E-MAIL");
                    String contra = JOptionPane.showInputDialog("INGRESE PASS");
                    usuario = inicioSesion.inicioSesion(contra, mail);
                    if (usuario == null) {
                        System.out.println("Usuario no registrado o verifique bien los datos");
                    } else {
                        System.out.println("BIENVENIDO " + usuario.getNombreYapellido());
                    }
                    break;
                case 2:
                    inicioSesion.Registro();
                    break;
            }
             bucle=JOptionPane.showInputDialog("Desea continuar?...");
        }while (bucle.equalsIgnoreCase("si"));
    }
}