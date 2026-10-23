package tda;

import app.Expediente;

public class ListaDoble {

    private NodoDoble primero, frente;

    public ListaDoble() {

    }

    public NodoDoble primero(){
        return primero;
    }
    
    public void insertarAlFinal(Expediente elemento) {
        NodoDoble nuevo = new NodoDoble(elemento);
        if (primero == null) {
            primero = nuevo;
            frente = nuevo;
        } else {
            frente.siguiente = nuevo;
            nuevo.previo = frente;
            frente = nuevo;
        }
    }

    public Expediente buscadorID(String id) {
        NodoDoble actual = primero;

        while (actual != null) {
            if (actual.elemento.getId() == id) {
                return actual.elemento;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void recorrer() {
        NodoDoble actual = primero;

        while (actual != null) {
            System.out.println("ID: " + actual.elemento.getId() + " | Asunto: " + actual.elemento.getAsunto() + " | Fecha Inicio: " + actual.elemento.getFechaInicio() + " | Fecha Fin: " + actual.elemento.getFechaFin());
            actual = actual.siguiente;
        }
    }
}
