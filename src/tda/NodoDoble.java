package tda;

import app.Expediente;

public class NodoDoble {

    public Expediente elemento;
    public NodoDoble siguiente, previo;

    public NodoDoble(Expediente elemento) {
        this.elemento = elemento;
        this.siguiente = siguiente;
        this.previo = previo;
    }
}
