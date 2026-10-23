package tda;

import app.Expediente;

public class ArbolExpedientes {

    private NodoArbol raiz;

    public void insertar(Expediente expe) {
        raiz = insertarRec(raiz, expe);
    }

    private NodoArbol insertarRec(NodoArbol actual, Expediente expe) {
        if (actual == null) {
            return new NodoArbol(expe);
        }
        if (expe.getId().compareTo(actual.dato.getId()) < 0) {
            actual.izq = insertarRec(actual.izq, expe);
        } else {
            actual.der = insertarRec(actual.der, expe);
        }
        return actual;
    }

    public Expediente buscar(String id) {
        return buscarRec(raiz, id);
    }

    private Expediente buscarRec(NodoArbol actual, String id) {
        if (actual == null) {
            //System.out.println("Expediente no encontrado");
            return null;
        }
        if (id.equals(actual.dato.getId())) {
            return actual.dato;
        }
        if (id.compareTo(actual.dato.getId()) < 0) {
            return buscarRec(actual.izq, id);
        } else {
            return buscarRec(actual.der, id);
        }
    }

    public void mostrarInorden() {
        mostrarInordenRec(raiz);
    }

    private void mostrarInordenRec(NodoArbol actual) {
        if (actual != null) {
            mostrarInordenRec(actual.izq);
            System.out.println("ID: " + actual.dato.getId() + " | Asunto: " + actual.dato.getAsunto());
            mostrarInordenRec(actual.der);
        }
    }
}
