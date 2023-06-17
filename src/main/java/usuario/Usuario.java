package usuario;

import Producto.Producto;

import java.util.ArrayList;
import java.util.Objects;

public  class Usuario {
    private String nombreYapellido;
    private String direccion;
    private int id;
    private String email;
    private String pass;

    private ArrayList<Producto> publicaciones;
    private ArrayList<Producto> compras;



    //region constructor

    public Usuario(String nombreYapellido, String direccion, int id, String email,String pass) {
        this.nombreYapellido = nombreYapellido;
        this.direccion = direccion;
        this.id = id;
        this.email = email;
        this.pass=pass;
    }

    public Usuario() {
    }
//endregion
    // region s ans g

    public ArrayList<Producto> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Producto> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public ArrayList<Producto> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Producto> compras) {
        this.compras = compras;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //endregion

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreYapellido='" + nombreYapellido + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
