package model;

public class Tablero {
    private Casilla[] casillas;

    public Tablero() {
        casillas = new Casilla[24];
    }

    public Casilla[] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[] casillas) {
        this.casillas = casillas;
    }
}
