package PruebasBenedicto;

import benedicto_clases.Grupo_de_Estudios.GrupoEstudio;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 *
 * @author u201216787
 */
public class GrupoEstudioTest {

    @Test
    public void VerificarExistenciadeObjeto() {
        GrupoEstudio grupo = new GrupoEstudio();
        Assert.assertNotNull(grupo); //Verifica si objeto no es nulo
    }

    @Test
    public void VerificarDatosObligatorios() {
        String nombre = "POO";
        DateTime fecInicio = new DateTime(2012, 1, 15, 0, 0);
        DateTime fecFin = new DateTime(2012, 1, 30, 0, 0);

        GrupoEstudio grupo = new GrupoEstudio(nombre, fecInicio, fecFin);

        Assert.assertEquals(true, grupo.VerificarObligatorios());
    }
}
