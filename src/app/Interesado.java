package app;

public class Interesado {

    private String nombres, email, tipo, dni, telefono;

    public Interesado(String dni, String telefono, String nombres, String email, String tipo) {
        this.dni = dni;
        this.telefono = telefono;
        this.nombres = nombres;
        this.email = email;
        this.tipo = tipo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String mostrarInteresado() {
        return nombres + " | Tipo: " + tipo + " | DNI : " + dni
                + " | Email: " + email + " | Telefono: " + telefono;
    }
}
