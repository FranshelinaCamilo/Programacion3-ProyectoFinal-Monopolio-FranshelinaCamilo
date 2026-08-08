package model;

public class Jugador {
    private String nombre;
    private int dinero;
    private int posicion;

    public Jugador() {
        setNombre("");
        setDinero(0);
        setPosicion(0);
    }

    public Jugador(String nombre, int dinero, int posicion) {
        setNombre(nombre);
        setDinero(dinero);
        setPosicion(posicion);
    }

    public String getNombre() {
        return nombre;
    }
    public int getDinero() {
        return dinero;
    }
    public int getPosicion() {
        return posicion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
