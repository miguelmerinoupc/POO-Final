/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PruebasBenedicto;

import benedicto_CTRL.*;
import benedicto_clases.*;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author u201216787
 */
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
        Persona persona = new Persona("Miguel Angel","Merino","Barreto","10258360996","xxxx@xxx.com",tipoper.getTipo_persona());
        Assert.assertEquals(true, tipoper.VerificarTipo(persona));

    }


    @Test
    public void VerificarDatosObligatorios() {
        Persona persona = new Persona("Miguel Angel","Merino","Barreto","10258360996","xxxx@xxx.com");
        Persona persona1 = new Persona();


        Assert.assertEquals(true, persona.VerificarOblitarios());
        //Assert.assertEquals(true, persona1.VerificarQueOblitarios());
    }

    @Test
    public void BuscarProspecto(){
        TipoPersona tipoper = new TipoPersona('P');
        Persona persona = new Persona("Miguel Angel","Merino","Barreto","10258360996","xxxx@xxx.com",tipoper.getTipo_persona());
        Persona persona1 = new Persona("David","Valle","Zevallos","00000000001","zzzz@zzz.com",tipoper.getTipo_persona());
        Persona persona2 = new Persona("Luis","Vargas","Sanchez","9999999999","aaaa@aaaaa.com",tipoper.getTipo_persona());
        Persona persona3 = new Persona("David","Sanchez","Salazar","10258360996","xxxx@xxx.com",tipoper.getTipo_persona());

        PersonaCTRL personaCTRL = new PersonaCTRL();
        personaCTRL.AgregarPersona(persona);
        personaCTRL.AgregarPersona(persona1);
        personaCTRL.AgregarPersona(persona2);
        personaCTRL.AgregarPersona(persona3);

        int cantidadencontrada;
        ArrayList<Persona> listaencontrada = personaCTRL.Buscar("David", "", "", 'P');

        cantidadencontrada = listaencontrada.size();

        Assert.assertEquals(true,cantidadencontrada>0);


        System.out.println("Encontrados ....:" + cantidadencontrada);


         Persona personas;

        for (int i=0;i<listaencontrada.size();i++){
            personas = listaencontrada.get(i);
            System.out.println("Prospecto : "+personas.getNombres() + " " + personas.getAp_paterno() + " " +  personas.getAp_materno());

        }
    }

    @Test
    public void EliminaProspecto(){
        TipoPersona tipoper = new TipoPersona('P');
        Persona persona = new Persona("MAMB001","Miguel Angel","Merino","Barreto","10258360996","xxxx@xxx.com",tipoper.getTipo_persona());
        Persona persona1 = new Persona("LVZ001","Luis","Valle","Zevallos","00000000001","zzzz@zzz.com",tipoper.getTipo_persona());
        Persona persona2 = new Persona("LVS002","Luis","Vargas","Sanchez","9999999999","aaaa@aaaaa.com",tipoper.getTipo_persona());
        Persona persona3 = new Persona("DSS001","David","Sanchez","Salazar","10258360996","xxxx@xxx.com",tipoper.getTipo_persona());

        PersonaCTRL personaCTRL = new PersonaCTRL();
        personaCTRL.AgregarPersona(persona);
        personaCTRL.AgregarPersona(persona1);
        personaCTRL.AgregarPersona(persona2);
        personaCTRL.AgregarPersona(persona3);

        Assert.assertEquals(true, personaCTRL.EliminaPersona("LVZ001", 'P'));

    }
    

}