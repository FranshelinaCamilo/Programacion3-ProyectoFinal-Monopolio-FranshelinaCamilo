package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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

    public void transferir(Jugador jugador1, Jugador jugador2, int cantidad) {
        if(jugador1.pagar(cantidad)){
            jugador2.recibir(cantidad);
        }else{
            
            Alert eliminado = new Alert(AlertType.INFORMATION);
            eliminado.setTitle("Jugador eliminado");
            eliminado.setHeaderText("¡Has quedado eliminado!");
            eliminado.setContentText("No tienes suficiente dinero para pagar el alquiler.");
            eliminado.showAndWait();
        }
    }
}
