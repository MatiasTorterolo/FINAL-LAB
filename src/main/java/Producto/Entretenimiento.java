package Producto;

public class Entretenimiento extends Producto{
    private CategoriaEntretenimiento categoriaEntretenimiento;
    enum CategoriaEntretenimiento{
        JUGUETERIA,LIBROS
    }
    //region constructor

    public Entretenimiento(String nombre, String marca, double precio, int id, String descipcion, Categoria categoria, CategoriaEntretenimiento categoriaEntretenimiento) {
        super(nombre, marca, precio, id, descipcion, categoria);
        this.categoriaEntretenimiento = categoriaEntretenimiento;
    }

    public Entretenimiento() {
    }
//endregion
    //region s and g

    public CategoriaEntretenimiento getCategoriaEntretenimiento() {
        return categoriaEntretenimiento;
    }

    public void setCategoriaEntretenimiento(CategoriaEntretenimiento categoriaEntretenimiento) {
        this.categoriaEntretenimiento = categoriaEntretenimiento;
    }

    //endregion
}
