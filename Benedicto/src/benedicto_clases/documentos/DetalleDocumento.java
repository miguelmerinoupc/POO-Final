package benedicto_clases.documentos;

import benedicto_clases.Grupo_de_Estudios.GrupoEstudio;

/**
 *
 * @author FRANKLIN
 */
public class DetalleDocumento {

    private GrupoEstudio grupoEstudio;
    private Articulo articulo;

    public Articulo getArticulo() {
        return articulo;
    }
    private int cantidad;
    private double precio;

    public double getTotal() {
        return cantidad * precio;
    }
}