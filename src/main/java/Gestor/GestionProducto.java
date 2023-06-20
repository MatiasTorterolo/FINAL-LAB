package Gestor;

import Producto.Producto;
import Repository.ProductoRepo;


import javax.swing.*;
import java.util.ArrayList;

public class GestionProducto implements Gestiones<Producto>{
    ProductoRepo productoRepo = new ProductoRepo();

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



    public void Modificar(Producto producto) {
        String bucle;
        String input;
        do {
            System.out.println(producto.toString());
            System.out.println("1: Modificar precio " + " 2: Modificar descripcion" + " 3: Modificar precio y descripcion");
            String opcions=JOptionPane.showInputDialog("Ingrese una opcion");
            int opcion=Integer.parseInt(opcions);
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

    public int ultimoId() {
        int idUltimo=0;
        ArrayList<Producto> buscarUltimo = productoRepo.listar();
        if (buscarUltimo == null) {
            return 0;
        } else {
            for (Producto ultimo : buscarUltimo) {
                idUltimo = ultimo.getId();
            }
            return idUltimo;
        }
    }
}
