/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package PruebasBenedicto;

import benedicto.Clientes;
import junit.framework.Assert;
import org.junit.Test;
import java.io.*;


/**
 *
 * @author u201216787 Miguel Merino B.
 */
public class AltaClientesTest {

    public AltaClientesTest() {

    }

    @Test
    public void VerificarCamposObligatorios(){
        Clientes cliente = new Clientes("Miguel Angel","Merino","Barreto","miguel.merinob@gmai.com");
        Assert.assertNotNull(cliente.getNombres());
        Assert.assertNotNull(cliente.getAp_paterno());
        Assert.assertNotNull(cliente.getAp_materno());
        Assert.assertNotNull(cliente.getE_mail());
    }

    @Test
    public void VerificarExistenciaDeCliente() throws IOException{
        Clientes cliente = new Clientes("Miguel Angel","Merino","Barreto","miguel.merinob@gmai.com");
//        Clientes[] cliente;
//        cliente = new Clientes[3];
//        cliente[0] = new Clientes("Miguel Angel","Merino","Barreto","miguel.merinob@gmail.com");
//        cliente[1] = new Clientes("Jorge Manuel","Perez","Tello","jperez@gmail.com");
//        cliente[2] = new Clientes("Marcela Joaquina","Torres","Acevedo","mtorresa@gmail.com");

        Assert.assertEquals(true,Clientes.validasiexiste());
    }

}