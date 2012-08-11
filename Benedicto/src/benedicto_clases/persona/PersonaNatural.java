package benedicto_clases.persona;

import benedicto_clases.persona.Persona;

public class PersonaNatural extends Persona {

    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String dni;
    private TipoPersona tipo_persona;

    public PersonaNatural(String nombre, String ap_paterno, String ap_materno, String dni, TipoPersona tipo_persona, String codigo) {
        super(codigo);
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.dni = dni;
        this.tipo_persona = tipo_persona;
    }

    public PersonaNatural(String nombre, String ap_paterno, String ap_materno, String dni, String codigo) {
        super(codigo);
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.dni = dni;
        this.tipo_persona = tipo_persona;
    }

    public PersonaNatural(String nombre, String ap_paterno, String ap_materno, String dni, TipoPersona tipo_persona, String codigo, String e_mail, String telefono, String celular) {
        super(codigo, e_mail, telefono, celular);
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.dni = dni;
        this.tipo_persona = tipo_persona;
    }

    public boolean VerificarObligatorios() {
        if (this.nombre == null || this.nombre.trim().equals("")) {
            return false;
        }
        if (this.ap_paterno == null || this.ap_paterno.trim().equals("")) {
            return false;
        }
        if (this.ap_materno == null || this.ap_materno.trim().equals("")) {
            return false;
        }
        if (this.dni == null || this.dni.trim().equals("")) {
            return false;
        }
        return true;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public TipoPersona getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(TipoPersona tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public PersonaNatural() {
    }
}
