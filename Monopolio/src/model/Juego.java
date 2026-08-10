package model;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Casilla> casillas;
    private ArrayList<Propiedad> propiedades;
    private Banco banco;
    private Tablero tablero;
    private Dado dado;
    private int turnoActual;

    Propiedad avBaltica = new Propiedad("Avenida Baltica", 60, 4, null, Propiedad.Grupo.AZUL, 30);
    Propiedad avOriental = new Propiedad("Avenida Oriental", 100, 6, null, Propiedad.Grupo.AZUL, 50);
    Propiedad avTablado = new Propiedad("Avenida Tablado", 140, 10, null, Propiedad.Grupo.MORADO, 70);
    Propiedad avVirginia = new Propiedad("Avenida Virginia", 200, 16, null, Propiedad.Grupo.MORADO, 100);
    Propiedad avSantiago = new Propiedad("Avenida Santiago", 240, 20, null, Propiedad.Grupo.ROJO, 120);
    Propiedad avIndiana = new Propiedad("Avenida Indiana", 300, 26, null, Propiedad.Grupo.ROJO, 150);
    Propiedad avConnecticut = new Propiedad("Avenida Connecticut", 350, 35, null, Propiedad.Grupo.AMARILLO, 175);
    Propiedad avVermont = new Propiedad("Avenida Vermont", 400, 50, null, Propiedad.Grupo.AMARILLO, 200);
    Propiedad Ferrocarril1 = new Propiedad("Ferrocarril 1", 200, 25, null, Propiedad.Grupo.FERROCARRIL, 0);
    Propiedad Ferrocarril2 = new Propiedad("Ferrocarril 2", 200, 25, null, Propiedad.Grupo.FERROCARRIL, 0);

    public Juego() {
        jugadores = new ArrayList<>();
        banco = null;
        tablero = null;
        dado = new Dado();
        turnoActual = 0;
    }

    public Juego(List<Jugador> jugadores) {
        setJugadores(new ArrayList<>(jugadores));
        casillas = new ArrayList<>();
        propiedades = new ArrayList<>();
        banco = new Banco(100000);
        tablero = new Tablero();
        dado = new Dado();
        turnoActual = 0;
        crearCasillas();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }
    public Banco getBanco() {
        return banco;
    }
    public Tablero getTablero() {
        return tablero;
    }
    public Dado getDado() {
        return dado;
    }
    public int getTurnoActual() {
        return turnoActual;
    }
    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual);
    }
    public ArrayList<Propiedad> getPropiedades(){
        return propiedades;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    public void setDado(Dado dado) {
        this.dado = dado;
    }
    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }

    public void siguienteTurno(){
        turnoActual++;
        if(turnoActual >= jugadores.size()){
            turnoActual = 0;
        }
    }

    public void crearCasillas() {
        casillas.add(new Casilla(0, Casilla.TipoCasilla.SALIDA, null));
        casillas.add(new Casilla(1, Casilla.TipoCasilla.COMUNIDAD, null));
        casillas.add(new Casilla(2, Casilla.TipoCasilla.PROPIEDAD, avBaltica));
        casillas.add(new Casilla(3, Casilla.TipoCasilla.IMPUESTO, null));
        casillas.add(new Casilla(4, Casilla.TipoCasilla.SUERTE, null));
        casillas.add(new Casilla(5, Casilla.TipoCasilla.PROPIEDAD, avOriental));
        casillas.add(new Casilla(6, Casilla.TipoCasilla.PARADA, Ferrocarril1));
        casillas.add(new Casilla(7, Casilla.TipoCasilla.CARCEL, null));
        casillas.add(new Casilla(8, Casilla.TipoCasilla.PARADA, Ferrocarril2));
        casillas.add(new Casilla(9, Casilla.TipoCasilla.PROPIEDAD, avTablado));
        casillas.add(new Casilla(10, Casilla.TipoCasilla.SUERTE, null));
        casillas.add(new Casilla(11, Casilla.TipoCasilla.COMUNIDAD, null));
        casillas.add(new Casilla(12, Casilla.TipoCasilla.PROPIEDAD, avVirginia));
        casillas.add(new Casilla(13, Casilla.TipoCasilla.SUERTE, null));
        casillas.add(new Casilla(14, Casilla.TipoCasilla.SUERTE, null));
        casillas.add(new Casilla(15, Casilla.TipoCasilla.PROPIEDAD, avSantiago));
        casillas.add(new Casilla(16, Casilla.TipoCasilla.IMPUESTO, null));
        casillas.add(new Casilla(17, Casilla.TipoCasilla.PROPIEDAD, avIndiana));
        casillas.add(new Casilla(18, Casilla.TipoCasilla.SUERTE, null));
        casillas.add(new Casilla(19, Casilla.TipoCasilla.IR_A_LA_CARCEL, null));
        casillas.add(new Casilla(20, Casilla.TipoCasilla.PROPIEDAD, avConnecticut));
        casillas.add(new Casilla(21, Casilla.TipoCasilla.COMUNIDAD, null));
        casillas.add(new Casilla(22, Casilla.TipoCasilla.SUERTE, null));
        casillas.add(new Casilla(23, Casilla.TipoCasilla.PROPIEDAD, avVermont));

        propiedades.add(Ferrocarril1);
        propiedades.add(Ferrocarril2);
        propiedades.add(avBaltica);
        propiedades.add(avOriental);
        propiedades.add(avConnecticut);
        propiedades.add(avTablado);
        propiedades.add(avVirginia);
        propiedades.add(avSantiago);
        propiedades.add(avIndiana);
        propiedades.add(avVermont);
    }

    public boolean tieneGrupo(Jugador jugador, Propiedad.Grupo grupo){
        for(Casilla c: casillas){
            if(c.esPropiedad()){
                Propiedad propiedad = c.getPropiedad();

                if(propiedad.getGrupo() == grupo && propiedad.getPropietario() != jugador)
                    return false;

            }
        }
        return true;
    }

}
