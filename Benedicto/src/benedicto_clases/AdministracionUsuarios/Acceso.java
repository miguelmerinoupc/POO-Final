package benedicto_clases.AdministracionUsuarios;

import benedicto_CTRL.AdmUsuarioCTRL;
import java.util.ArrayList;

/**
 * @author Miguel Merino
 */
public class Acceso {

    private String usuario;
    private String clave;

    public Acceso(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public Acceso() {
    }

    public String getClave() {
        return clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean VerificaAcceso() throws Exception {

        if (this.usuario.isEmpty() || this.clave.isEmpty()) {
            throw new Exception("Debe ingresar usuario y contraseña");
        }

        AdmUsuarioCTRL usuarioCTRL = new AdmUsuarioCTRL();
        ArrayList<AdmUsuario> listaencontrada = usuarioCTRL.BuscarUsuario(this.usuario);
        int cantidadencontrada;

        cantidadencontrada = listaencontrada.size();
        System.out.println(cantidadencontrada);
        if (cantidadencontrada == 1) {
            AdmUsuario user;
            for (int i = 0; i < listaencontrada.size(); i++) {
                user = listaencontrada.get(i);
                if (user.getUsuario().equals(this.usuario)) {
                    if (user.getClave().equals(this.clave)) {
                        System.out.println("Usuario Validado correcto Bienvenido..");
                        return true;
                    }
                }
            }
        }
        else {
            throw new Exception("Usuario o Contraseña es ioncorrecto");
        }

        return false;
    }
}
