/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package benedicto_CTRL;

import benedicto_clases.*;
import benedicto_ordenamientos.DocumentoSortFecVencimiento;
import java.util.ArrayList;
import java.util.Collections;
import org.joda.time.DateTime;

/**
 *
 * @author u201216787
 */
public class DocumentoCTRL {

    private ArrayList<Documento> listadocumento = new ArrayList<Documento>();

    public void AgregarDocumento(Documento documento) {
        this.listadocumento.add(documento);
    }

/*    public ArrayList<Documento> Buscar(char tipo, String concepto, String numero, String fecEmision,
            String fecVencimiento, String fecPago, char estado) {
        Documento documento = null;
        ArrayList<Documento> listaencontrada = new ArrayList<Documento>();

        for (int i = 0; i < listadocumento.size(); i++) {
            documento = listadocumento.get(i);

            if (tipo == 'V') {

                if (documento.getConcepto().equals(concepto) || documento.getNumero().equals(numero)
                        || documento.getFecEmision().equals(fecEmision)
                        || documento.getFecPago().equals(fecPago) || documento.getEstado() != ' ') {

                    listaencontrada.add(documento);

                }
            }
            if (tipo == 'C') {
                if (documento.getConcepto().equals(concepto) || documento.getNumero().equals(numero)
                        || documento.getFecEmision().equals(fecEmision)
                        || documento.getFecPago().equals(fecPago) || documento.getEstado() != ' ') {
                    listaencontrada.add(documento);
                }
            }
        }

        return listaencontrada;
    }
*/
    public boolean EliminaDocumento(String numero, char tipo) {
        Documento documento;

        for (int i = 0; i < listadocumento.size(); i++) {
            documento = listadocumento.get(i);

            if (tipo == 'V') {
                if (documento.getNumero().equals(numero)) {
                    this.listadocumento.remove(i);
                    return true;
                }
            }

            if (tipo == 'C') {
                if (documento.getNumero().equals(numero)) {
                    this.listadocumento.remove(i);
                    return true;
                }
            }

        }
        return false;
    }

    public ArrayList<Documento> BusquedaVenta(String concepto, String numero, DateTime fecEmision, String empresa, DateTime fecVencimiento, DateTime fecPago, char estado) {
        ArrayList<Documento> listadoBusqueda = new ArrayList<Documento>();
        ArrayList<DetalleDocumento> detalleDocumento;

        // Buscar en la lista según los filtros ingresados
        if (concepto.isEmpty()) {
            for (Documento documento : listadocumento) {

                if (documento.getTipoMov().getTipoMov() == 'V'
                        && documento.getTipodoDoc().getTipoDoc() == 'C'
                        && (numero.isEmpty() || documento.getNumero() == numero)
                        && (fecEmision == null || documento.getFecEmision().equals(fecEmision))
                        && (empresa.isEmpty() || ((PersonaNatural) documento.getPersona() != null
                        && ((PersonaNatural) documento.getPersona()).getNombre().startsWith(empresa)))
                        && (fecVencimiento == null || documento.getFecVencimiento().equals(fecVencimiento))
                        && (fecPago == null || documento.getFecPago().equals(fecPago))
                        && (estado == ' ' || documento.getEstado() == estado)) {

                    listadoBusqueda.add(documento);
                }
            }
        } else {
            for (Documento documento : listadocumento) {
                
                detalleDocumento = documento.getDetalle();

                for (DetalleDocumento detalle : detalleDocumento) {
                    if (detalle.getArticulo() != null
                            && detalle.getArticulo().getNombre().startsWith(concepto)) {

                        if (documento.getTipoMov().getTipoMov() == 'V'
                                && documento.getTipodoDoc().getTipoDoc() == 'C'
                                && (numero.isEmpty() || documento.getNumero() == numero)
                                && (fecEmision == null || documento.getFecEmision().equals(fecEmision))
                                && (empresa.isEmpty() || ((PersonaNatural) documento.getPersona() != null
                                && ((PersonaNatural) documento.getPersona()).getNombre().startsWith(empresa)))
                                && (fecVencimiento == null || documento.getFecVencimiento().equals(fecVencimiento))
                                && (fecPago == null || documento.getFecPago().equals(fecPago))
                                && (estado == ' ' || documento.getEstado() == estado)) {

                            listadoBusqueda.add(documento);
                            break;
                        }
                    }
                }
            }
        }

        // Ordenar por fecha de vencimiento
        Collections.sort(listadoBusqueda, new DocumentoSortFecVencimiento());

        return listadoBusqueda;
    }
}
