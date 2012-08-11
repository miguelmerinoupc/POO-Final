package benedicto_CTRL;

import benedicto_Asociaciones.DetalleGrupo;
import benedicto_clases.AdministracionUsuarios.AdmUsuario;
import benedicto_clases.Grupo_de_Estudios.GrupoEstudio;
import benedicto_interfaces.IBenedicto;
import java.util.ArrayList;

/**
 * Autor : Miguel Merino
 */
public class AdmUsuarioCTRL implements IBenedicto<AdmUsuario> {

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

    public void ListarResultado(ArrayList<AdmUsuario> listado) {


        for (AdmUsuario usuario : listado) {
            System.out.println("Usuario: " + usuario.getUsuario());
            System.out.println("\tNombre: " + usuario.getNombre() + " " + usuario.getAp_Paterno() + " " +
                               usuario.getAp_Materno());
            System.out.println("\tDni: " + usuario.getDni());
            System.out.println("\tCargo: " + usuario.getCargo());
            System.out.println("\tEmail: " + usuario.getEmail());
            System.out.println("\tFecha Ingreso: " + usuario.getFechaIngreso().toString());
            System.out.println("\tRol: " + usuario.getRol().getNombre());
            System.out.println("-\n");
        }
    }
}
