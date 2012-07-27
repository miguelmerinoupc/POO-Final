
// autor : Luis Valle
package PruebasBenedicto;

import benedicto_CTRL.*;
import benedicto_clases.*;
import java.util.ArrayList;
import java.util.Date;
import junit.framework.Assert;
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
        Documento documento = new Documento(tipomov.getTipoMov());
        Assert.assertEquals(true, tipomov.VerificarTipo(documento));

        java.util.Date fecha = new Date();

    }


    @Test
    public void VerificarDatosObligatorios() {
        Tipo_Mov tipomov = new Tipo_Mov('V');
        Documento documento = new Documento(tipomov.getTipoMov(),"Ofimatica","26-07-2012","26-07-2012",100.00,18.00,118.00,'S');
        //Documento documento1 = new Documento();


        Assert.assertEquals(true, documento.VerificarOblitarios());
        //Assert.assertEquals(true, persona1.VerificarQueOblitarios());
    }

    @Test
    public void BuscarVenta(){
        Tipo_Mov tipomov = new Tipo_Mov('C');
        Documento documento = new Documento(tipomov.getTipoMov(),"Ofimatica","26-07-2012","26-08-2012","25-08-2012",'C');
        Documento documento1 = new Documento(tipomov.getTipoMov(),"Redes","01-07-2012","01-08-2012","",'N');
        Documento documento2 = new Documento(tipomov.getTipoMov(),"Programacion","26-07-2012","15-08-2012","",'C');
        Documento documento3 = new Documento(tipomov.getTipoMov(),"Ofimatica","26-07-2012","26-08-2012",220.00,39.60,259.60,'S');

        DocumentoCTRL documentoCTRL = new DocumentoCTRL();
        documentoCTRL.AgregarDocumento(documento);
        documentoCTRL.AgregarDocumento(documento1);
        documentoCTRL.AgregarDocumento(documento2);
        documentoCTRL.AgregarDocumento(documento3);

        int cantidadencontrada;
        ArrayList<Documento> listaencontrada = documentoCTRL.Buscar('V',"Ofimatica", "", "","","", ' ');

        cantidadencontrada = listaencontrada.size();
        System.out.println(listaencontrada.size());

        Assert.assertEquals(true,cantidadencontrada>0);


        System.out.println("Encontrados ....:" + cantidadencontrada);


         Documento documentos;

        for (int i=0;i<listaencontrada.size();i++){
            documentos = listaencontrada.get(i);
            System.out.println("Documento : "+documentos.getConcepto() + " numero : " + documentos.getNumero() +
                              " fecha Emision : " +  documentos.getFecEmision() +
                              " fecha Vencimiento : " + documentos.getFecVencimiento() +
                              " fecha Pago : " + documentos.getFecPago() +
                              " Estado : " + documentos.getEstado());

        }
    }

    @Test
    public void EliminaVenta(){
        Tipo_Mov tipomov = new Tipo_Mov('C');
        Documento documento = new Documento(tipomov.getTipoMov(),"Ofimatica","26-07-2012","26-08-2012","25-08-2012",'C',"FC001001645");
        Documento documento1 = new Documento(tipomov.getTipoMov(),"Redes","01-07-2012","01-08-2012","",'N',"FC001001655");
        Documento documento2 = new Documento(tipomov.getTipoMov(),"Programacion","26-07-2012","15-08-2012","",'C',"FC001001674");
        Documento documento3 = new Documento(tipomov.getTipoMov(),"Ofimatica","26-07-2012","26-08-2012","",'A',"FC001001695");

        DocumentoCTRL documentoCTRL = new DocumentoCTRL();
        documentoCTRL.AgregarDocumento(documento);
        documentoCTRL.AgregarDocumento(documento1);
        documentoCTRL.AgregarDocumento(documento2);
        documentoCTRL.AgregarDocumento(documento3);

        Assert.assertEquals(true, documentoCTRL.EliminaDocumento("FC001001655", 'V'));

    }

   

}