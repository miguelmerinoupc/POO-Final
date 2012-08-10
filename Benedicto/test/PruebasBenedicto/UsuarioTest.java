package PruebasBenedicto;

import benedicto_clases.*;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author Miguel Merino
 */
public class UsuarioTest {

    @Test
    public void VerificarExistenciadeObjeto() {
        AdmUsuario usuario = new AdmUsuario();
        Assert.assertNotNull(usuario); //Verifica si objeto no es nulo
    }

    @Test
    public void VerificarDatosObligatorios() {
        String dni = "25836099";
        String nombre = "Miguel Angel";
        String ap_Paterno = "Merino";
        String ap_Materno = "";
        String usuario = "mmerino";
        String email = "";
        DateTime fecingreso = DateTime.now();
    }
}
