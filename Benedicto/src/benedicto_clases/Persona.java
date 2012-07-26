

package benedicto_clases;


public class Persona {

    private String nombres;
    private String ap_paterno;
    private String ap_materno;
    private String ruc;
    private String e_mail;
    private String dni;
    private String telefono;
    private String celular;
    private TipoPersona tipo_persona;
    private String codigo;
    

    public Persona(String nombres, String ap_paterno, String ap_materno, String ruc, String e_mail) {
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.ruc = ruc;
        this.e_mail = e_mail;
    }

    public Persona(String nombres, String ap_paterno, String ap_materno, String ruc, String e_mail, TipoPersona tipoper) {
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.ruc = ruc;
        this.e_mail = e_mail;
        this.tipo_persona = tipoper;
    }

    public Persona() {

    }

    public Persona(String codigo, String nombres, String ap_paterno, String ap_materno, String ruc, String e_mail, TipoPersona tipoper) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.ruc = ruc;
        this.e_mail = e_mail;
        this.tipo_persona = tipoper;
    }



    public TipoPersona getTipo_persona() {
        return tipo_persona;
    }



    public boolean VerificarOblitarios () {
        if (this.nombres == null || this.nombres.trim().equals("")){
            return false;}
        if (this.ap_paterno == null || this.ap_paterno.trim().equals("")){
            return false;}
        if (this.ap_materno == null || this.ap_materno.trim().equals("")){
            return false;}
        if (this.ruc == null || this.ruc.trim().equals("")){
            return false;}
        if (this.e_mail == null || this.e_mail.trim().equals("")){
            return false;}
        return true;
    }

    public String getNombres() {
        return nombres;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setTipo_persona(TipoPersona tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

//    public static void ActualizaEstado(TipoPersona tipoper) {
//        setTipo_Persona(tipoper);
//    }


}
