package Gestor;

import java.util.Scanner;

public interface Gestiones<T> {
    void Mostrar();
    void Agregar(T objeto);
    void Eliminar(T objeto);
    boolean Existe(T objeto);
    void Modificar(Scanner scanner);
    T Buscar(int id);
}
