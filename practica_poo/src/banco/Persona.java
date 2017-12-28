package banco;

import excepciones.CampoVacioException;
import excepciones.NoEsUnDNIException;
import general.Utilidades;

abstract public class Persona {

    protected String dni;
    protected String nombre;
    private static Utilidades utilidades = new Utilidades();
    private static NoEsUnDNIException noEsUnDNIException = new NoEsUnDNIException("El formato de DNI no es válido");

    public Persona(String dni, String nombre) {
       this.dni = dni;
       this.nombre= nombre;
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String DNI) {
        try {
            if (utilidades.validarNIF(dni)) {
                this.dni = dni;
            } else {
                throw noEsUnDNIException;
            }
        } catch (NoEsUnDNIException noEsUnDNIException) {
            System.out.println(noEsUnDNIException.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try {
            if (!nombre.isEmpty()) {
                this.nombre = nombre;
            } else {
                throw new CampoVacioException("No le has dado un nombre.");
            }
        } catch (CampoVacioException campoVacioException) {
            System.out.println(campoVacioException.getMessage());
        }
    }
}
