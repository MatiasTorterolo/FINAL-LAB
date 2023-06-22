package usuario;

import Gestor.GestionUsuario;
import Repository.UsuarioRepo;

import javax.swing.*;
import java.util.Arrays;

public class InicioSesion {
    GestionUsuario gestionUsuario = new GestionUsuario();
    UsuarioRepo usuarioRepo = new UsuarioRepo();

    public InicioSesion() {
    }

    public void Registro() {
        int flag = 0;
        int bucle = 0;
        int flag1=0;
        do {
            Usuario usuario = new Usuario();
            String nombreYapellido = JOptionPane.showInputDialog("Ingrese nombre y apellido");
            String direccion = JOptionPane.showInputDialog("Ingrese direccion");
            String mail;
            do {
                 mail = JOptionPane.showInputDialog("Ingrese e-mail");
                try {
                    if (mail.contains("@") && mail.contains(".com")) {
                        System.out.println("e-mail valido");
                        flag = 1;
                    } else {
                        throw new RuntimeException("e-mail no valido. verifique '@' o '.com'");
                    }
                } catch (RuntimeException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            } while (flag == 0);
            String pass;
        do {
            pass = JOptionPane.showInputDialog("Ingrese contraseña. la contraseña debe contener al menos 8 caracteres, ul menos mayuscula y un digito");
            if(verificarContrasena(pass)){
                System.out.println("Pass valida");
                flag1=1;

            }else {
                System.out.println("ERROR: la contraseña debe contener al menos 8 caracteres, ul menos mayuscula y un digito");

            }

        }while (flag1==0);

            int id = gestionUsuario.ultimoId() + 1;
            usuario.setPass(pass);
            usuario.setDireccion(direccion);
            usuario.setNombreYapellido(nombreYapellido);
            usuario.setEmail(mail);
            usuario.setId(id);

            System.out.println(usuario.toString());
            String opcion = JOptionPane.showInputDialog("Los datos son correctos?");
            if (opcion.equalsIgnoreCase("si")) {
                gestionUsuario.Agregar(usuario);
                System.out.println("Usuario creado");
            } else {
                bucle = 1;
            }
        } while (bucle == 1);
    }

    public boolean verificarContrasena(String pass) {
        String patron = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        return pass.matches(patron);
    }

    public Usuario inicioSesion(String contrasenia, String mail) {
        if (usuarioRepo.listar() != null) {
            Usuario usuarioEncontrado = new Usuario();
            for (Usuario usuario : usuarioRepo.listar()) {
                if (usuario.getPass().equals(contrasenia) && usuario.getEmail().equals(mail)) {
                    usuarioEncontrado = usuario;
                }
            }
            return usuarioEncontrado;
        }else {
            System.out.println("No se encuentran usuarios registrados");
            return null;
        }
    }



    public void ModificarUsuario(Usuario usuario){
        String bucle="no";
        do {
    String contra=JOptionPane.showInputDialog("Ingrese pass");
    if(usuario.getPass().equals(contra)){
        gestionUsuario.Modificar(usuario);
    }else {
        bucle=JOptionPane.showInputDialog("PASS INCORRECTA, desea volver a intentar");
    }

    }while (bucle.equalsIgnoreCase("si"));
}

    public  String obtenerContrasena() {
        JPasswordField passwordField = new JPasswordField();
        JOptionPane.showConfirmDialog(null, passwordField, "INGRESE PASS:", JOptionPane.OK_CANCEL_OPTION);
        return new String(passwordField.getPassword());
    }
}