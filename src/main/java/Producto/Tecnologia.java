package Producto;

public class Tecnologia extends Producto {
    private  CategoriaTecnologia categoriaTecnologia;
    enum CategoriaTecnologia{
        TELEVISOR,CELULAR,AURICULARES,PARLANTE,AIRE_ACONDICIONADO,VARIOS
    }
    //region constructor

    public Tecnologia(String nombre, String marca, double precio, int id, String descipcion, Categoria categoria, CategoriaTecnologia categoriaTecnologia) {
        super(nombre, marca, precio, id, descipcion, categoria);
        this.categoriaTecnologia = categoriaTecnologia;
    }

    public Tecnologia() {

    }


    //endregion
    //region s and g

    public CategoriaTecnologia getCategoriaTecnologia() {
        return categoriaTecnologia;
    }

    public void setCategoriaTecnologia(CategoriaTecnologia categoriaTecnologia) {
        this.categoriaTecnologia = categoriaTecnologia;
    }

    //endregion
}
