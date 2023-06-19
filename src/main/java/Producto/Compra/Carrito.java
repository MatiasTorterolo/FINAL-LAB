package Producto.Compra;

import Producto.Producto;
import Repository.UsuarioRepo;
import usuario.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Carrito {
 private ArrayList<Producto> carrito=new ArrayList<>();
 private UsuarioRepo usuarioRepo=new UsuarioRepo();
    public Carrito() {
    }

    public void MostrarCarrito(){
        if(this.carrito.contains(null)){
            System.out.println("El carrito esta vacio");
        }
        else {
            this.carrito.forEach(System.out::println);
        }
    }

    public void AgregarProductoCarrito(Producto producto){
        if(this.carrito.contains(producto)){
            String opcion= JOptionPane.showInputDialog("El producto se encuentra en el carrito. desea agregar de todas maneras?");
            try {
                if (opcion.equals("si")) {
                    this.carrito.add(producto);
                }else if(opcion.equals(("no"))) {
                    System.out.println("No se agrego el producto");
                }
                else {
                    throw new RuntimeException("Escriba 'si' o 'no'");
                }
            }catch (RuntimeException e){
                System.out.println("ERROR: "+ e.getMessage());
            }
        }
        else {
            this.carrito.add(producto);
        }
    }

    public void EliminarProductoCarrito(Producto producto){
        if (this.carrito.contains(producto)){
            this.carrito.remove(producto);
        }else {
            System.out.println("El producto no se encuentra en el carrito");
        }

    }

    public void Comprar(Usuario usuario){
        ArrayList<Producto>comprar=usuario.getCompras();
        comprar.addAll(this.carrito);
        usuario.setCompras(comprar);
        usuarioRepo.Modificar(usuario);
    }



}
