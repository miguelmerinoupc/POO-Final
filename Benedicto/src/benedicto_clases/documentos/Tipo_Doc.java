package benedicto_clases.documentos;

public class Tipo_Doc {

    private char tipoDoc;
    private String nombreDoc;

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public char getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(char tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Tipo_Doc(char tipoDoc, String nombreDoc) {
        this.tipoDoc = tipoDoc;
        this.nombreDoc = nombreDoc;
    }

    public Tipo_Doc(char tipoDoc) {
        this.tipoDoc = tipoDoc;
    }
}
