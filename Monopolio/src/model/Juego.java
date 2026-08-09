package model;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private ArrayList<Jugador> jugadores;
    private Banco banco;
    private Tablero tablero;
    private Dado dado;
    private int turnoActual;

    public Juego() {
        jugadores = new ArrayList<>();
        banco = null;
        tablero = null;
        dado = new Dado();
        turnoActual = 0;
    }

    public Juego(List<Jugador> jugadores) {
        setJugadores(new ArrayList<>(jugadores));
        banco = new Banco(100000);
        tablero = new Tablero();
        dado = new Dado();
        turnoActual = 0;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
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
}
