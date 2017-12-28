package banco;

import excepciones.CampoVacio;
import excepciones.NoEsUnDNI;
import general.Utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Persona {

    protected String dni;
    protected String nombre;
    private static Utilidades utilidades = new Utilidades();
    private static NoEsUnDNI noEsUnDNI = new NoEsUnDNI("El formato de DNI no es válido");

    public Persona(String dni, String nombre) throws NoEsUnDNI {
        try {
            if (utilidades.validarNIF(dni)) {
                this.dni = dni;
            } else {
                throw noEsUnDNI;
            }
            if (!nombre.isEmpty()) {
                this.nombre = nombre;
            } else {
                throw new CampoVacio("No le has dado un nombre.");
            }
        } catch (NoEsUnDNI noEsUnDNI) {
            System.out.println(noEsUnDNI.getMessage());
            throw noEsUnDNI;
        } catch (CampoVacio campoVacio) {
            System.out.println(campoVacio.getMessage());
        }
    }

    public String getDNI() {
        return dni;
    }

    public void setDNI(String DNI) {
        try {
            if (utilidades.validarNIF(dni)) {
                this.dni = dni;
            } else {
                throw noEsUnDNI;
            }
        } catch (NoEsUnDNI noEsUnDNI) {
            System.out.println(noEsUnDNI.getMessage());
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
                throw new CampoVacio("No le has dado un nombre.");
            }
        } catch (CampoVacio campoVacio) {
            System.out.println(campoVacio.getMessage());
        }
    }
}
