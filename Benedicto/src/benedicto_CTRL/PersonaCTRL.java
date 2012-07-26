

package benedicto_CTRL;

import benedicto_clases.*;
import java.util.ArrayList;


public class PersonaCTRL {
    private ArrayList<Persona> listapersona = new ArrayList<Persona>();

    public void AgregarPersona(Persona persona) {
       this.listapersona.add(persona);
    }

    public boolean EliminaPersona(String codigo, char tipo) {
       Persona persona;

        for (int i=0;i<listapersona.size();i++){
            persona = listapersona.get(i);

            if (tipo == 'C') {
              if(persona.getCodigo().equals(codigo)){
                  this.listapersona.remove(i);
                  return true;
              }
            }
        }
       return false;
    }
    
    public boolean VolverAProspecto(String codigo, char tipo) {
       Persona persona;

        for (int i=0;i<listapersona.size();i++){
            persona = listapersona.get(i);

            if (tipo == 'C') {
              if(persona.getCodigo().equals(codigo)){
                    //Persona.ActualizaEstado(persona.getTipo_persona());
                  return true;
              }
            }
        }
       return false;
    }

    public ArrayList<Persona> Buscar(String nombres, String ap_paterno, String ap_materno, char tipo) {
        Persona persona;
        ArrayList<Persona> listaencontrada = new ArrayList<Persona>();

        for (int i=0;i<listapersona.size();i++){
            persona = listapersona.get(i);

            if (tipo == 'C') {
              if(persona.getNombres().equals(nombres) || persona.getAp_paterno().equals(ap_paterno) ||
                      persona.getAp_materno().equals(ap_materno)){
                  listaencontrada.add(persona);
              }
            }
        }

       return listaencontrada;
    }

}


