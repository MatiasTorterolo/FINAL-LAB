package Gestor;

import Producto.Producto;
import Repository.ProducotoRepo;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionProducto implements Gestiones<Producto>{
    ProducotoRepo productoRepo = new ProducotoRepo();

    public GestionProducto() {
    }


    public void Mostrar() {
        this.productoRepo.listar().forEach(System.out::println);
    }


    public void Agregar(Producto objeto) {
        try {
            if (Existe(objeto)) {
                throw new RuntimeException("El Producto ya existe");
            } else {
                this.productoRepo.agregar(objeto);
            }
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }


    public boolean Existe(Producto objeto) {
        if (this.productoRepo.listar().contains(objeto)) {
            return true;
        } else {
            return false;
        }
    }


    public void Eliminar(Producto objeto) {
        try {
            if (Existe(objeto)) {
                this.productoRepo.eliminar(objeto);
            } else {
                throw new RuntimeException("El Producto no existe");
            }
        } catch (RuntimeException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public Producto Buscar(int id) {
        ArrayList<Producto> listaProducto = this.productoRepo.listar();
        for (Producto productoEncontrado : listaProducto) {
            if (productoEncontrado.getId() == id) {
                return productoEncontrado;
            }
        }
        return null;
    }

    public void Modificar(Scanner scanner) {
        String bucle;
        do {
            String input = JOptionPane.showInputDialog("ingrese id del producto que desea buscar:");
            int id = Integer.parseInt(input);
            Producto producto = Buscar(id);
            System.out.println(producto.toString());
            System.out.println("1: Modificar precio " + " 2: Modificar descripcion" + " 3: Modificar precio y descripcion");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    input = JOptionPane.showInputDialog("Precio: ");
                    producto.setPrecio(Double.parseDouble(input));
                    break;
                case 2:
                    producto.setDescripcion(JOptionPane.showInputDialog("Descripcion: "));
                    break;
                case 3:
                    input = JOptionPane.showInputDialog("Precio: ");
                    producto.setPrecio(Double.parseDouble(input));
                    producto.setDescripcion(JOptionPane.showInputDialog("Descripcion: "));
                    break;
                case 0:
                    System.out.println("Error, no existe esa opcion");
                    break;
            }
            System.out.println("Producto modificado : " + producto.toString());

            String guardar = JOptionPane.showInputDialog("Desea guardar?");
            if (guardar.equals("si")) {
                this.productoRepo.Modificar(producto);
                System.out.println("Se modifico");
            } else {
                System.out.println("No se modifico");
            }
             bucle = JOptionPane.showInputDialog("Desea modificar otro producto?");
        } while (bucle.equals("si"));
    }
}
