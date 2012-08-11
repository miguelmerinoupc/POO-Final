package PruebasBenedicto;

import benedicto_CTRL.AdmUsuarioCTRL;
import benedicto_CTRL.HistoriaCTRL;
import benedicto_clases.AdministracionUsuarios.AdmUsuario;
import benedicto_clases.AdministracionUsuarios.Historia;
import java.util.ArrayList;
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
        Assert.assertEquals(true, usuario1.VerificarObligatorios());
    }

    @Test
    public void ValidarExistenciaDeUsuario() {
        AdmUsuario usuario1 = new AdmUsuario("bvelita");
        AdmUsuario usuario2 = new AdmUsuario("mmerino");
        AdmUsuario usuario3 = new AdmUsuario("jmartinez");
        AdmUsuarioCTRL usuarioCTRL = new AdmUsuarioCTRL();
        usuarioCTRL.AgregarUsuario(usuario1);
        usuarioCTRL.AgregarUsuario(usuario2);
        usuarioCTRL.AgregarUsuario(usuario3);

        int cantidadencontrada;
        ArrayList<AdmUsuario> listaencontrada = usuarioCTRL.BuscarUsuario("jmorales");

        cantidadencontrada = listaencontrada.size();

        Assert.assertEquals(false, cantidadencontrada > 0);
        if (cantidadencontrada == 0) {
            System.out.println("Usuario valido y disponible....");
        }
    }

    @Test
    public void ValidarEliminarUsuario() {
        AdmUsuario usuario1 = new AdmUsuario("bvelita");
        AdmUsuario usuario2 = new AdmUsuario("mmerino");
        AdmUsuario usuario3 = new AdmUsuario("jmartinez");
        AdmUsuarioCTRL usuarioCTRL = new AdmUsuarioCTRL();
        usuarioCTRL.AgregarUsuario(usuario1);
        usuarioCTRL.AgregarUsuario(usuario2);
        usuarioCTRL.AgregarUsuario(usuario3);
        // Agregando Historias
        Historia historia1 = new Historia("mmerino", "Ventas", "Editar", DateTime.now());
        Historia historia2 = new Historia("fvelita", "Compras", "Adiciona", DateTime.now());
        Historia historia3 = new Historia("dsanchez", "Ventas", "Editar", DateTime.now());
        HistoriaCTRL historiaCTRL = new HistoriaCTRL();
        historiaCTRL.AgregarHistoria(historia1);
        historiaCTRL.AgregarHistoria(historia2);
        historiaCTRL.AgregarHistoria(historia3);

        int cantidadencontrada;
        ArrayList<Historia> listaencontrada = historiaCTRL.BuscarHistoria("mmerino");
        cantidadencontrada = listaencontrada.size();
        if (cantidadencontrada > 0) {
            Assert.assertEquals(true, usuarioCTRL.EliminaUsuario("mmerino"));
        }
    }
}
