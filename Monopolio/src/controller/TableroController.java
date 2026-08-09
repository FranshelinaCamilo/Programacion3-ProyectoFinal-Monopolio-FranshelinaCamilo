package controller;

import javafx.fxml.FXML;
import model.Juego;
import model.Jugador;
import javafx.scene.control.Label;
import java.util.List;

public class TableroController {
    @FXML
    private Label lblNombre1;

    @FXML
    private Label lblNombre2;

    @FXML
    private Label lblNombre3;

    @FXML
    private Label lblNombre4;

    @FXML
    private Label lblColor1;

    @FXML
    private Label lblColor2;

    @FXML
    private Label lblColor3;

    @FXML
    private Label lblColor4;

    @FXML
    private Label lblDinero1;

    @FXML
    private Label lblDinero2;

    @FXML
    private Label lblDinero3;

    @FXML
    private Label lblDinero4;

    private Juego juego;

    public TableroController() {
    }

    public TableroController(Juego juego) {
        setJuego(juego);
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
        actualizarInformacionJugadores();
    }
    
    private void actualizarInformacionJugadores() {
        List<Jugador> jugadores = juego.getJugadores();
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            switch (i) {
                case 0:
                    lblNombre1.setText(jugador.getNombre());
                    lblColor1.setText("Rojo");
                    lblDinero1.setText(String.valueOf(jugador.getDinero()));
                    break;
                case 1:
                    lblNombre2.setText(jugador.getNombre());
                    lblColor2.setText("Verde");
                    lblDinero2.setText(String.valueOf(jugador.getDinero()));
                    break;
                case 2:
                    lblNombre3.setText(jugador.getNombre());
                    lblColor3.setText("Azul");
                    lblDinero3.setText(String.valueOf(jugador.getDinero()));
                    break;
                case 3:
                    lblNombre4.setText(jugador.getNombre());
                    lblColor4.setText("Rosa");
                    lblDinero4.setText(String.valueOf(jugador.getDinero()));
                    break;
            }
        }
    }
}
