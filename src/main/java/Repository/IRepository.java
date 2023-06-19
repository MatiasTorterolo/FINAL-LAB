package Repository;

import Producto.Categoria;
import Producto.Producto;

import java.util.List;

public interface IRepository<T> {

    void cargar();
    void guardar();
    List<T> listar();
    void agregar(T... objeto);
    void eliminar(T objeto);
    void Modificar(T objeto);
    T Buscar(int id);

}