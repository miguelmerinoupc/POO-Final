
package PruebasBenedicto;

import benedicto_CTRL.*;
import benedicto_clases.*;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Test;


public class ProspectosTest {

    @Test
    public void VerificarExistenciadeObjeto() {
        Persona persona = new Persona();
        Assert.assertNotNull(persona); //Verifica si objeto no es nulo
    }

    @Test
    public void VerificarTipoPersona() {
        TipoPersona tipoper = new TipoPersona('C');
        Assert.assertNotNull(tipoper);
        PersonaNatural persona = new PersonaNatural("Franklin", "Velita", "Zorrilla", "15474748", tipoper.getTipo_persona(), "01");
        Assert.assertEquals(true, tipoper.VerificarTipo(persona));

    }


    @Test
    public void VerificarDatosObligatorios() {
        PersonaNatural persona = new PersonaNatural("Franklin", "Velita", "Zorrilla", "15474748","01");
        PersonaNatural persona1 = new PersonaNatural();


        Assert.assertEquals(true, persona.VerificarObligatorios());
        //Assert.assertEquals(true, persona1.VerificarQueOblitarios());
    }

    @Test
    public void BuscarProspecto(){
        TipoPersona tipoper = new TipoPersona('P');
        PersonaNatural persona = new PersonaNatural("Franklin", "Velita", "Zorrilla", "15474748", tipoper.getTipo_persona(), "01");
        PersonaNatural persona1 = new PersonaNatural("Luis", "Valle", "Zevallos", "15474732", tipoper.getTipo_persona(),"02");
        PersonaNatural persona2 = new PersonaNatural("Luis", "Vargas", "Sanchez", "9999999999", tipoper.getTipo_persona(),"03");
        PersonaNatural persona3 = new PersonaNatural("David", "Sanchez", "Salazar", "10258360996", tipoper.getTipo_persona(),"04");
        
        PersonaCTRL personaCTRL = new PersonaCTRL();
        personaCTRL.AgregarPersona(persona);
        personaCTRL.AgregarPersona(persona1);
        personaCTRL.AgregarPersona(persona2);
        personaCTRL.AgregarPersona(persona3);

        int cantidadencontrada;
        ArrayList<PersonaNatural> listaencontrada = personaCTRL.Buscar("Franklin", "", "", 'P');

        cantidadencontrada = listaencontrada.size();

        Assert.assertEquals(true,cantidadencontrada>0);


        System.out.println("Encontrados ....:" + cantidadencontrada);


         PersonaNatural personas;

        for (int i=0;i<listaencontrada.size();i++){
            personas = listaencontrada.get(i);
            System.out.println("Prospecto : "+personas.getNombre() + " " + personas.getAp_paterno() + " " +  personas.getAp_materno());

        }
    }

    @Test
    public void EliminaProspecto(){
        TipoPersona tipoper = new TipoPersona('P');
        PersonaNatural persona = new PersonaNatural("Franklin", "Velita", "Zorrilla", "15474748", tipoper.getTipo_persona(), "01");
        PersonaNatural persona1 = new PersonaNatural("Luis", "Valle", "Zevallos", "15474732", tipoper.getTipo_persona(),"02");
        PersonaNatural persona2 = new PersonaNatural("Luis", "Vargas", "Sanchez", "9999999999", tipoper.getTipo_persona(),"03");
        PersonaNatural persona3 = new PersonaNatural("David", "Sanchez", "Salazar", "10258360996", tipoper.getTipo_persona(),"04");
        
        PersonaCTRL personaCTRL = new PersonaCTRL();
        personaCTRL.AgregarPersona(persona);
        personaCTRL.AgregarPersona(persona1);
        personaCTRL.AgregarPersona(persona2);
        personaCTRL.AgregarPersona(persona3);

        Assert.assertEquals(true, personaCTRL.EliminaPersona("03", 'P'));

    }
    

}