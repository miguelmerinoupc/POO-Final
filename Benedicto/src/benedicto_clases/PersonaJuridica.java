package benedicto_clases;

public class PersonaJuridica extends Persona {

    private String razon_social;
    private String ruc;

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public PersonaJuridica(String razon_social, String ruc, String codigo) {
        super(codigo);
        this.razon_social = razon_social;
        this.ruc = ruc;
    }

    public PersonaJuridica(String ruc, String codigo) {
        super(codigo);
        this.ruc = ruc;
    }

    public PersonaJuridica(String razon_social, String ruc, String codigo, String e_mail, String telefono, String celular) {
        super(codigo, e_mail, telefono, celular);
        this.razon_social = razon_social;
        this.ruc = ruc;
    }

    public boolean VerificarObligatorios() {
        if (this.razon_social == null || this.razon_social.trim().equals("")) {
            return false;
        }
        if (this.ruc == null || this.ruc.trim().equals("")) {
            return false;
        }
        return true;
    }
}
