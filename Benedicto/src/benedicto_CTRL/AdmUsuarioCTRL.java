package benedicto_CTRL;

import benedicto_clases.AdministracionUsuarios.AdmUsuario;
import java.util.ArrayList;

/**
 * Autor : Miguel Merino
 */
public class AdmUsuarioCTRL {

    private ArrayList<AdmUsuario> listausuarios = new ArrayList<AdmUsuario>();

    public void AgregarUsuario(AdmUsuario usuario) {
        this.listausuarios.add(usuario);
    }

    public ArrayList<AdmUsuario> BuscarUsuario(String usuario) {
        //Busca existencia de nombre de usuario ya registrado
        AdmUsuario user;
        ArrayList<AdmUsuario> listaBuscada = new ArrayList<AdmUsuario>();
        for (int i = 0; i < listausuarios.size(); i++) {
            user = listausuarios.get(i);
            if (user.getUsuario().equals(usuario)) {
                listaBuscada.add(user);
            }
        }
        return listaBuscada;
    }

    public boolean EliminaUsuario(String usuario) {
        AdmUsuario user = new AdmUsuario();
        for (int i = 0; i < listausuarios.size(); i++) {
            user = listausuarios.get(i);
            if (user.getUsuario().equals(usuario)) {
                System.out.println("Se esta eliminando al usuario ..." + user.getUsuario());
                this.listausuarios.remove(i);
                return true;
            }
        }
        return false;
    }
}
