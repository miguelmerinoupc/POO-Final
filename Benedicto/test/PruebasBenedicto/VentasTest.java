// autor : Luis Valle
package PruebasBenedicto;

import benedicto_clases.documentos.Documento;
import benedicto_clases.documentos.Tipo_Mov;
import benedicto_CTRL.*;
import benedicto_clases.*;
import benedicto_clases.Grupo_de_Estudios.GrupoEstudio;
import benedicto_clases.documentos.DetalleDocumento;
import benedicto_clases.documentos.Tipo_Doc;
import benedicto_clases.persona.PersonaJuridica;
import benedicto_clases.persona.PersonaNatural;
import java.util.ArrayList;
import java.util.Date;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;

public class VentasTest {

    @Test
    public void VerificarExistenciadeObjeto() {
        Documento documento = new Documento();
        Assert.assertNotNull(documento); //Verifica si objeto no es nulo
    }

    @Test
    public void VerificarTipoMovimiento() {
        Tipo_Mov tipomov = new Tipo_Mov('V');
        Assert.assertNotNull(tipomov);
        Documento documento = new Documento(tipomov);
        Assert.assertEquals(true, tipomov.VerificarTipo(documento));

        java.util.Date fecha = new Date();

    }

    @Test
    public void VerificarDatosObligatorios() {
        Tipo_Mov tipomov = new Tipo_Mov('V');
        Tipo_Doc tipodoc = new Tipo_Doc('C');

        PersonaNatural persona1 = new PersonaNatural("Pepe", "Quechua", "Tumay", "14222212", "001");
        PersonaNatural persona2 = new PersonaNatural("Pepa", "Valdezari", "Latuya", "13322212", "002");

        Documento documento1 = new Documento(tipomov, tipodoc, "001", new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 5, 20, 0, 0), new DateTime(2012, 12, 31, 0, 0), 110.22, 15.22, 225.22, persona1, 'N');

        Assert.assertEquals(true, documento1.VerificarOblitarios());
    }

    @Test
    public void BuscarVenta() {
        Tipo_Mov tipomov = new Tipo_Mov('V');
        Tipo_Doc tipodoc = new Tipo_Doc('C');

        PersonaNatural persona1 = new PersonaNatural("Pepe", "Quechua", "Tumay", "14222212", "001");
        PersonaNatural persona2 = new PersonaNatural("Pepa", "Valdezari", "Latuya", "13322212", "002");

        Documento documento1 = new Documento(tipomov, tipodoc, "001", new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 5, 20, 0, 0), new DateTime(2012, 12, 31, 0, 0), 110.22, 15.22, 225.22, persona1, 'N');
        Documento documento2 = new Documento(tipomov, tipodoc, "002", new DateTime(2012, 5, 17, 0, 0), new DateTime(2012, 5, 21, 0, 0), new DateTime(2012, 12, 31, 0, 0), 40.22, 17.22, 15.22, persona1, 'N');
        Documento documento3 = new Documento(tipomov, tipodoc, "003", new DateTime(2012, 5, 18, 0, 0), new DateTime(2012, 5, 22, 0, 0), new DateTime(2012, 12, 31, 0, 0), 22, 33, 11, persona2, 'N');

        DocumentoCTRL documentoCTRL = new DocumentoCTRL();
        documentoCTRL.AgregarDocumento(documento1);
        documentoCTRL.AgregarDocumento(documento2);
        documentoCTRL.AgregarDocumento(documento3);


        GrupoEstudio grupo1 = new GrupoEstudio("Ing. Sistemas", new DateTime(2012, 5, 17, 0, 0), new DateTime(2012, 5, 21, 0, 0));
        GrupoEstudio grupo2 = new GrupoEstudio("Arquitectura", new DateTime(2012, 5, 17, 0, 0), new DateTime(2012, 5, 21, 0, 0));
        GrupoEstudio grupo3 = new GrupoEstudio("Derecho", new DateTime(2012, 5, 17, 0, 0), new DateTime(2012, 5, 21, 0, 0));

        DetalleDocumento detalleDoc1 = new DetalleDocumento(grupo1, 12, 15.44);
        DetalleDocumento detalleDoc2 = new DetalleDocumento(grupo2, 5, 5.5);
        DetalleDocumento detalleDoc3 = new DetalleDocumento(grupo3, 1, 4.4);

        documento1.getDetalle().add(detalleDoc2);
        documento2.getDetalle().add(detalleDoc3);

        int cantidadencontrada;
        ArrayList<Documento> listaencontrada = documentoCTRL.BuscarMovimiento(null, grupo2, "002", new DateTime(2012, 5, 17, 0, 0), persona1.getDni(), new DateTime(2012, 5, 21, 0, 0), new DateTime(2012, 12, 31, 0, 0), 'N');

        cantidadencontrada = listaencontrada.size();
        System.out.println(listaencontrada.size());

        Assert.assertEquals(true, cantidadencontrada > 0);

        Documento documentos;
        ArrayList<DetalleDocumento> detalleDocumento;

        System.out.println("Encontrados ....:" + cantidadencontrada);

        for (int i = 0; i < listaencontrada.size(); i++) {
            documentos = listaencontrada.get(i);
            detalleDocumento = documentos.getDetalle();
            for (DetalleDocumento detalle : detalleDocumento) {
                System.out.println("Documento : " + detalle.getGrupoEstudio().getNombre()
                        + "\tNumero : " + documentos.getNumero()
                        + "\tFecha Emision : " + documentos.getFecEmision()
                        + "\tFecha Vencimiento : " + documentos.getFecVencimiento()
                        + "\tFecha Pago : " + documentos.getFecPago()
                        + "\tEstado : " + documentos.getEstado());
            }
        }
    }

    @Test
    public void EliminarVenta() {
        Tipo_Mov tipomov = new Tipo_Mov('V');
        Tipo_Doc tipodoc = new Tipo_Doc('C');

        PersonaNatural persona1 = new PersonaNatural("Pepe", "Quechua", "Tumay", "14222212", "001");
        PersonaNatural persona2 = new PersonaNatural("Pepa", "Valdezari", "Latuya", "13322212", "002");

        Documento documento1 = new Documento(tipomov, tipodoc, "001", new DateTime(2012, 5, 16, 0, 0), new DateTime(2012, 5, 20, 0, 0), new DateTime(2012, 12, 31, 0, 0), 110.22, 15.22, 225.22, persona1, 'N');
        Documento documento2 = new Documento(tipomov, tipodoc, "002", new DateTime(2012, 5, 17, 0, 0), new DateTime(2012, 5, 21, 0, 0), new DateTime(2012, 12, 31, 0, 0), 40.22, 17.22, 15.22, persona1, 'N');
        Documento documento3 = new Documento(tipomov, tipodoc, "003", new DateTime(2012, 5, 18, 0, 0), new DateTime(2012, 5, 22, 0, 0), new DateTime(2012, 12, 31, 0, 0), 22, 33, 11, persona2, 'N');

        DocumentoCTRL documentoCTRL = new DocumentoCTRL();
        documentoCTRL.AgregarDocumento(documento1);
        documentoCTRL.AgregarDocumento(documento2);
        documentoCTRL.AgregarDocumento(documento3);

        Assert.assertEquals(true, documentoCTRL.EliminaDocumento("002", tipomov));
    }
}