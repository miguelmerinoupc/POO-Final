package benedicto_clases.persona;

// autor : Miguel Merino
public class Persona {
//<-- Franklin velita

    protected String codigo;
    protected String e_mail;
    protected String telefono;
    protected String celular;

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Persona() {
    }

    public Persona(String codigo) {
        this.codigo = codigo;
    }

    public Persona(String codigo, String e_mail, String telefono, String celular) {
        this.codigo = codigo;
        this.e_mail = e_mail;
        this.telefono = telefono;
        this.celular = celular;
    }
}
