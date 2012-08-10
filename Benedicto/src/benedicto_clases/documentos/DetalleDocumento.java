package benedicto_clases.documentos;

import benedicto_clases.Grupo_de_Estudios.GrupoEstudio;

/**
 *
 * @author FRANKLIN
 */
public class DetalleDocumento {

    private GrupoEstudio grupoEstudio;
    private Articulo articulo;
    private int cantidad;
    private double precio;

    public DetalleDocumento(GrupoEstudio grupoEstudio, int cantidad, double precio) {
        this.grupoEstudio = grupoEstudio;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public DetalleDocumento(Articulo articulo, int cantidad, double precio) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public GrupoEstudio getGrupoEstudio() {
        return grupoEstudio;
    }

    public void setGrupoEstudio(GrupoEstudio grupoEstudio) {
        this.grupoEstudio = grupoEstudio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return cantidad * precio;
    }
}