package benedicto_clases.documentos;

public class Tipo_Mov {

    private char tipoMov;
    private String nombreMov;

    public Tipo_Mov(char tipoMov) {
        this.tipoMov = tipoMov;
    }

    public char getTipoMov() {
        return tipoMov;
    }

    public boolean VerificarTipo(Documento documento) {
        if (documento.getTipoMov().getTipoMov() != ' ' && documento.getTipoMov().getTipoMov() == 'C' || documento.getTipoMov().getTipoMov() == 'V') {
            return true;
        }
        return false;
    }
}
