package tda;

import app.Expediente;

public class NodoArbol {

    Expediente dato;
    NodoArbol izq, der;

    public NodoArbol(Expediente dato) {
        this.dato = dato;
    }
}
