package parcial1;
import java.time.LocalDateTime;

public class Operacion {

    private String tipoOperacion;
    private double monto;
    private LocalDateTime fechaHoraOperacion;

    public Operacion(String tipoOperacion, double monto){
        this.tipoOperacion = tipoOperacion;
        this.monto = monto;
        this.fechaHoraOperacion = LocalDateTime.now();
    }

    public Comprobante generarComprobante(double saldoResultante){

        return new Comprobante(
                tipoOperacion,
                fechaHoraOperacion.toString(),
                "Cajero Centro",
                monto,
                saldoResultante
        );
    }

}