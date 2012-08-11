package PruebasBenedicto;

import benedicto_Asociaciones.DetalleGrupo;
import benedicto_CTRL.GrupoEstudioCTRL;
import benedicto_clases.Grupo_de_Estudios.*;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author u201216787
 */
public class GrupoEstudioTest {

    @Test
    public void VerificarAltaGrupo() {
        GrupoEstudioCTRL grupoCTRL = new GrupoEstudioCTRL();
        GrupoEstudio grupo;
        Academia academia;

        String nombre = "POO";
        DateTime fecInicio = new DateTime(2012, 1, 15, 0, 0);
        DateTime fecFin = new DateTime(2012, 1, 30, 0, 0);

        academia = new Academia("A1", "Ing. Sistemas");
        String link = "http://www.google.com/file/sillabus/IngSistemas";
        String coordenadas = "051123,121312";

        ArrayList<DetalleGrupo> detalle = new ArrayList<DetalleGrupo>();

        Curso c1 = new Curso("C1", "POO");
        Curso c2 = new Curso("C2", "Calculo I");
        Curso c3 = new Curso("C3", "Etica");

        Instructor i1 = new Instructor("I1", "Juan Gonzales");
        Instructor i2 = new Instructor("I2", "Rosa Bendezu");
        Instructor i3 = new Instructor("I3", "Luis Gomez");

        Aula a1 = new Aula("A1", "U150");
        Aula a2 = new Aula("A2", "U540");
        Aula a3 = new Aula("A3", "U670");

        DetalleGrupo dg1 = new DetalleGrupo(c1, i2, a3);
        DetalleGrupo dg2 = new DetalleGrupo(c2, i3, a1);
        DetalleGrupo dg3 = new DetalleGrupo(c3, i1, a2);

        detalle.add(dg1);
        detalle.add(dg2);
        detalle.add(dg3);

        grupo = new GrupoEstudio(nombre, academia, fecInicio, fecFin, link, coordenadas, detalle);

        // Verificar datos obligatorios
        Assert.assertEquals(true, grupo.VerificarObligatorios());

        if (grupo.VerificarObligatorios()) {
            // Dar de alta un grupo de estudio
            Assert.assertEquals(true, grupoCTRL.AltaGrupo(grupo));
        }
    }
}