
package PruebasBenedicto;

import benedicto.Ventas;
import junit.framework.Assert;
import org.junit.Test;

public class VentasTest {
    
    public VentasTest() {
    }

    @Test
    public void IngresarAltasDeVentas(){
        Ventas ventas = new Ventas("Rimac S.A.","Literatura","u2015","15/07/2012");
        Assert.assertNotNull(ventas.getEmpresa());        
        Assert.assertNotNull(ventas.getConcepto());        
        Assert.assertNotNull(ventas.getNumero());
        Assert.assertNotNull(ventas.getFecha());      
            }
    @Test
    public void IngresarEmpresaErrada(){
        
    
    }
}
