import Producto.CatalogoProducto;
import Producto.Producto;
import Producto.Venta;
import Repository.ProductoRepo;
import usuario.InicioSesion;
import usuario.Usuario;

import javax.swing.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InicioSesion inicioSesion = new InicioSesion();
        CatalogoProducto catalogoProducto = new CatalogoProducto();
        Venta venta = new Venta();

        ProductoRepo producotoRepo = new ProductoRepo();
        String bucle = "si";
        int flag=0;
        Usuario usuario = new Usuario();
        do {
            String opciones = JOptionPane.showInputDialog("1:Iniciar sesion     2:Registrarse");
            int opcion = Integer.parseInt(opciones);
            switch (opcion) {
                case 1:

                    String mail = JOptionPane.showInputDialog("INGRESE E-MAIL");
                    String contra = inicioSesion.obtenerContrasena();
                    usuario = inicioSesion.inicioSesion(contra, mail);
                    if (usuario.getNombreYapellido() == null) {
                        System.out.println("Usuario no registrado o verifique bien los datos");
                        flag=1;

                    } else {
                        System.out.println("BIENVENIDO " + usuario.getNombreYapellido());
                        flag=0;
                        do {
                            opciones = JOptionPane.showInputDialog("1: Ver productos\n2: Publicar Producto\n3: Mostrar Productos publicados\n4: Historial de compras\n5: Eliminar publicacion\n6: Ir a carrito\n7: Modificar datos de perfil\n8: Ver perfil\n0: Cerrar sesion ");
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
                                    if (usuario.getPublicaciones() == null) {
                                        System.out.println("NO SE REGISTRAN PUBLICACIONES");
                                    } else {
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
                                    opciones = JOptionPane.showInputDialog("Desea Eliminar un producto del carrito?");

                                    if (opciones.equalsIgnoreCase("si")) {
                                        do {
                                            String input = JOptionPane.showInputDialog("Ingrese id del producto que desea eliminar");
                                            int id = Integer.parseInt(input);
                                            catalogoProducto.EliminarProductoCarrito(producotoRepo.Buscar(id));
                                            catalogoProducto.MostrarCarrito();
                                            bucle = JOptionPane.showInputDialog("desea eliminar otro producto");
                                        } while (bucle.equalsIgnoreCase("si"));
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

                                    bucle = "no";
                                    break;
                                default:
                                    System.out.println("Ingrese una opcion valida");
                            }

                        } while (bucle.equalsIgnoreCase("si"));
                    }
                    break;
                case 2:
                    inicioSesion.Registro();
                    break;
            }
        }while (flag==1);
    }
}






