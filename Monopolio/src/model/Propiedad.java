package model;

public class Propiedad {
    private String nombre;
    private int precio;
    private int alquiler;
    private Jugador propietario;
    private Grupo grupo;
    private int cantCasas;
    private int precioCasa;

    public enum Grupo {
        ROJO,
        AZUL,
        MORADO,
        AMARILLO, 
        FERROCARRIL
    }

    public Propiedad() {
        setNombre("");
        setPrecio(0);
        setAlquiler(0);
        setPropietario(null);
        setGrupo(null);
    }

    public Propiedad(String nombre, int precio, int alquiler, Jugador propietario, Grupo grupo, int precioCasa) {
        setNombre(nombre);
        setPrecio(precio);
        setAlquiler(alquiler);
        setPropietario(propietario);
        setGrupo(null);
        setPrecioCasa(precioCasa);
    }

    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public int getAlquiler() {
        return alquiler;
    }
    public Jugador getPropietario() {
        return propietario;
    }
    public Grupo getGrupo() {
        return grupo;
    }
    public int getCantCasas(){
        return cantCasas;
    }
    public int getPrecioCasa(){
        return precioCasa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public void setAlquiler(int alquiler) {
        this.alquiler = alquiler;
    }
    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public void setCantCasas(int c){
        this.cantCasas = c;
    }
    public void setPrecioCasa(int p){
        this.precioCasa = p;
    }

    public boolean estaDisponible() {
        return propietario == null;
    }
    public boolean puedeConstruirCasa(){
        return cantCasas < 4;
    }

}
