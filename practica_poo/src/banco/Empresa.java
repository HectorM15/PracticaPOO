package banco;

public class Empresa {
    private String nombre;
    private Float valorAcciones;

    public Float getValorAcciones() {
        return valorAcciones;
    }

    public void setValorAcciones(Float valorAcciones) {
        this.valorAcciones = valorAcciones;
    }

    public Empresa(String nombre, Float valorAcciones) {

        this.nombre = nombre;
        this.valorAcciones = valorAcciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
