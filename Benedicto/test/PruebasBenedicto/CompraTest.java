/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PruebasBenedicto;

import benedicto_CTRL.DocumentoCTRL;
import benedicto_clases.documentos.*;
import benedicto_clases.persona.PersonaJuridica;
import java.util.ArrayList;
import java.util.Date;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 *
 * @author FRANKLIN
 */
public class CompraTest {

    @Test
    public void VerificarExistenciadeObjeto() {
        Documento documento = new Documento();
        Assert.assertNotNull(documento); //Verifica si objeto no es nulo
    }

    @Test
    public void VerificarTipoMovimiento() {
        Tipo_Mov tipomov = new Tipo_Mov('C');
        Assert.assertNotNull(tipomov);
        Documento documento = new Documento(tipomov);
        Assert.assertEquals(true, tipomov.VerificarTipo(documento));
        java.util.Date fecha = new Date();
    }

    @Test
    public void VerificarDatosObligatorios() {
        Tipo_Mov tipomov = new Tipo_Mov('C');
        Tipo_Doc tipodoc = new Tipo_Doc('F');
        double subTotal = 100.00;
        double igv = 100.00;
        double total = 100.00;
        Documento documento = new Documento(tipomov, tipodoc, "001", new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 12, 31, 0, 0), subTotal, igv, total, 'S', '0');
        Assert.assertEquals(true, documento.VerificarOblitarios());
    }

    @Test
    public void AgregarDocumento() {
        Tipo_Mov tipomov = new Tipo_Mov('C');
        Tipo_Doc tipodoc = new Tipo_Doc('F');
        double subTotal = 100.00;
        double igv = 100.00;
        double total = 100.00;
        Documento documento = new Documento(tipomov, tipodoc, "001", new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 12, 31, 0, 0), subTotal, igv, total, 'S', '0');
        Assert.assertEquals(true, documento.VerificarOblitarios());
        DocumentoCTRL nuevoDocumento = new DocumentoCTRL();
        nuevoDocumento.AgregarDocumento(documento);
        Assert.assertNotNull(nuevoDocumento);
    }

    @Test
    public void BuscarCompra() {
        Tipo_Mov tipomov = new Tipo_Mov('C');
        Tipo_Doc tipodoc = new Tipo_Doc('F');

        PersonaJuridica persona1 = new PersonaJuridica("Empresa Demo", "20141451241");
        PersonaJuridica persona2 = new PersonaJuridica("Empresa Prueba", "22141451241");

        Documento documento1 = new Documento(tipomov, tipodoc, "FC/001-00000211", new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 5, 20, 0, 0), new DateTime(2012, 12, 31, 0, 0), 110.22, 15.22, 225.22, persona1, 'N');
        Documento documento2 = new Documento(tipomov, tipodoc, "FC/002-00000011", new DateTime(2012, 5, 17, 0, 0), new DateTime(2012, 5, 21, 0, 0), new DateTime(2012, 12, 31, 0, 0), 40.22, 17.22, 15.22, persona1, 'N');
        Documento documento3 = new Documento(tipomov, tipodoc, "FC/003-00000551", new DateTime(2012, 5, 18, 0, 0), new DateTime(2012, 5, 22, 0, 0), new DateTime(2012, 12, 31, 0, 0), 22, 33, 11, persona2, 'N');
        Documento documento4 = new Documento(tipomov, tipodoc, "FC/004-00002441", new DateTime(2012, 5, 19, 0, 0), new DateTime(2012, 5, 23, 0, 0), new DateTime(2012, 12, 31, 0, 0), 43, 34, 55, persona1, 'N');

        DocumentoCTRL documentoCTRL = new DocumentoCTRL();
        documentoCTRL.AgregarDocumento(documento1);
        documentoCTRL.AgregarDocumento(documento2);
        documentoCTRL.AgregarDocumento(documento3);
        documentoCTRL.AgregarDocumento(documento4);

        Articulo articulo1 = new Articulo("A1", "Lapicero");
        Articulo articulo2 = new Articulo("A2", "Cuaderno");
        Articulo articulo3 = new Articulo("A3", "Regla");
        Articulo articulo4 = new Articulo("A4", "Book");

        DetalleDocumento detalleDoc1 = new DetalleDocumento(articulo1, 12, 12.3);
        DetalleDocumento detalleDoc2 = new DetalleDocumento(articulo2, 5, 5.5);
        DetalleDocumento detalleDoc3 = new DetalleDocumento(articulo3, 1, 4.4);
        DetalleDocumento detalleDoc4 = new DetalleDocumento(articulo4, 2, 3.2);

        documento2.getDetalle().add(detalleDoc1);
        documento1.getDetalle().add(detalleDoc2);
        documento2.getDetalle().add(detalleDoc3);
        documento3.getDetalle().add(detalleDoc4);

        int cantidadencontrada;

        ArrayList<Documento> listaencontrada = documentoCTRL.BuscarMovimiento(articulo1, null, "FC/002-00000011", new DateTime(2012, 5, 17, 0, 0), persona1.getRuc(), new DateTime(2012, 5, 21, 0, 0), new DateTime(2012, 12, 31, 0, 0), 'N');

        cantidadencontrada = listaencontrada.size();;

        Assert.assertEquals(true, cantidadencontrada > 0);

        System.out.println("Encontrados ....:" + cantidadencontrada);

        Documento documentos;
        ArrayList<DetalleDocumento> detalleDocumento;

        documentoCTRL.ListarResultado(listaencontrada);
    }

    @Test
    public void EliminarCompra() {
        Tipo_Mov tipomov = new Tipo_Mov('C');
        Tipo_Doc tipodoc = new Tipo_Doc('F');

        PersonaJuridica persona1 = new PersonaJuridica("Empresa Demo", "20141451241");
        PersonaJuridica persona2 = new PersonaJuridica("Empresa Prueba", "22141451241");

        Documento documento1 = new Documento(tipomov, tipodoc, "FC/001-00000211", new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 5, 20, 0, 0), new DateTime(2012, 12, 31, 0, 0), 110.22, 15.22, 225.22, persona1, 'N');
        Documento documento2 = new Documento(tipomov, tipodoc, "FC/002-00000011", new DateTime(2012, 5, 17, 0, 0), new DateTime(2012, 5, 21, 0, 0), new DateTime(2012, 12, 31, 0, 0), 40.22, 17.22, 15.22, persona1, 'N');
        Documento documento3 = new Documento(tipomov, tipodoc, "FC/003-00000551", new DateTime(2012, 5, 18, 0, 0), new DateTime(2012, 5, 22, 0, 0), new DateTime(2012, 12, 31, 0, 0), 22, 33, 11, persona2, 'N');
        Documento documento4 = new Documento(tipomov, tipodoc, "FC/004-00002441", new DateTime(2012, 5, 19, 0, 0), new DateTime(2012, 5, 23, 0, 0), new DateTime(2012, 12, 31, 0, 0), 43, 34, 55, persona1, 'N');

        DocumentoCTRL documentoCTRL = new DocumentoCTRL();
        documentoCTRL.AgregarDocumento(documento1);
        documentoCTRL.AgregarDocumento(documento2);
        documentoCTRL.AgregarDocumento(documento3);
        documentoCTRL.AgregarDocumento(documento4);

        Assert.assertEquals(true, documentoCTRL.EliminaDocumento("FC/002-00000011", tipomov));
    }
}
