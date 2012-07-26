

package benedicto_clases;


public class TipoPersona {
    private char tipo_persona;
    private String nombre;

    public TipoPersona(char tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public boolean VerificarTipo(Persona persona) {
       if (persona.getTipo_persona() != ' ' && (persona.getTipo_persona() == 'C' ||
           persona.getTipo_persona() == 'P')){
           return true;}
        return false;
    }

    public char getTipo_persona() {
        return tipo_persona;
    }


}
