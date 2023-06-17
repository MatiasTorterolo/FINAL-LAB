package Producto;
import Gestor.GestionProducto;
import Repository.ProducotoRepo;

import javax.swing.*;
import java.util.ArrayList;

public class CatalogoProducto {

    ProducotoRepo producotoRepo=new ProducotoRepo();
    private ArrayList<Producto> catalogo=producotoRepo.listar();


    public CatalogoProducto() {
    }

    public void Mostrar(){

        do {
            System.out.println("  Moda " + "  Hogar " + "  Tecnologia " + "  Entretenimiento " + "  Herramientas " + " Electrodomestico");
            String opcion = JOptionPane.showInputDialog("Seleccione categoria");
            switch (opcion.toLowerCase()) {
                case "moda":

                    System.out.println(" Remera " + " Camisa " + " Pantalon " + " Abrigo " + " Zapatilla " + " R: retroceder ");
                    String ropa = JOptionPane.showInputDialog("Seleccione Categoria de Ropa");
                    switch (ropa.toLowerCase()) {
                        case "remera":
                            Recorrer(Categoria.Tipo.MODA, SubCategoria.SubTipo.REMERA);
                            break;
                        case "camisa":
                            Recorrer(Categoria.Tipo.MODA, SubCategoria.SubTipo.CAMISA);
                            break;
                        case "abrigo":
                            Recorrer(Categoria.Tipo.MODA, SubCategoria.SubTipo.ABRIGO);
                            break;
                        case "pantalon":
                            Recorrer(Categoria.Tipo.MODA, SubCategoria.SubTipo.PANTALON);
                            break;
                        case "zapatilla":
                            Recorrer(Categoria.Tipo.MODA, SubCategoria.SubTipo.ZAPATILLA);
                            break;
                        case "r":
                            break;
                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }


                    break;
                case "hogar":
                    System.out.println(" Iluminacion " + " Cocina " + " Decoracion " + " Jardin "+ " R: retroceder ");
                    String hogar = JOptionPane.showInputDialog("Seleccione Categoria de Hogar");
                    switch (hogar.toLowerCase()) {
                        case "iluminacion":
                            Recorrer(Categoria.Tipo.HOGAR, SubCategoria.SubTipo.ILUMINACION);
                            break;
                        case "camisa":
                            Recorrer(Categoria.Tipo.HOGAR, SubCategoria.SubTipo.COCINA);
                            break;
                        case "campera":
                            Recorrer(Categoria.Tipo.HOGAR, SubCategoria.SubTipo.DECORACION);
                            break;
                        case "pantalon":
                            Recorrer(Categoria.Tipo.HOGAR, SubCategoria.SubTipo.JARDIN);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }

                    break;

                case "tecnologia":
                    System.out.println(" Computacion " + " Celulares " + " Camaras " + " Consolas "+ " R: retroceder ");
                    String tecnologia = JOptionPane.showInputDialog("Seleccione Categoria de Tecnologia");
                    switch (tecnologia.toLowerCase()) {
                        case "computacion":
                            Recorrer(Categoria.Tipo.TECNOLOGIA, SubCategoria.SubTipo.COMPUTACION);
                            break;
                        case "celulares":
                            Recorrer(Categoria.Tipo.TECNOLOGIA, SubCategoria.SubTipo.CELULARES);
                            break;
                        case "camara":
                            Recorrer(Categoria.Tipo.TECNOLOGIA, SubCategoria.SubTipo.CAMARAS);
                            break;
                        case "consola":
                            Recorrer(Categoria.Tipo.TECNOLOGIA, SubCategoria.SubTipo.CONSOLAS);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }
                    break;

                case "entretenimiento":
                    System.out.println(" Juguete " + " Libro " + " Hobby "+ " R: retroceder ");
                    String entretenimiento = JOptionPane.showInputDialog("Seleccione Categoria de Entretenimiento");
                    switch (entretenimiento.toLowerCase()) {
                        case "juguete":
                            Recorrer(Categoria.Tipo.ENTRETENIMIENTO, SubCategoria.SubTipo.JUGUETES);
                            break;
                        case "libro":
                            Recorrer(Categoria.Tipo.ENTRETENIMIENTO, SubCategoria.SubTipo.LIBROS);
                            break;
                        case "hobby":
                            Recorrer(Categoria.Tipo.ENTRETENIMIENTO, SubCategoria.SubTipo.HOBBY);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }
                    break;

                case "electrodomestico":
                    System.out.println(" Calefaccion " + " Limpieza " + " Television "+ " R: retroceder ");
                    String electroDomesticos = JOptionPane.showInputDialog("Seleccione Categoria de ElectroDomesticos");
                    switch (electroDomesticos.toLowerCase()) {
                        case "calefaccion":
                            Recorrer(Categoria.Tipo.ELECTRODOMESTICO, SubCategoria.SubTipo.CALEFACCION);
                            break;
                        case "limpieza":
                            Recorrer(Categoria.Tipo.ELECTRODOMESTICO, SubCategoria.SubTipo.LIMPIEZA);
                            break;
                        case "television":
                            Recorrer(Categoria.Tipo.ELECTRODOMESTICO, SubCategoria.SubTipo.TELEVISION);
                            break;
                        case "r":
                            break;

                        default:
                            System.out.println("opcion invalida. por favor, eliga una opcion valida. ");

                    }
                    break;
                case "herramientas":
                    for (Producto producto : this.catalogo) {
                        if ((producto.getSubCategoria().categoria.categoria == Categoria.Tipo.HERRAMIENTAS)) {
                            System.out.println(producto.toString());
                        }
                    }
                    break;


            }
            String bucle=JOptionPane.showInputDialog("desea continuar comprando?");
        }




    }


    public void Recorrer(Producto.Categoria.Tipo categoria, Producto.SubCategoria.SubTipo subCategoria) {


        for (Producto producto : this.catalogo){
            if (producto.getSubCategoria().categoria.categoria == categoria) {
                if (producto.getSubCategoria().subTipo == subCategoria) {
                    System.out.println(producto.toString());

                }
            }
        }
    }
}

