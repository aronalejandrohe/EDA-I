package app;

import tda.*;

public class Administrador {
    private String usuario,clave;
    private ListaDoble listaExpedientes;
    private ArbolExpedientes arbol;
    private ListacircularExpedientes listaAlerta;

    public Administrador(String usuario, String clave) {
        this.usuario = "usuario";
        this.clave = "123";
        this.listaExpedientes = new ListaDoble();
        this.arbol = new ArbolExpedientes();
        this.listaAlerta = new ListacircularExpedientes();
    }
    
    public boolean login(String nombreU, String contra){
        return nombreU.equals(usuario) && contra.equals(clave);
    }

    public ListaDoble getListaExpedientes() {
        return listaExpedientes;
    }

    public ListacircularExpedientes getListaAlerta() {
        return listaAlerta;
    }

    public ArbolExpedientes getArbol() {
        return arbol;
    }
    
    
    //LISTA DOBLE Y ARBOL PARA REF
    public boolean registrarExpediente(Expediente expe){   
        
        if (arbol.buscar(expe.getId()) != null) {
            System.out.println("Ya existe un expediente con ese ID.");
            return true;
        }
        
        listaExpedientes.insertarAlFinal(expe);
        arbol.insertar(expe); //referencia busqueda rapida por id
        listaAlerta.loadListaDoble(listaExpedientes);
        System.out.println("Registro correcto de expediente");
        return false;
    }
    
    
    //MOVIMIENTOS DE UN EXPE, LISTA SIMPLE
    public void movimientoAgregar(String id, Seguimiento seguimiento){
        
        Expediente expeEncontrar = arbol.buscar(id);
        if(expeEncontrar != null){
            expeEncontrar.agregarMovimiento(seguimiento);
            System.out.println("Seguimiento agregado");
        }
        else{
            System.out.println("Expediente no encontrado");
        }
    }
    
    public void movimientoImprimir(String id){
        
        Expediente expeEncontrar = arbol.buscar(id);
        if(expeEncontrar != null){
            expeEncontrar.mostrarSeguimiento();
        }
        else{
            System.out.println("Expediente no encontrado");
        }
    }
    
    public void finalizarTramite(String id){
        
        Expediente expeEncontrar = arbol.buscar(id);
        if(expeEncontrar != null){
            expeEncontrar.finalizarTramite();
            listaAlerta.loadListaDoble(listaExpedientes);
            System.out.println("Tramite del Expediente: " + id + " finalizado correctamente");
        }
        else{
            System.out.println("Expediente no encontrado");
        }
    }
    
    public void imprimirExpedientes(){
        listaExpedientes.recorrer();
    }
    
    
    //LISTA CIRCULAR ALERTAS
    public void alertaPorPrioridad(){
        listaAlerta.vaciar();
        listaAlerta.loadListaDoble(listaExpedientes);
        listaAlerta.ordenarPorPrioridad();
    }
    
    public void alertaPorAntiguedad(){
        listaAlerta.vaciar();
        listaAlerta.loadListaDoble(listaExpedientes);
        listaAlerta.ordenarPorAntiguedad();
    }
    
    
}
