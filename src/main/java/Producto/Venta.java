package Producto;

import Gestor.GestionProducto;
import Gestor.GestionUsuario;
import Producto.Producto;
import Repository.UsuarioRepo;
import usuario.Usuario;
import Producto.Categoria;


import javax.swing.*;
import java.util.ArrayList;


public class Venta {
    GestionProducto gestionProducto = new GestionProducto();
    UsuarioRepo usuarioRepo=new UsuarioRepo();
    ArrayList<Producto> ventas = new ArrayList<>();
    SubCategoria subCategoria = new SubCategoria();
    Categoria categoria = new Categoria();

    public Venta() {
    }

    public void PublicarProducto(Usuario usuario) {

        Producto producto=new Producto();
        String nombreProducto = JOptionPane.showInputDialog("Ingrese nombre del producto");
        String Marca = JOptionPane.showInputDialog("Ingrese marca del producto");
        String descripcion = JOptionPane.showInputDialog("Coloque descripcion del producto. si el ropa colore talle, genero y color");
        String precio = JOptionPane.showInputDialog("Ingrese precio");
        double Precio = Double.parseDouble(precio);
        String stock = JOptionPane.showInputDialog("Ingrese el stock del producto");
        int Stock = Integer.parseInt(stock);
        int id = gestionProducto.ultimoId() + 1;
        String categoria1 = JOptionPane.showInputDialog("Seleccione categoria: Moda / Hogar / Tecnologia / Entretenimiento / Herramienta / Electrodomestico");

        switch (categoria1.toLowerCase()) {
            case "moda":
                subCategoria.categoria = Categoria.Tipo.MODA;
                String subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Remera / Camisa / Pantalon / Zapatilla / Abrigo");
                switch (subCategoria1.toLowerCase()) {
                    case "remera":
                        subCategoria.subTipo = SubCategoria.SubTipo.REMERA;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "camisa":
                        subCategoria.subTipo = SubCategoria.SubTipo.CAMISA;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "pantalon":
                        subCategoria.subTipo = SubCategoria.SubTipo.PANTALON;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "zapatilla":
                        subCategoria.subTipo = SubCategoria.SubTipo.ZAPATILLA;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "abrigo":
                        subCategoria.subTipo = SubCategoria.SubTipo.ABRIGO;
                        producto.setSubCategoria(subCategoria);
                        break;
                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");
                        break;
                }

            case "hogar": {
                subCategoria.categoria = Categoria.Tipo.HOGAR;
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Iluminacion / Cocina / Decoracion / Jardin");
                switch (subCategoria1.toLowerCase()) {
                    case "iluminacion":
                        subCategoria.subTipo = SubCategoria.SubTipo.ILUMINACION;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "cocina":
                        subCategoria.subTipo = SubCategoria.SubTipo.COCINA;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "decoracion":
                        subCategoria.subTipo = SubCategoria.SubTipo.DECORACION;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "jardin":
                        subCategoria.subTipo = SubCategoria.SubTipo.JARDIN;
                        producto.setSubCategoria(subCategoria);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;
            }
            case "tecnologia": {

                subCategoria.categoria = Categoria.Tipo.TECNOLOGIA;
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Computacion / Celulares / Camaras / Consolas ");
                switch (subCategoria1.toLowerCase()) {
                    case "computacion":
                        subCategoria.subTipo = SubCategoria.SubTipo.COMPUTACION;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "celulares":
                        subCategoria.subTipo = SubCategoria.SubTipo.CELULARES;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "camaras":
                        subCategoria.subTipo = SubCategoria.SubTipo.CAMARAS;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "consolas":
                        subCategoria.subTipo = SubCategoria.SubTipo.CONSOLAS;
                        producto.setSubCategoria(subCategoria);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;
            }
            case "entretenimiento": {
                subCategoria.categoria = Categoria.Tipo.ENTRETENIMIENTO;
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Juguetes / Libros / Hobby ");
                switch (subCategoria1.toLowerCase()) {
                    case "juguetes":
                        subCategoria.subTipo = SubCategoria.SubTipo.JUGUETES;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "libros":
                        subCategoria.subTipo = SubCategoria.SubTipo.LIBROS;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "hobby":
                        subCategoria.subTipo = SubCategoria.SubTipo.HOBBY;
                        producto.setSubCategoria(subCategoria);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;

            }
            case "electrodomestico": {
                subCategoria.categoria = Categoria.Tipo.ELECTRODOMESTICO;
                subCategoria1 = JOptionPane.showInputDialog("Seleccione SubCategoria: Calefaccion / Limpieza / Television ");
                switch (subCategoria1.toLowerCase()) {
                    case "calefaccion":
                        subCategoria.subTipo = SubCategoria.SubTipo.CALEFACCION;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "limpieza":
                        subCategoria.subTipo = SubCategoria.SubTipo.LIMPIEZA;
                        producto.setSubCategoria(subCategoria);
                        break;
                    case "television":
                        subCategoria.subTipo = SubCategoria.SubTipo.TELEVISION;
                        producto.setSubCategoria(subCategoria);
                        break;

                    default:
                        System.out.println("ERROR: ESCOJA UNA DE LAS CATEGORIAS MOSTRADAS ");

                }
                break;

            }
            case "herramienta": {
                subCategoria.categoria = Categoria.Tipo.HERRAMIENTAS;
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
