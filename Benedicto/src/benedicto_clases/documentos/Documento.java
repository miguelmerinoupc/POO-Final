package benedicto_clases.documentos;

// autor : Luis Valle
import benedicto_clases.documentos.Tipo_Doc;
import benedicto_clases.documentos.Tipo_Mov;
import benedicto_clases.persona.Persona;
import java.util.ArrayList;
import org.joda.time.DateTime;

public class Documento {

    private String numero;
    private DateTime fecEmision;
    private DateTime fecVencimiento;
    private DateTime fecPago;
    private char estado;
    private double subTotal;
    private double igv;
    private double total;
    private char moneda;
    private String observaciones;
    private Tipo_Mov tipoMov;
    private Tipo_Doc tipodoDoc;

    public Tipo_Mov getTipoMov() {
        return tipoMov;
    }

    public Tipo_Doc getTipodoDoc() {
        return tipodoDoc;
    }
    private Persona persona;
    private ArrayList<DetalleDocumento> detalle = new ArrayList<DetalleDocumento>();

    public ArrayList<DetalleDocumento> getDetalle() {
        return detalle;
    }

    public Persona getPersona() {
        return persona;
    }

    public Documento(Tipo_Mov tipoMov) {
        this.tipoMov = tipoMov;
    }

    public Documento(Tipo_Mov tipoMov, DateTime fecEmision, DateTime fecVencimiento,
            double subTotal, double igv, double total, char moneda) {
        this.tipoMov = tipoMov;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.moneda = moneda;
    }

    public Documento() {
    }

    public Documento(Tipo_Mov tipoMov, String concepto, DateTime fecEmision, DateTime fecVencimiento, DateTime fecPago, char estado) {
        this.tipoMov = tipoMov;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.fecPago = fecPago;
        this.estado = estado;
    }

    public Documento(Tipo_Mov tipoMov, DateTime fecEmision, DateTime fecVencimiento, DateTime fecPago, char estado, String numero) {
        this.tipoMov = tipoMov;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.fecPago = fecPago;
        this.estado = estado;
        this.numero = numero;
    }


    public boolean VerificarOblitarios() {
        if (this.fecEmision == null) {
            System.out.println("Emision");
            return false;
        }
        if (this.fecVencimiento == null) {
            System.out.println("Vencimiento");
            return false;
        }
        if (this.subTotal <= 0.00) {
            System.out.println("SubTotal");
            return false;
        }
        if (this.igv <= 0.00) {
            System.out.println("Igv");
            return false;
        }
        if (this.total <= 0.00) {
            System.out.println("Total");
            return false;
        }
        if (this.moneda == ' ') {
            System.out.println("Moneda");
            return false;
        }
        return true;
    }

    public char getEstado() {
        return estado;
    }

    public DateTime getFecEmision() {
        return fecEmision;
    }

    public DateTime getFecPago() {
        return fecPago;
    }

    public DateTime getFecVencimiento() {
        return fecVencimiento;
    }

    public String getNumero() {
        return numero;
    }
}