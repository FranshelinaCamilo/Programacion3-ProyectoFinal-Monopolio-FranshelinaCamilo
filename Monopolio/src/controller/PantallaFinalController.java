package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Jugador;

public class PantallaFinalController {
    @FXML
    private Label lblGanador;

    @FXML
    private Label lbldineroganador;

    @FXML
    private void mostrarGanador(Jugador ganador) {
        lblGanador.setText(ganador.getNombre());
        lbldineroganador.setText("$" + ganador.getDinero());
    }
}
