package Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import usuario.Usuario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioRepo implements IRepository<Usuario>{
    private final File archivo = new File("src/main/java/archivo/Usuario.json");
    private final ObjectMapper mapper = new ObjectMapper();
    private ArrayList<Usuario> Usuarios;

    public UsuarioRepo() {
    }

    public void cargar() {
        try {
            CollectionType collectionType = mapper.getTypeFactory().constructCollectionType(ArrayList.class,Usuario.class);
            this.Usuarios = mapper.readValue(archivo,collectionType);
        }catch (IOException e){
            this.Usuarios = new ArrayList<>();
        }
    }

    public void guardar() {

        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(archivo, this.Usuarios);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Usuario> listar() {
        cargar();
        return this.Usuarios;
    }
    @Override
    public void agregar(Usuario... objeto) {
        cargar();
        this.Usuarios.addAll(Arrays.asList(objeto));
        guardar();
    }
    public void eliminar(Usuario usuario) {
        cargar();
        this.Usuarios.remove(usuario);
        guardar();
    }

    @Override
    public void Modificar(Usuario usuario) {
        cargar();
        for (Usuario usuarioEncontrado : this.Usuarios){
            if(usuarioEncontrado.equals(usuario)){
                int index=this.Usuarios.indexOf(usuarioEncontrado);
                this.Usuarios.set(index,usuario);
                break;
            }
        }
        guardar();
    }
}
