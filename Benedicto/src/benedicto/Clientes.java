/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package benedicto;
import java.io.*;
/**
 *
 * @author u201216787
 */
public class Clientes {
    private String nombres;
    private String ap_paterno;
    private String ap_materno;
    private String e_mail;

    public Clientes(String nombres, String ap_paterno, String ap_materno, String e_mail) {
        this.nombres = nombres;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.e_mail = e_mail;
    }
//    private String dni;
//    private String telefono;
//    private String celular;

   

    public String getAp_materno() {
        return ap_materno;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getNombres() {
        return nombres;
    }

    public static boolean validasiexiste() throws IOException{
        Clientes cliente = new Clientes("Miguel Angel","Merino","Barreto","miguel.merinob@gmail.com");
//        String valornomb, valorapp, valorapm, valorem;
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Introduzca Nombre: ");
//        System.out.flush();
//        valornomb = in.readLine();
//        System.out.println("Introduzca Apellido Paterno: ");
//        System.out.flush();
//        valorapp = in.readLine();
//        System.out.println("Introduzca Apellido Materno: ");
//        System.out.flush();
//        valorapm = in.readLine();
//        System.out.println("Introduzca e-mail: ");
//        System.out.flush();
//        valorem = in.readLine();
        String valornomb, valorapp, valorapm, valorem;
        valornomb = "Miguel Angel";
        valorapp = "Merino";
        valorapm = "Barreto";
        valorem = "miguel.merinob@gmail.com";
        if (cliente.getNombres() != valornomb){
            System.out.println("El nombre es Falso");
                return false;
        }
        else {
          if (cliente.getAp_paterno() != valorapp){
            System.out.println("El Paterno es Falso");
                return false;
          }
          else{
            if (cliente.getAp_materno() != valorapm){
            System.out.println("El materno es Falso");
                return false;
            }
            else {
              if (cliente.getE_mail() != valorem){
            System.out.println("El email es Falso");
                return false;
              }
              else {
            System.out.println("Es verdadero");
                return true;
              }
            }
          }
          }
        
        }
    }
    

