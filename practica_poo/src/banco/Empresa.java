package banco;

public class Empresa {
    private String nombre;
    private Double valorAcciones;
    private Double incremento;
    private Double valorAnterior;

    public Empresa(String nombre, Double valorAcciones, Double valorAnterior) {
        this.nombre = nombre;
        this.valorAcciones = valorAcciones;
        this.valorAnterior = valorAnterior;
        this.incremento = calcularIncremento();
    }

    public Empresa(String nombre, Double valorAcciones) {
        this.nombre = nombre;
        this.valorAcciones = valorAcciones;
        this.valorAnterior = valorAcciones;
        this.incremento = 0.00;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValorAcciones() {
        return valorAcciones;
    }

    public void setValorAcciones(Double valorAcciones) {
        this.setValorAnterior(this.valorAcciones);
        this.valorAcciones = valorAcciones;
        this.incremento=calcularIncremento();
    }

    public Double getIncremento() {
        return incremento;
    }

    private Double calcularIncremento(){
        this.incremento=this.getValorAcciones()-this.getValorAnterior();
        return this.getIncremento();
    }

    public Double getValorAnterior() {
        return valorAnterior;
    }

    private void setValorAnterior(Double valorAnterior) {
        this.valorAnterior = valorAnterior;
    }
}
