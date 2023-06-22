package Gestor;

import Producto.Producto;
import Repository.UsuarioRepo;
import usuario.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionUsuario {
    UsuarioRepo usuarioRepo=new UsuarioRepo();

    public GestionUsuario() {
    }

    public  void Mostrar() {
        this.usuarioRepo.listar().forEach(System.out::println);
    }
    public void Agregar(Usuario objeto) {
        try {
            if (Existe(objeto)) {
                throw new RuntimeException("El Usuario ya existe");
            } else {
                this.usuarioRepo.agregar(objeto);
            }
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public boolean Existe(Usuario objeto) {
        if (this.usuarioRepo.listar().contains(objeto)) {
            return true;
        } else {
            return false;
        }
    }
    public void Eliminar(Usuario objeto) {
        try {
            if (Existe(objeto)) {
                this.usuarioRepo.eliminar(objeto);
            } else {
                throw new RuntimeException("El Usuario no existe");
            }
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public void Modificar(Usuario usuario) {
            System.out.println(usuario.toString());
            System.out.println("1: Modificar Nombre " + " 2: Modificar Direccion " + " 3: Modificar Pass" + " 4: Modificar Todo");
            String opcions=JOptionPane.showInputDialog("Ingrese una opcion");
            int opcion=Integer.parseInt(opcions);
            switch (opcion) {
                case 1:
                    usuario.setNombreYapellido(JOptionPane.showInputDialog("Nombre: "));
                    break;
                case 2:
                    usuario.setDireccion(JOptionPane.showInputDialog("Direccion: "));
                    break;
                case 3:
                    usuario.setPass(JOptionPane.showInputDialog("Pass : "));
                    break;
                case 4:
                    usuario.setNombreYapellido(JOptionPane.showInputDialog("Nombre: "));
                    usuario.setDireccion(JOptionPane.showInputDialog("Direccion: "));
                    usuario.setPass(JOptionPane.showInputDialog("Pass : "));
                    break;
                default:
                    System.out.println("Error, no existe esa opcion");
                    break;
            }
            System.out.println("Producto modificado : " + usuario.toString());

            String guardar = JOptionPane.showInputDialog("Desea guardar?");
            if (guardar.equals("si")) {
                this.usuarioRepo.Modificar(usuario);
                System.out.println("Se modifico");
            } else {
                System.out.println("No se modifico");
            }
    }
    public int ultimoId() {
        int idUltimo=0;
        ArrayList<Usuario> buscarUltimo=usuarioRepo.listar();
        if (buscarUltimo == null) {
            return 0;
        } else {
            for (Usuario ultimo : buscarUltimo) {
                idUltimo = ultimo.getId();
            }
            return idUltimo;
        }
    }
}
