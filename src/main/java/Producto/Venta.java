package Producto;

import Gestor.GestionProducto;
import Repository.UsuarioRepo;
import usuario.Usuario;


import javax.swing.*;
import java.util.ArrayList;


public class Venta {
    GestionProducto gestionProducto = new GestionProducto();
    UsuarioRepo usuarioRepo=new UsuarioRepo();
    ArrayList<Producto> ventas = new ArrayList<>();

    public Venta() {
    }

    public void PublicarProducto(Usuario usuario) {

        Producto producto=new Producto();
        String nombreProducto = JOptionPane.showInputDialog("Ingrese nombre del producto");
        String Marca = JOptionPane.showInputDialog("Ingrese marca del producto");
        String descripcion = JOptionPane.showInputDialog("Coloque descripcion del producto. si es moda color talle y genero");
        String precio = JOptionPane.showInputDialog("Ingrese precio");
        double Precio = Double.parseDouble(precio);
        String stock = JOptionPane.showInputDialog("Ingrese el stock del producto");
        int Stock = Integer.parseInt(stock);
        int id = gestionProducto.ultimoId() + 1;
        String categoria1 = JOptionPane.showInputDialog("Seleccione categoria: Moda / Hogar / Tecnologia / Entretenimiento / Herramienta / Electrodomestico");

        switch (categoria1.toLowerCase()) {
            case "moda":
                producto.setCategoria(Producto.Tipo.MODA);
                String subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Remera / Camisa / Pantalon / Zapatilla / Abrigo");
                switch (subCategoria1.toLowerCase()) {
                    case "remera":
                        producto.setSubCategoria(Producto.SubTipo.REMERA);
                        break;
                    case "camisa":
                        producto.setSubCategoria(Producto.SubTipo.CAMISA);
                        break;
                    case "pantalon":
                        producto.setSubCategoria(Producto.SubTipo.PANTALON);
                        break;
                    case "zapatilla":
                        producto.setSubCategoria(Producto.SubTipo.ZAPATILLA);
                        break;
                    case "abrigo":
                        producto.setSubCategoria(Producto.SubTipo.ABRIGO);
                        break;
                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");
                        break;
                }
                break;

            case "hogar": {
                producto.setCategoria(Producto.Tipo.HOGAR);
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Iluminacion / Cocina / Decoracion / Jardin");
                switch (subCategoria1.toLowerCase()) {
                    case "iluminacion":
                        producto.setSubCategoria(Producto.SubTipo.ILUMINACION);
                        break;
                    case "cocina":
                        producto.setSubCategoria(Producto.SubTipo.COCINA);
                        break;
                    case "decoracion":
                        producto.setSubCategoria(Producto.SubTipo.DECORACION);
                        break;
                    case "jardin":
                        producto.setSubCategoria(Producto.SubTipo.JARDIN);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;
            }
            case "tecnologia": {

                producto.setCategoria(Producto.Tipo.TECNOLOGIA);
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Computacion / Celulares / Camaras / Consolas ");
                switch (subCategoria1.toLowerCase()) {
                    case "computacion":
                        producto.setSubCategoria(Producto.SubTipo.COMPUTACION);
                        break;
                    case "celulares":
                        producto.setSubCategoria(Producto.SubTipo.CELULARES);
                        break;
                    case "camaras":
                        producto.setSubCategoria(Producto.SubTipo.CAMARAS);
                        break;
                    case "consolas":
                        producto.setSubCategoria(Producto.SubTipo.CONSOLAS);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;
            }
            case "entretenimiento": {
                producto.setCategoria(Producto.Tipo.ENTRETENIMIENTO);
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Juguetes / Libros / Hobby ");
                switch (subCategoria1.toLowerCase()) {
                    case "juguetes":
                        producto.setSubCategoria(Producto.SubTipo.JUGUETES);
                        break;
                    case "libros":
                        producto.setSubCategoria(Producto.SubTipo.LIBROS);
                        break;
                    case "hobby":
                        producto.setSubCategoria(Producto.SubTipo.HOBBY);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;

            }
            case "electrodomestico": {
                producto.setCategoria(Producto.Tipo.ELECTRODOMESTICO);
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Calefaccion / Limpieza / Television ");
                switch (subCategoria1.toLowerCase()) {
                    case "calefaccion":
                        producto.setSubCategoria(Producto.SubTipo.CALEFACCION);
                        break;
                    case "limpieza":
                        producto.setSubCategoria(Producto.SubTipo.LIMPIEZA);
                        break;
                    case "television":
                        producto.setSubCategoria(Producto.SubTipo.TELEVISION);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;

            }
            case "herramienta": {
                producto.setCategoria(Producto.Tipo.HERRAMIENTAS);
                break;
            }


        }
        producto.setStock(Stock);
        producto.setNombreProducto(nombreProducto);
        producto.setDescripcion(descripcion);
        producto.setMarca(Marca);
        producto.setPrecio(Precio);
        producto.setId(id);

        gestionProducto.Agregar(producto);
        ventas.add(producto);
        usuario.setPublicaciones(this.ventas);
        usuarioRepo.Modificar(usuario);

    }


    public void EliminarPublicacion(Usuario usuario, Producto producto) {
        gestionProducto.Eliminar(producto);
        usuario.getPublicaciones().remove(producto);
        this.ventas=usuario.getPublicaciones();
        usuario.setPublicaciones(this.ventas);
        usuarioRepo.Modificar(usuario);
    }

    public void MostrarPublicaciones(Usuario usuario){
        usuario.getPublicaciones().forEach(System.out::println);
    }


}
