package Producto;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {
    private String nombreProducto;
    private String marca;
    private String descripcion;
    private double precio;
    private SubTipo subCategoria;
    private Tipo categoria;
    private int id;
    private int stock;

    enum SubTipo {
        //MODA
        REMERA, CAMISA, PANTALON, ZAPATILLA, ABRIGO,

        //HOGAR
        ILUMINACION, COCINA, DECORACION, JARDIN,

        //TECNOLOGIA
        COMPUTACION, CELULARES, CAMARAS, CONSOLAS,

        //ENTRETENIMIENTO
        JUGUETES,LIBROS,HOBBY,

        //ELECTRODOMESTICO
        CALEFACCION, LIMPIEZA, TELEVISION

    }

    enum Tipo{
        MODA,
        HOGAR,
        TECNOLOGIA,
        ENTRETENIMIENTO,
        HERRAMIENTAS,
        ELECTRODOMESTICO,
    }

    //region constructor


    public Producto(String nombreProducto, String marca, String descripcion, double precio, SubTipo subCategoria, Tipo categoria, int id, int stock) {
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.subCategoria = subCategoria;
        this.categoria = categoria;
        this.id = id;
        this.stock = stock;
    }

    public Producto() {
    }
    //endregion
    // region s and g


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public SubTipo getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubTipo subCategoria) {
        this.subCategoria = subCategoria;
    }

    public Tipo getCategoria() {
        return categoria;
    }

    public void setCategoria(Tipo categoria) {
        this.categoria = categoria;
    }

//endregion


    @Override
    public String toString() {
        return "Producto{" +
                "ID='" + id + '\'' +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", marca='" + marca + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
