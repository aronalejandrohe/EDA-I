package tda;
import app.Expediente;
public class NodoExpediente {
    Expediente dato;
    public NodoExpediente siguiente;

    public NodoExpediente(Expediente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Expediente getDato() {
        return dato;
    }

    public NodoExpediente getSiguiente() {
        return siguiente;
    }
    
}
