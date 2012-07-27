

package benedicto_clases;

// autor : Luis Valle
public class Documento {

    private char tipoMov;
    private char tipoDoc;
    private String numero;
    private String concepto;
    private String razon;
    private String ruc;
    private String fecEmision;
    private String fecVencimiento;
    private String fecPago;
    private char estado;
    private double subTotal;
    private double igv;
    private double total;
    private char moneda;
    private String observaciones;

    public Documento(char tipoMov) {
        this.tipoMov = tipoMov;
    }

    public Documento(char tipoMov, String concepto, String fecEmision, String fecVencimiento,
                     double subTotal, double igv, double total, char moneda) {
        this.tipoMov = tipoMov;
        this.concepto = concepto;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.subTotal = subTotal;
        this.igv = igv;
        this.total = total;
        this.moneda = moneda;
    }

    public Documento() {
        
    }

    public Documento(char tipoMov, String concepto, String fecEmision, String fecVencimiento, String fecPago, char estado) {
        this.tipoMov = tipoMov;
        this.concepto = concepto;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.fecPago = fecPago;
        this.estado = estado;
    }

    public Documento(char tipoMov, String concepto, String fecEmision, String fecVencimiento, String fecPago, char estado, String numero) {
        this.tipoMov = tipoMov;
        this.concepto = concepto;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.fecPago = fecPago;
        this.estado = estado;
        this.numero = numero;
    }

    public char getTipoMov() {
        return tipoMov;
    }

    public boolean VerificarOblitarios () {
        if (this.concepto == null || this.concepto.trim().equals("")){
            System.out.println("Concepto");
            return false;}
        if (this.fecEmision == null || this.fecEmision.trim().equals("")){
            System.out.println("Emision");
            return false;}
        if (this.fecVencimiento == null || this.fecVencimiento.trim().equals("")){
            System.out.println("Vencimiento");
            return false;}
        if (this.subTotal <= 0.00){
            System.out.println("SubTotal");
            return false;}
        if (this.igv <= 0.00){
            System.out.println("Igv");
            return false;}
        if (this.total <= 0.00){
            System.out.println("Total");
            return false;}
        if (this.moneda == ' '){
            System.out.println("Moneda");
            return false;}
        return true;
    }

    public String getConcepto() {
        return concepto;
    }

    public char getEstado() {
        return estado;
    }

    public String getFecEmision() {
        return fecEmision;
    }

    public String getFecPago() {
        return fecPago;
    }

    public String getFecVencimiento() {
        return fecVencimiento;
    }

    public String getNumero() {
        return numero;
    }

   
}
