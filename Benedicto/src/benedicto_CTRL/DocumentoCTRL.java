/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package benedicto_CTRL;

import benedicto_clases.documentos.*;
import benedicto_clases.persona.PersonaJuridica;
import benedicto_ordenamientos.DocumentoSortFecVencimiento;
import java.util.ArrayList;
import java.util.Collections;
import org.joda.time.DateTime;

/**
 *
 * @author FRANKLIN
 */
public class DocumentoCTRL {

    private ArrayList<Documento> listadocumento = new ArrayList<Documento>();

    public void AgregarDocumento(Documento documento) {
        this.listadocumento.add(documento);
    }

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

    public ArrayList<Documento> BuscarMovimiento(Articulo concepto, String numero, DateTime fecEmision, String empresa, DateTime fecVencimiento, DateTime fecPago, char estado) {
        ArrayList<Documento> listadoBusqueda = new ArrayList<Documento>();
        ArrayList<DetalleDocumento> detalleDocumento;

        if (concepto.getNombre().isEmpty()) {
            for (Documento documento : listadocumento) {
                if (documento.getTipoMov().getTipoMov() == 'C'
                        && documento.getTipodoDoc().getTipoDoc() == 'F'
                        && (numero.isEmpty() || documento.getNumero() == numero)
                        && (fecEmision == null || documento.getFecEmision().equals(fecEmision))
                        && (empresa.isEmpty() || ((PersonaJuridica) documento.getPersona() != null
                        && ((PersonaJuridica) documento.getPersona()).getRuc().startsWith(empresa)))
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
                    if (detalle.getArticulo() != null && detalle.getArticulo().getNombre() == concepto.getNombre()
                            && documento.getTipoMov().getTipoMov() == 'C' && documento.getTipodoDoc().getTipoDoc() == 'F'
                            && (documento.getNumero() == numero) && (empresa.isEmpty() || ((PersonaJuridica) documento.getPersona() != null
                            && ((PersonaJuridica) documento.getPersona()).getRuc().startsWith(empresa)))
                            && (fecPago == null || documento.getFecPago().equals(fecPago))
                            && (fecEmision == null || documento.getFecEmision().equals(fecEmision))
                            && (fecVencimiento == null || documento.getFecVencimiento().equals(fecVencimiento))
                            && documento.getNumero().startsWith(numero)) {
                    }
                    listadoBusqueda.add(documento);
                    break;
                }
            }
        }
        Collections.sort(listadoBusqueda, new DocumentoSortFecVencimiento());

        return listadoBusqueda;
    }
}
