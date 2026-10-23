package tda;
import app.Expediente;

public class ListacircularExpedientes {

    public ListacircularExpedientes() {
    }
    public NodoExpediente inicio = null;
    
    public void vaciar(){
        inicio=null;
    }

    public NodoExpediente getInicio() {
        return inicio;
    }
    
    
    
    public void loadListaDoble(ListaDoble lista){
        vaciar();
        System.out.println("vaciado");
        NodoDoble actual = lista.primero();
        while(actual!=null){
            if(actual.elemento.getFechaFin() == null){ //elemento es el expe
                insertar(actual.elemento);
                System.out.println("fecha fin no");
            }
            System.out.println("fecha fin si");
            actual = actual.siguiente;
        }
    }

    public void insertar(Expediente e) {
        NodoExpediente nuevo = new NodoExpediente(e);
        if (inicio == null) {
            inicio = nuevo;
            inicio.siguiente = inicio;
        } else {
            NodoExpediente temp = inicio;
            while (temp.siguiente != inicio) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.siguiente = inicio;
        }
    }
    public void mostrarPorPrioridad() {
        if (inicio == null) return;

        System.out.println("EXPEDIENTES ORDENADOS POR PRIORIDAD:");


        ordenarPorPrioridad();

        NodoExpediente temp = inicio;
        do {
            if (temp.dato.getFechaFin() == null) {
                System.out.println("ID: " + temp.dato.getId() + " | Prioridad: " + temp.dato.getPrioridad() + " | Asunto: " + temp.dato.getAsunto());
            }
            temp = temp.siguiente;
        } while (temp != inicio);
    }
    public void ordenarPorPrioridad() {
        if (inicio == null) return;
        
        boolean ordenado = false;
        while (!ordenado) {
            ordenado = true;
            NodoExpediente actual = inicio;
            while (actual.siguiente != inicio) {
                NodoExpediente sig = actual.siguiente;
                if (actual.dato.getPrioridad() > sig.dato.getPrioridad()) {
                    Expediente aux = actual.dato;
                    actual.dato = sig.dato;
                    sig.dato = aux;
                    ordenado = false;
                }
                actual = actual.siguiente;
            }
        }
    }
    public void mostrarPorAntiguedad() {
        if (inicio == null) return;

        System.out.println("EXPEDIENTES ORDENADOS POR ANTIGÜEDAD:");

        ordenarPorAntiguedad();

        NodoExpediente temp = inicio;
        while (true) {
            if (temp.dato.getFechaFin() == null) {
                long dias = java.time.Duration.between(temp.dato.getFechaInicio(), java.time.LocalDateTime.now()).toDays();
                System.out.println("ID: " + temp.dato.getId() + " | Antigüedad: " + dias + " días | Asunto: " + temp.dato.getAsunto());
            }
            temp = temp.siguiente;
            if (temp == inicio) break;
        }
    }
    public void ordenarPorAntiguedad() {
        if (inicio == null) return;

        boolean ordenado = false;
        while (!ordenado) {
            ordenado = true;
            NodoExpediente actual = inicio;
            while (actual.siguiente != inicio) {
                NodoExpediente sig = actual.siguiente;

                if (actual.dato.getFechaFin() == null && sig.dato.getFechaFin() == null) {
                    long dias1 = java.time.Duration.between(actual.dato.getFechaInicio(), java.time.LocalDateTime.now()).toDays();
                    long dias2 = java.time.Duration.between(sig.dato.getFechaInicio(), java.time.LocalDateTime.now()).toDays();

                    if (dias1 < dias2) {
                        Expediente aux = actual.dato;
                        actual.dato = sig.dato;
                        sig.dato = aux;
                        ordenado = false;
                    }
                }

                actual = actual.siguiente;
            }
        }
    }
    
    public Expediente buscadorID(String id) {
        NodoExpediente actual = inicio;
        
        while (actual.siguiente != inicio){
            if(actual.dato.getId() == id) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    
}
