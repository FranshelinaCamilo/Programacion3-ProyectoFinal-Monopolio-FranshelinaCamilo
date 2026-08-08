package model;

public class Casilla {
    private int posicion;
    private TipoCasilla tipo;
    private Propiedad propiedad;

    public enum TipoCasilla {
        SALIDA,
        PROPIEDAD,
        CARCEL,
        IR_A_LA_CARCEL,
        IMPUESTO,
        PARADA,
        SUERTE,
        COMUNIDAD
    }   

    public Casilla() {
        setPosicion(0);
        setTipo(TipoCasilla.SALIDA);
        setPropiedad(null);
    }

    public Casilla(int posicion, TipoCasilla tipo, Propiedad propiedad) {
        setPosicion(posicion);
        setTipo(tipo);
        setPropiedad(propiedad);
    }

    public int getPosicion() {
        return posicion;
    }
    public TipoCasilla getTipo() {
        return tipo;
    }
    public Propiedad getPropiedad() {
        return propiedad;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void setTipo(TipoCasilla tipo) {
        this.tipo = tipo;
    }
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
}
