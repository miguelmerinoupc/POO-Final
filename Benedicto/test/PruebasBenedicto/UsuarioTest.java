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
        DateTime fechaingreso = new DateTime();
        fechaingreso = DateTime.now();
        String cargo = "Administrador";
        String clave = "";

        AdmUsuario usuario1 = new AdmUsuario(dni, nombre, ap_Paterno, ap_Materno, usuario, email, fechaingreso, cargo, clave);
        Assert.assertEquals(true, AdmUsuario.VerificarObligatorios());
    }
}
