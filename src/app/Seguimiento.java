package app;

import java.time.LocalDateTime;

public class Seguimiento {

    private LocalDateTime fecha;
    private Dependencia dependencia;

    public Seguimiento(Dependencia dependencia) {
        this.fecha = LocalDateTime.now();
        this.dependencia = dependencia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Dependencia getDependencia() {
        return dependencia;
    }

    public String mostrarMovimiento() {
        return ("Fecha del movimiento: " + fecha
                + "\nDependencia destino: " + dependencia.mostrarDependencia());
    }

}
