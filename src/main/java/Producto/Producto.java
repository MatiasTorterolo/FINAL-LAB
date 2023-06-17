package Producto;

import java.util.Objects;

public class Producto {
    private String nombreProducto;
    private String marca;
    private String descripcion;
    private double precio;

    private SubCategoria subCategoria;
    private int id;
    private int stock;

    //region constructor

    public Producto(String nombreProducto, String marca, String descripcion, double precio,SubCategoria categoria,int id,int stock) {
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.descripcion = descripcion;
        this.precio = precio;
        this.subCategoria = categoria;
        this.id=id;
        this.stock=stock;
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

    public SubCategoria getSubCategoria() {
        return this.subCategoria;
    }

    public void setSubCategoria(SubCategoria categoria) {
        this.subCategoria = categoria;
    }

    //endregion


    @Override
    public String toString() {
        return "Producto{" +
                "nombreProducto='" + nombreProducto + '\'' +
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
