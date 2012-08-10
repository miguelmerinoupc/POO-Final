package benedicto_CTRL;

import benedicto_clases.persona.PersonaNatural;
import benedicto_clases.persona.Persona;
import benedicto_clases.*;
import java.util.ArrayList;

public class PersonaCTRL {

    private ArrayList<Persona> listapersona = new ArrayList<Persona>();
    private ArrayList<PersonaNatural> listapersonaNatural = new ArrayList<PersonaNatural>();

    public void AgregarPersona(PersonaNatural persona) {
        this.listapersonaNatural.add(persona);
    }

    public boolean EliminaPersona(String codigo, char tipo) {
        PersonaNatural persona;

        for (int i = 0; i < listapersonaNatural.size(); i++) {
            persona = listapersonaNatural.get(i);

            if (tipo == 'C') {
                if (persona.getCodigo().equals(codigo)) {
                    this.listapersonaNatural.remove(i);
                    return true;
                }
            }

            if (tipo == 'P') {
                if (persona.getCodigo().equals(codigo)) {
                    this.listapersonaNatural.remove(i);
                    return true;
                }
            }

        }
        return false;
    }
 //<------FALTA
    public boolean VolverAProspecto(String codigo, char tipo) {
        PersonaNatural persona;

        for (int i = 0; i < listapersonaNatural.size(); i++) {
            persona = listapersonaNatural.get(i);

            if (tipo == 'C') {
                if (persona.getCodigo().equals(codigo)) {
                   
                    //Persona.ActualizaEstado(persona.getTipo_persona());
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<PersonaNatural> Buscar(String nombres, String ap_paterno, String ap_materno, char tipo) {
        PersonaNatural persona;
        ArrayList<PersonaNatural> listaBuscada = new ArrayList<PersonaNatural>();
        
        for (int i = 0; i < listapersonaNatural.size(); i++) {
            persona = listapersonaNatural.get(i);

            if (tipo == 'C') {
                if (persona.getNombre().equals(nombres) || persona.getAp_paterno().equals(ap_paterno)
                        || persona.getAp_materno().equals(ap_materno)) {
                    listaBuscada.add(persona);
                }
            }
            if (tipo == 'P') {
                if (persona.getNombre().equals(nombres) || persona.getAp_paterno().equals(ap_paterno)
                        || persona.getAp_materno().equals(ap_materno)) {
                    listaBuscada.add(persona);
                }
            }
        }

        return listaBuscada;
    }
}

