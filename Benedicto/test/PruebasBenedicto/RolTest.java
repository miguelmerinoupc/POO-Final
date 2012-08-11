package PruebasBenedicto;

import benedicto_clases.AdministracionUsuarios.*;
import benedicto_clases.AdministracionUsuarios.Permiso;
import java.util.ArrayList;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Miguel Merino
 */
public class RolTest {

    @Test
    public void VerificarExistenciadeObjeto() {
        Rol rol = new Rol();
        Assert.assertNotNull(rol); //Verifica si objeto no es nulo
    }

    @Test
    public void VerificarDatosObligatorios() {

        Rol rol = new Rol("Ventas", "Registro de Ventas");

        Permiso permiso1 = new Permiso("Movimientos", 'S', 'S', 'S', 'N');
        Permiso permiso2 = new Permiso("Contabilidad", 'S', 'S', 'S', 'S');
        rol.AgregarPermiso(permiso1);
        rol.AgregarPermiso(permiso2);
        Assert.assertEquals(true, rol.VerificarObligatorios());
    }
}
