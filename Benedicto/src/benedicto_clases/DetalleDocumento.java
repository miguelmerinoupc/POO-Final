package benedicto_clases;

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