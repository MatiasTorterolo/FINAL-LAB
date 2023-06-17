package Producto;

public class Hogar extends Producto{
    private CategoriaHogar categoriaHogar;
    enum CategoriaHogar{
        MUEBLES,COCINA_BAZAR,DECORACION,JARDIN
    }
//region constuctor
    public Hogar(String nombre, String marca, double precio, int id, String descipcion, Categoria categoria, CategoriaHogar categoriaHogar) {
        super(nombre, marca, precio, id, descipcion, categoria);
        this.categoriaHogar = categoriaHogar;
    }

    public Hogar() {

    }
    //endregion
//region s and g

    public CategoriaHogar getCategoriaHogar() {
        return categoriaHogar;
    }

    public void setCategoriaHogar(CategoriaHogar categoriaHogar) {
        this.categoriaHogar = categoriaHogar;
    }

//endregion
}
