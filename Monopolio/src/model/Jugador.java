package model;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int dinero;
    private int posicion;
    private ArrayList<Propiedad> propiedades;
    private boolean enCarcel;
    private int turnosPreso; 

    public Jugador() {
        setNombre("");
        setDinero(0);
        setPosicion(0);
        setPropiedades(new ArrayList<>());
        setEnCarcel(false);
        setTurnosPreso(0);
    }

    public Jugador(String nombre, int dinero, int posicion) {
        setNombre(nombre);
        setDinero(dinero);
        setPosicion(posicion);
        setPropiedades(new ArrayList<>());
        setEnCarcel(false);
        setTurnosPreso(0);
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
    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }
    public boolean getEnCarcel(){
        return enCarcel;
    }
    public int getTurnosPreso(){
        return turnosPreso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    public void setEnCarcel(boolean ec){
        this.enCarcel = ec;
    }
    public void setTurnosPreso(int tp){
        this.turnosPreso = tp;
    }

    public void agregarPropiedad(Propiedad propiedad) {
        propiedades.add(propiedad);
    }

    public void eliminarPropiedad(Propiedad propiedad) {
        propiedades.remove(propiedad);
    }

    public void pagar(int cantidad) {
        if (cantidad <= dinero) {
            dinero -= cantidad;
        }
    }

    public void recibir(int cantidad) {
        dinero += cantidad;
    }
}
