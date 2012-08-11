package PruebasBenedicto;

import benedicto_CTRL.AdmUsuarioCTRL;
import benedicto_clases.AdministracionUsuarios.Acceso;
import benedicto_clases.AdministracionUsuarios.AdmUsuario;
import junit.framework.Assert;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author Miguel Merino
 */
public class AccesoTest {

    @Test
    public void VerificarExistenciadeObjeto() {
        Acceso acceso = new Acceso();
        Assert.assertNotNull(acceso); //Verifica si objeto no es nulo
    }

    @Test
    public void VerificarIngresoDeDatos() throws Exception {

        AdmUsuario usuario1 = new AdmUsuario("25836099", "Miguel Angel", "Merino", "Barreto",
                "mmerino", "ma_merinob@hotmail.com", new DateTime(2012, 2, 15, 0, 0),
                "Administrador", "123456");
        AdmUsuario usuario2 = new AdmUsuario("14253628", "Benjamin Franklin", "Velita", "Zorrilla",
                "bvelita", "bvelita@gmail.com", new DateTime(2012, 3, 1, 0, 0),
                "Vendedor", "666666");
        AdmUsuario usuario3 = new AdmUsuario("28654585", "David", "Sanchez", "Salazar",
                "dsanchez", "dsanchez@hotmail.com", new DateTime(2010, 3, 10, 0, 0),
                "Contador", "777777");

        AdmUsuarioCTRL usuarioCTRL = new AdmUsuarioCTRL();
        usuarioCTRL.AgregarUsuario(usuario1);
        usuarioCTRL.AgregarUsuario(usuario2);
        usuarioCTRL.AgregarUsuario(usuario3);


        Acceso acceso = new Acceso("mmerino", "123456");
        Assert.assertEquals(true, acceso.VerificaAcceso());

    }
}
