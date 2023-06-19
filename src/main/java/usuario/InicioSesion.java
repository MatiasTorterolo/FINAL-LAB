package usuario;

import Gestor.GestionUsuario;
import Repository.UsuarioRepo;

import javax.swing.*;

public class InicioSesion {
    GestionUsuario gestionUsuario = new GestionUsuario();
    UsuarioRepo usuarioRepo = new UsuarioRepo();

    public InicioSesion() {
    }

    public void Registro() {
        int flag = 0;
        int bucle = 0;
        do {
            Usuario usuario = new Usuario();
            String nombreYapellido = JOptionPane.showInputDialog("Ingrese nombre y apellido");
            String direccion = JOptionPane.showInputDialog("Ingrese direccion");
            String mail = JOptionPane.showInputDialog("Ingrese e-mail");
            do {
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
            String pass = JOptionPane.showInputDialog("Ingrese contraseña");
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


}