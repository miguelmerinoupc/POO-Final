
package benedicto_CTRL;

import benedicto_clases.AdministracionUsuarios.Historia;
import java.util.ArrayList;

/**
 * @author Miguel Merino
 */
public class HistoriaCTRL {

    private ArrayList<Historia> listahistoria = new ArrayList<Historia>();

    public void AgregarHistoria(Historia historia) {
        this.listahistoria.add(historia);
    }

    public ArrayList<Historia> BuscarHistoria(String usuario) {
        //Busca existencia de nombre de usuario ya registrado
        Historia historia;
        ArrayList<Historia> listaBuscada = new ArrayList<Historia>();
        for (int i = 0; i < listahistoria.size(); i++) {
            historia = listahistoria.get(i);
            if (historia.getUsuario().equals(usuario)) {
                listaBuscada.add(historia);
            }
        }
        return listaBuscada;
    }

}
