package benedicto_CTRL;

import benedicto_clases.persona.PersonaNatural;
import benedicto_clases.persona.Persona;
import benedicto_clases.*;
import benedicto_clases.persona.TipoPersona;
import benedicto_interfaces.IBenedicto;
import java.util.ArrayList;

public class PersonaCTRL implements IBenedicto<PersonaNatural> {

    public void ListarResultado(ArrayList<PersonaNatural> listado) {
        for (PersonaNatural persona : listado) {
            if (persona.getTipo_persona().getTipo_persona() == 'C') {
                System.out.println("\tNombre: " + persona.getNombre());
                System.out.println("\tApellido Paterno: " + persona.getAp_paterno());
                System.out.println("\tApellido Materno: " + persona.getAp_materno());
                System.out.println("\tDni: " + persona.getDni());
                System.out.println("-\n");
            } else {
                System.out.println("\tNombre: " + persona.getNombre());
                System.out.println("\tApellido Paterno: " + persona.getAp_paterno());
                System.out.println("\tApellido Materno: " + persona.getAp_materno());
                System.out.println("\tDni: " + persona.getDni());
                System.out.println("-\n");
            }

        }
    }
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

    public boolean VolverAProspecto(String codigo, char tipo) {
        PersonaNatural persona;

        for (int i = 0; i < listapersonaNatural.size(); i++) {
            persona = listapersonaNatural.get(i);

            if (tipo == 'C') {
                if (persona.getCodigo().equals(codigo)) {
                    persona.getTipo_persona().setTipo_persona('P');
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
