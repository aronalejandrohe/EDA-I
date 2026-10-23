package tda;

import app.Seguimiento;

public class ListaSimple {

    public NodoSimple primero, frente;
    int contador = 0;

    public ListaSimple() {

    }

    public void agregarAlFinal(Seguimiento elemento) {
        NodoSimple nuevo = new NodoSimple(elemento);
        if (primero == null) {
            primero = nuevo;
            frente = nuevo;
        } else {
            frente.siguiente = nuevo;
            frente = nuevo;
        }
    }

    public void imprimir() {
        NodoSimple actual = primero;
        while (actual != null) {
            System.out.println(actual.elemento.mostrarMovimiento());
            actual = actual.siguiente;
        }
    }
}
