import Producto.CatalogoProducto;
import Producto.Producto;
import Producto.Venta;
import Repository.ProductoRepo;
import usuario.InicioSesion;
import usuario.Usuario;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        InicioSesion inicioSesion = new InicioSesion();
        CatalogoProducto catalogoProducto = new CatalogoProducto();
        Venta venta = new Venta();

        ProductoRepo producotoRepo = new ProductoRepo();
        String bucle = null;
        int flag = 0;
        Usuario usuario = new Usuario();
        do {
            String opciones = JOptionPane.showInputDialog("1:Iniciar sesion     2:Registrarse");
            int opcion = Integer.parseInt(opciones);
            switch (opcion) {
                case 1:
                    String mail = JOptionPane.showInputDialog("INGRESE E-MAIL");
                    String contra = JOptionPane.showInputDialog("INGRESE PASS");
                    usuario = inicioSesion.inicioSesion(contra, mail);
                    if (usuario.getNombreYapellido() == null) {
                        System.out.println("Usuario no registrado o verifique bien los datos");
                    } else {
                        System.out.println("BIENVENIDO " + usuario.getNombreYapellido());
                        do {

                            opciones = JOptionPane.showInputDialog("1: Ver productos    2: Publicar Producto    3:Mostrar Productos publicados     4:Historial de compras       5:Eliminar publicacion       6:Ir a carrito      7:Modificar datos de perfil       8:Ver perfil     0:Cerrar sesion ");
                            opcion = Integer.parseInt(opciones);
                            switch (opcion) {
                                case 1:
                                    catalogoProducto.Mostrar(usuario);
                                    break;
                                case 2:
                                    venta.PublicarProducto(usuario);
                                    break;
                                case 3:
                                    venta.MostrarPublicaciones(usuario);
                                    break;
                                case 4:
                                    if (usuario.getCompras() == null) {
                                        System.out.println("NO SE REGISTRAN COMPRAS DEL USUARIO");
                                    } else {
                                        usuario.getCompras().forEach(System.out::println);
                                    }
                                    break;
                                case 5:
                                    if(usuario.getPublicaciones()==null){
                                        System.out.println("NO SE REGISTRAN PUBLICACIONES");
                                    }else {
                                        venta.MostrarPublicaciones(usuario);
                                        String input = JOptionPane.showInputDialog("Ingrese id del producto que desea eliminar");
                                        int id = Integer.parseInt(input);
                                        Producto productoElim = producotoRepo.Buscar(id);
                                        String seguro = JOptionPane.showInputDialog(productoElim.toString() + " ESTA SEGURO QUE DESEA ELIMINAR?");
                                        if (seguro.equalsIgnoreCase("si")) {
                                            venta.EliminarPublicacion(usuario, productoElim);
                                            System.out.println("Publicacion eliminado");
                                        }
                                    }
                                    break;
                                case 6:
                                    catalogoProducto.MostrarCarrito();
                                    opciones=JOptionPane.showInputDialog("Desea Eliminar producto del carrito?");

                                        if (opciones.equalsIgnoreCase("si")) {
                                            do{
                                            String input = JOptionPane.showInputDialog("Ingrese id del producto que desea eliminar");
                                            int id = Integer.parseInt(input);
                                            catalogoProducto.EliminarProductoCarrito(producotoRepo.Buscar(id));
                                            catalogoProducto.MostrarCarrito();
                                            bucle = JOptionPane.showInputDialog("desea eliminar otro producto");
                                        }while (bucle.equalsIgnoreCase("si"));
                                        }

                                            opciones = JOptionPane.showInputDialog("Desea comprar");
                                            if (opciones.equalsIgnoreCase("si")) {
                                                catalogoProducto.PagarCarrito(usuario);
                                                System.out.println("Productos comprados");
                                            }

                                    break;
                                case 7:
                                    inicioSesion.ModificarUsuario(usuario);
                                    break;
                                case 8:
                                    System.out.println(usuario.toString());
                                    break;
                                case 0:
                                    flag=1;
                                    bucle="no";
                                    break;
                                default:
                                    System.out.println("Ingrese una opcion valida");

                            }
                            if(flag==0){
                                bucle=JOptionPane.showInputDialog("Desea continuar?");
                            }
                        }while (bucle.equalsIgnoreCase("si"));


                    }
                    break;
                case 2:
                    inicioSesion.Registro();
                    break;
            }
             bucle=JOptionPane.showInputDialog("Desea continuar en el inicio de sesion?...");
        }while (bucle.equalsIgnoreCase("si"));
    }
}