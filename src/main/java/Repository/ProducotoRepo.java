package Repository;
import Producto.Producto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProducotoRepo implements IRepository<Producto> {
    private final File archivo = new File("src/main/java/Archivos/productos.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Producto> listaProductos;

    public ProducotoRepo() {
    }

    @Override
    public void cargar() {

        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, Producto.class);
            this.listaProductos = mapper.readValue(archivo, collectionType);
        } catch (IOException e) {
            this.listaProductos = new ArrayList<>();
        }
    }
    @Override
    public void guardar() {

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.listaProductos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public ArrayList<Producto> listar() {
        cargar();
        return this.listaProductos;
    }
    @Override
    public void agregar(Producto... objeto) {
        cargar();
        this.listaProductos.addAll(Arrays.asList(objeto));
        guardar();
    }
    public void eliminar(Producto producto) {
        cargar();
        this.listaProductos.remove(producto);
        guardar();
    }

    @Override
    public void Modificar(Producto producto) {
        cargar();
        for (Producto productoEncontrado : this.listaProductos){
            if(productoEncontrado.equals(producto)){
                int index=this.listaProductos.indexOf(productoEncontrado);
                this.listaProductos.set(index,producto);
                break;
            }
        }
        guardar();
    }


    public Producto Buscar(int id) {
       cargar();
        for (Producto productoEncontrado : this.listaProductos) {
            if (productoEncontrado.getId() == id) {
                return productoEncontrado;
            }
        }
        return null;
    }



}



