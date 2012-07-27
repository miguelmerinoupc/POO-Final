/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package benedicto_CTRL;

import benedicto_clases.*;
import java.util.ArrayList;

/**
 *
 * @author u201216787
 */
public class DocumentoCTRL {

    private ArrayList<Documento> listadocumento = new ArrayList<Documento>();


    public void AgregarDocumento(Documento documento) {
       this.listadocumento.add(documento);
    }

    public ArrayList<Documento> Buscar(char tipo,String concepto, String numero, String fecEmision,
                                       String fecVencimiento, String fecPago, char estado) {
        Documento documento = null;
        ArrayList<Documento> listaencontrada = new ArrayList<Documento>();
        
        for (int i=0;i<listadocumento.size();i++){
            documento = listadocumento.get(i);
            
            if (tipo == 'V') {
            
              if(documento.getConcepto().equals(concepto) || documento.getNumero().equals(numero) ||
                      documento.getFecEmision().equals(fecEmision) ||
                      documento.getFecPago().equals(fecPago) || documento.getEstado() != ' '){
            
                  listaencontrada.add(documento);
                  
              }
            }
            if (tipo == 'C') {
              if(documento.getConcepto().equals(concepto) || documento.getNumero().equals(numero) ||
                      documento.getFecEmision().equals(fecEmision) ||
                      documento.getFecPago().equals(fecPago) || documento.getEstado() != ' '){
                  listaencontrada.add(documento);
              }
            }
        }
       
       return listaencontrada;
    }

    public boolean EliminaDocumento(String numero, char tipo) {
       Documento documento;

        for (int i=0;i<listadocumento.size();i++){
            documento = listadocumento.get(i);

            if (tipo == 'V') {
              if(documento.getNumero().equals(numero)){
                  this.listadocumento.remove(i);
                  return true;
              }
            }

            if (tipo == 'C') {
              if(documento.getNumero().equals(numero)){
                  this.listadocumento.remove(i);
                  return true;
              }
              }

        }
       return false;
    }


}
