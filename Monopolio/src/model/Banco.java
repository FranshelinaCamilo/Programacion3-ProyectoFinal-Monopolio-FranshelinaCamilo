package model;


public class Banco {
    private int dinero;

    public Banco(int dinero) {
        setDinero(dinero);
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void pagar(int cantidad) {
        if (cantidad <= dinero) {
            dinero -= cantidad;
        }
    }

    public void recibir(int cantidad) {
        dinero += cantidad;
    }

    public void cobrar(Jugador jugador, int cantidad){
        jugador.pagar(cantidad);
        recibir(cantidad);
    }

    public void transferir(Jugador jugador1, Jugador jugador2) {
    }
}
