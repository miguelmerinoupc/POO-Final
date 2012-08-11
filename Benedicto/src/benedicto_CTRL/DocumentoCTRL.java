/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package benedicto_CTRL;

import benedicto_clases.Grupo_de_Estudios.GrupoEstudio;
import benedicto_clases.documentos.*;
import benedicto_clases.persona.PersonaJuridica;
import benedicto_clases.persona.PersonaNatural;
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

    public boolean EliminaDocumento(String numero, Tipo_Mov tipo) {
        Documento documento;

        for (int i = 0; i < listadocumento.size(); i++) {
            documento = listadocumento.get(i);

            if (tipo.getTipoMov() == 'V') {
                if (documento.getNumero().equals(numero)) {
                    this.listadocumento.remove(i);
                    return true;
                }
            }

            if (tipo.getTipoMov() == 'C') {
                if (documento.getNumero().equals(numero)) {
                    this.listadocumento.remove(i);
                    return true;
                }
            }

        }
        return false;
    }

    public ArrayList<Documento> BuscarMovimiento(Articulo articulo, GrupoEstudio grupo, String numero,
            DateTime fecEmision, String identificacion, DateTime fecVencimiento, DateTime fecPago, char estado) {
        ArrayList<Documento> listadoBusqueda = new ArrayList<Documento>();

        for (Documento documento : listadocumento) {
            if (documento.getTipoMov().getTipoMov() == 'C') {
                if (documento.getTipodoDoc().getTipoDoc() == 'F'
                        && (numero.isEmpty() || documento.getNumero().equals(numero))
                        && (fecEmision == null || documento.getFecEmision().equals(fecEmision))
                        && (identificacion.isEmpty() || ((PersonaJuridica) documento.getPersona() != null
                        && ((PersonaJuridica) documento.getPersona()).getRuc().startsWith(identificacion)))
                        && (fecVencimiento == null || documento.getFecVencimiento().equals(fecVencimiento))
                        && (fecPago == null || documento.getFecPago().equals(fecPago))
                        && (estado == ' ' || documento.getEstado() == estado)) {
                    listadoBusqueda.add(documento);
                }
            } else {
                if (documento.getTipodoDoc().getTipoDoc() == 'C'
                        && (numero.isEmpty() || documento.getNumero().equals(numero))
                        && (fecEmision == null || documento.getFecEmision().equals(fecEmision))
                        && (identificacion.isEmpty() || ((PersonaNatural) documento.getPersona() != null
                        && ((PersonaNatural) documento.getPersona()).getDni().startsWith(identificacion)))
                        && (fecVencimiento == null || documento.getFecVencimiento().equals(fecVencimiento))
                        && (fecPago == null || documento.getFecPago().equals(fecPago))
                        && (estado == ' ' || documento.getEstado() == estado)) {
                    listadoBusqueda.add(documento);
                }
            }

        }

        Collections.sort(listadoBusqueda, new DocumentoSortFecVencimiento());

        return listadoBusqueda;
    }
}