package mensajes;

import banco.Empresa;

abstract public class Mensaje {
    protected Integer identificador;
    protected String realizador;
    protected String receptor;

    public Mensaje(Integer identificador, String realizador, String receptor) {
        this.identificador = identificador;
        this.realizador = realizador;
        this.receptor = receptor;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public String getRealizador() {
        return realizador;
    }

    public String getReceptor() {
        return receptor;
    }
}
