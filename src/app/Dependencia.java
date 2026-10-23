package app;

public class Dependencia {

    private String nombre;
    private String codigo;

    public Dependencia(String nombre, String codigo) {
        this.nombre = validarDependencia(nombre, codigo);
        this.codigo = codigo;
    }

    private String validarDependencia(String nombre, String codigo) {
        if (nombre.equals("Biblioteca Central") && codigo.equals("DEP001")) {
            return nombre;
        } else if (nombre.equals("Oficina de Admisión") && codigo.equals("DEP002")) {
            return nombre;
        } else if (nombre.equals("Secretaría Académica") && codigo.equals("DEP003")) {
            return nombre;
        } else if (nombre.equals("Centro de Cómputo") && codigo.equals("DEP004")) {
            return nombre;
        } else if (nombre.equals("Dirección General") && codigo.equals("DEP005")) {
            return nombre;
        } else {
            System.out.println("No existe esa dependencia.");
            throw new IllegalArgumentException("Dependencia no permitida.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String mostrarDependencia() {
        return nombre + ", código: " + codigo;
    }
}
