

package benedicto_clases;

// autor : Luis Valle
public class Tipo_Mov {

    private char tipoMov;
    private String nombreMov;

    public Tipo_Mov(char tipoMov) {
        this.tipoMov = tipoMov;
    }

    public char getTipoMov() {
        return tipoMov;
    }
/*
    public boolean VerificarTipo(Documento documento) {
       if (documento.getTipoMov() != ' ' && (documento.getTipoMov() == 'C' ||
           documento.getTipoMov() == 'V')){
           return true;}
        return false;
    }
*/
}
