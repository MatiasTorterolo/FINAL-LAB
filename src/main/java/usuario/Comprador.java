package usuario;

public class Comprador extends Usuario{
    private String tajerta;
//region constructor
    public Comprador(String nombreYapellido, String direccion, int id, String email, String tajerta) {
        super(nombreYapellido, direccion, id, email);
        this.tajerta = tajerta;
    }

    public Comprador() {

    }
    //endregion
//region s and g

    public String getTajerta() {
        return tajerta;
    }

    public void setTajerta(String tajerta) {
        this.tajerta = tajerta;
    }

//endregion
}
