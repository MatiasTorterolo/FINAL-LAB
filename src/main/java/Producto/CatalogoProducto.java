package Producto;
import Repository.ProductoRepo;
import Repository.UsuarioRepo;
import usuario.Usuario;

import javax.swing.*;
import java.util.ArrayList;

public class CatalogoProducto  {

    ProductoRepo ProductoRepo = new ProductoRepo();
    private ArrayList<Producto> catalogo = ProductoRepo.listar();
    private ArrayList<Producto> carrito = new ArrayList<>();
    private UsuarioRepo usuarioRepo = new UsuarioRepo();

    public CatalogoProducto() {
    }

    public void Mostrar(Usuario usuario){
    String bucle;
        do {

            System.out.println("  Moda " + "  Hogar " + "  Tecnologia " + "  Entretenimiento " + "  Herramientas " + " Electrodomestico");
            String opcion = JOptionPane.showInputDialog("Seleccione categoria");
            switch (opcion.toLowerCase()) {
                case "moda":

                    System.out.println(" remera " + " camisa " + " pantalon " + " abrigo " + " zapatilla " + " r: retroceder ");
                    String ropa = JOptionPane.showInputDialog("Seleccione Categoria de Ropa");
                    switch (ropa.toLowerCase()) {
                        case "remera":
                            Recorrer(Producto.Tipo.MODA, Producto.SubTipo.REMERA);
                            break;
                        case "camisa":
                            Recorrer(Producto.Tipo.MODA, Producto.SubTipo.CAMISA);
                            break;
                        case "abrigo":
                            Recorrer(Producto.Tipo.MODA, Producto.SubTipo.ABRIGO);
                            break;
                        case "pantalon":
                            Recorrer(Producto.Tipo.MODA, Producto.SubTipo.PANTALON);
                            break;
                        case "zapatilla":
                            Recorrer(Producto.Tipo.MODA, Producto.SubTipo.ZAPATILLA);

                            break;
                        case "r":
                            break;
                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }


                    break;
                case "hogar":
                    System.out.println(" iluminacion " + " cocina " + " decoracion " + " jardin " + " R: retroceder ");
                    String hogar = JOptionPane.showInputDialog("Seleccione Categoria de Hogar");
                    switch (hogar.toLowerCase()) {
                        case "iluminacion":
                            Recorrer(Producto.Tipo.HOGAR, Producto.SubTipo.ILUMINACION);
                            break;
                        case "cocina":
                            Recorrer(Producto.Tipo.HOGAR, Producto.SubTipo.COCINA);
                            break;
                        case "decoracion":
                            Recorrer(Producto.Tipo.HOGAR, Producto.SubTipo.DECORACION);
                            break;
                        case "jardin":
                            Recorrer(Producto.Tipo.HOGAR, Producto.SubTipo.JARDIN);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }

                    break;

                case "tecnologia":
                    System.out.println(" computacion " + " celulares " + " camaras " + " consolas " + " r: retroceder ");
                    String tecnologia = JOptionPane.showInputDialog("Seleccione Categoria de Tecnologia");
                    switch (tecnologia.toLowerCase()) {
                        case "computacion":
                            Recorrer(Producto.Tipo.TECNOLOGIA, Producto.SubTipo.COMPUTACION);
                            break;
                        case "celulares":
                            Recorrer(Producto.Tipo.TECNOLOGIA, Producto.SubTipo.CELULARES);
                            break;
                        case "camara":
                            Recorrer(Producto.Tipo.TECNOLOGIA, Producto.SubTipo.CAMARAS);
                            break;
                        case "consola":
                            Recorrer(Producto.Tipo.TECNOLOGIA, Producto.SubTipo.CONSOLAS);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }
                    break;

                case "entretenimiento":
                    System.out.println(" juguete " + " libro " + " hobby " + " r: retroceder ");
                    String entretenimiento = JOptionPane.showInputDialog("Seleccione Categoria de Entretenimiento");
                    switch (entretenimiento.toLowerCase()) {
                        case "juguete":
                            Recorrer(Producto.Tipo.ENTRETENIMIENTO, Producto.SubTipo.JUGUETES);
                            break;
                        case "libro":
                            Recorrer(Producto.Tipo.ENTRETENIMIENTO, Producto.SubTipo.LIBROS);
                            break;
                        case "hobby":
                            Recorrer(Producto.Tipo.ENTRETENIMIENTO, Producto.SubTipo.HOBBY);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }
                    break;

                case "electrodomestico":
                    System.out.println(" calefaccion " + " limpieza " + " television " + " R: retroceder ");
                    String electroDomesticos = JOptionPane.showInputDialog("Seleccione Categoria de ElectroDomesticos");
                    switch (electroDomesticos.toLowerCase()) {
                        case "calefaccion":
                            Recorrer(Producto.Tipo.ELECTRODOMESTICO, Producto.SubTipo.CALEFACCION);
                            break;
                        case "limpieza":
                            Recorrer(Producto.Tipo.ELECTRODOMESTICO, Producto.SubTipo.LIMPIEZA);
                            break;
                        case "television":
                            Recorrer(Producto.Tipo.ELECTRODOMESTICO, Producto.SubTipo.TELEVISION);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }
                    break;
                case "herramientas":
                    for (Producto producto : this.catalogo) {
                        if ((producto.getCategoria() == Producto.Tipo.HERRAMIENTAS)) {
                            if (producto.getStock() == 0) {
                                System.out.println(producto.toString());
                                System.out.println("NO HAY STOCK DISPONIBLE");
                            } else {
                                System.out.println(producto.toString());
                            }
                        }
                    }
                    break;


            }
            String comprar = JOptionPane.showInputDialog("Ingrese ID del producto que desea comprar. 's' para seguir comprando");
            if (comprar.equals("s")) {
                 bucle = "si";
            } else {
                bucle="no";
                int id = Integer.parseInt(comprar);
                Producto productoComprar = ProductoRepo.Buscar(id);
                try {
                    if (productoComprar == null) {
                        throw new RuntimeException("El id no pertenece a un producto en el catalogo");
                    } else {
                        System.out.println("Producto: " + productoComprar.toString());
                        if (productoComprar.getStock() == 0) {
                            System.out.println("NO HAY STOCK DISPONIBLE");
                        } else {
                            comprar = JOptionPane.showInputDialog("'Comprar' o 'Carrito' para agregar al carrito");
                            if (comprar.equalsIgnoreCase("comprar")) {
                                Comprar(usuario, productoComprar);
                            } else if (comprar.equalsIgnoreCase("carrito")) {
                                AgregarProductoCarrito(productoComprar);
                            }
                        }
                    }
                } catch (RuntimeException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
            if(bucle.equals("no")){
                bucle=JOptionPane.showInputDialog("Desea seguir mirando el catalogo?");
            }
        }while (bucle.equals("si"));
        }







    public void Recorrer(Producto.Tipo categoria, Producto.SubTipo subCategoria) {


        for (Producto producto : this.catalogo){
            if (producto.getCategoria() == categoria) {
                if (producto.getSubCategoria() == subCategoria) {
                    if(producto.getStock()==0){
                        System.out.println(producto.toString());
                        System.out.println("NO HAY STOCK DISPONIBLE");
                    }else {
                        System.out.println(producto.toString());
                    }
                }
            }
        }
    }



    public void MostrarCarrito(){
        if(this.carrito==null){
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
                    producto.setStock(producto.getStock()-1);
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
            producto.setStock(producto.getStock()-1);
            this.carrito.add(producto);
            System.out.println("Se agrego producto al carrito");
        }
    }

    public void EliminarProductoCarrito(Producto producto){
        if (this.carrito.contains(producto)){
            this.carrito.remove(producto);
            System.out.println("Producto eliminado");
        }else {
            System.out.println("El producto no se encuentra en el carrito");
        }
    }

    public void Comprar(Usuario usuario,Producto producto) {
        if (usuario.getCompras() == null) {
            ArrayList<Producto> comprar = new ArrayList<>();
            comprar.add(producto);
            usuario.setCompras(comprar);
            usuarioRepo.Modificar(usuario);
            ProductoRepo.Modificar(producto);

        } else {
            producto.setStock(producto.getStock() - 1);
            ArrayList<Producto> comprar = usuario.getCompras();
            comprar.add(producto);
            usuario.setCompras(comprar);
            usuarioRepo.Modificar(usuario);
            ProductoRepo.Modificar(producto);
        }
        System.out.println("Productos comprado");
    }

    public void PagarCarrito(Usuario usuario){
        if(usuario.getCompras()==null){
            ArrayList<Producto>comprar=this.carrito;
            usuarioRepo.Modificar(usuario);
            for(Producto prodModificado : this.carrito){
                ProductoRepo.Modificar(prodModificado);
            }

        }else {
            ArrayList<Producto> comprar = usuario.getCompras();
            comprar.addAll(this.carrito);
            usuario.setCompras(comprar);
            usuarioRepo.Modificar(usuario);
            for (Producto prodModificado : this.carrito) {
                ProductoRepo.Modificar(prodModificado);
            }
        }
    }
}

