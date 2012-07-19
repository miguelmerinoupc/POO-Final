/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package benedicto;

/**
 *
 * @author Luis
 */
//publi class Ventas {
    public class Ventas {
      private String Empresa;
      private String Concepto;
      private String Numero;
      private String Fecha;
    
    public Ventas(String Empresa,String Concepto, String Numero, String Fecha) {
        this.Empresa = Empresa;
        this.Concepto = Concepto;
        this.Numero = Numero;
        this.Fecha = Fecha;     
      }

        public String getConcepto() {
            return Concepto;
        }

        public String getEmpresa() {
            return Empresa;
        }

        public String getFecha() {
            return Fecha;
        }

        public String getNumero() {
            return Numero;
        }
        
       
        }
