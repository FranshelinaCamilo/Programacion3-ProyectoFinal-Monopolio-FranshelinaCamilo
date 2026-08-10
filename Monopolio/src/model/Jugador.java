package model;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int dinero;
    private int posicion;
    private ArrayList<Propiedad> propiedades;
    private boolean enCarcel;
    private int turnosPreso; 
    private boolean eliminado;

    public Jugador() {
        setNombre("");
        setDinero(0);
        setPosicion(0);
        setPropiedades(new ArrayList<>());
        setEnCarcel(false);
        setTurnosPreso(0);
        setEliminado(false);
    }

    public Jugador(String nombre, int dinero, int posicion) {
        setNombre(nombre);
        setDinero(dinero);
        setPosicion(posicion);
        setPropiedades(new ArrayList<>());
        setEnCarcel(false);
        setTurnosPreso(0);
        setEliminado(false);
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
    public boolean getEliminado(){
        return eliminado;
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
    public void setEliminado(boolean e){
        this.eliminado = e;
    }

    public void agregarPropiedad(Propiedad propiedad) {
        propiedades.add(propiedad);
    }

    public void eliminarPropiedad(Propiedad propiedad) {
        propiedades.remove(propiedad);
    }

    public void eliminar() {
        dinero = 0;
        eliminado = true;

        for (Propiedad p : propiedades) {
            p.setPropietario(null);
            p.setCantCasas(0);
            p.setAlquiler(p.getAlquilerIncial());
        }

        propiedades.clear();
    }

    public boolean pagar(int cantidad) {
        if (cantidad <= dinero) {
            dinero -= cantidad;
            return true;
        }
        
        eliminar();
        return false;
    }

    public void recibir(int cantidad) {
        dinero += cantidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
