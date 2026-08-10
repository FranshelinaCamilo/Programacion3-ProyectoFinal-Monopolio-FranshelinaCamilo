package model;

import java.util.ArrayList;

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
            jugador1.setDinero(0);
            jugador1.setEliminado(true);

            ArrayList<Propiedad> propiedades = jugador1.getPropiedades();
            for(Propiedad p: propiedades){
                p.setPropietario(null);
                p.setCantCasas(0);
                p.setAlquiler(p.getAlquilerIncial());
            }

            jugador1.getPropiedades().clear();
            
            Alert eliminado = new Alert(AlertType.INFORMATION);
            eliminado.setTitle("Jugador eliminado");
            eliminado.setHeaderText("¡Has quedado eliminado!");
            eliminado.setContentText("No tienes suficiente dinero para pagar el alquiler.");
            eliminado.showAndWait();
        }
    }
}
