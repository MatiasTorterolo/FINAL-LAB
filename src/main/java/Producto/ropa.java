package Producto;

public class ropa extends Producto {
    private String talle;

    private String genero;

    //region constructor


    public ropa(String nombreProducto, String marca, String descripcion, double precio, SubCategoria categoria, int id, int stock, String talle, String genero) {
        super(nombreProducto, marca, descripcion, precio, categoria, id, stock);
        this.talle = talle;
        this.genero = genero;
    }

    public ropa() {

    }

    //endregion
    //region s and g

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }




    @Override
    public String toString() {
        return "ropa{" +
                "talle='" + talle + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
