package Producto;

public class Computacion extends Producto{
    private CategoriaComputacion categoriaComputacion;
    enum CategoriaComputacion{
        PC_ESCRITORIO,NOTEBOOKS,IMPRESORA,AURICULARES,MOUSE_TECLADO,COMPONENTES
    }

    //region constructor

    public Computacion(String nombre, String marca, double precio, int id, String descipcion, Categoria categoria, CategoriaComputacion categoriaComputacion) {
        super(nombre, marca, precio, id, descipcion, categoria);
        this.categoriaComputacion = categoriaComputacion;
    }

    public Computacion() {

    }

    //endregion
    //region s and g

    public CategoriaComputacion getCategoriaComputacion() {
        return categoriaComputacion;
    }

    public void setCategoriaComputacion(CategoriaComputacion categoriaComputacion) {
        this.categoriaComputacion = categoriaComputacion;
    }

    //endregion
}
