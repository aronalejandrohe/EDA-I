package app;
import java.time.LocalDateTime;
import tda.ListaSimple;

public class Expediente {

    private String id, asunto, documentoReferencia;
    private int prioridad;
    private Interesado interesado;
    /*datos del interesado*/
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private ListaSimple listaMovimientos;

    public Expediente(String id, String asunto, String documentoReferencia, int prioridad, Interesado interesado) {
        this.id = id;
        this.asunto = asunto;
        this.documentoReferencia = documentoReferencia;
        this.prioridad = prioridad;
        this.interesado = interesado;
        this.listaMovimientos = new ListaSimple();

        this.fechaInicio = LocalDateTime.now();
        this.fechaFin = null;
    }

    public String getId() {
        return id;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getDocumentoReferencia() {
        return documentoReferencia;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public Interesado getInteresado() {
        return interesado;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public ListaSimple getListaMovimientos() {
        return listaMovimientos;
    }

    public void agregarMovimiento(Seguimiento movimiento) {
        listaMovimientos.agregarAlFinal(movimiento);
    }

    public void mostrarSeguimiento() {
        listaMovimientos.imprimir();
    }

    public void finalizarTramite() {
        this.fechaFin = LocalDateTime.now();
    }

}
