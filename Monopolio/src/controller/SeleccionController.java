package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import exceptions.NombreVacioException;
import exceptions.SistemaValidador;
import model.Jugador;
import utils.Navegacion;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert.AlertType;
import model.Juego;

public class SeleccionController {
    @FXML
    private Button btnStart;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private TextField txtJugador1;

    @FXML
    private TextField txtJugador2;

    @FXML
    private TextField txtJugador3;

    @FXML
    private TextField txtJugador4;

    @FXML
    private Label lblJugador3;

    @FXML
    private Label lblJugador3Nombre;

    @FXML
    private Label lblJugador4;

    @FXML
    private Label lblJugador4Nombre;

    @FXML
    private ImageView imgJugador3P;

    @FXML
    private ImageView imgJugador3C;

    @FXML
    private ImageView imgJugador4P;

    @FXML
    private ImageView imgJugador4C;

    @FXML
    private Button btnStart1;

    private int cantidadJugadores = 2;
    private final int DINERO_INICIAL = 1500;

    @FXML
    private void Presionar2Jugador() {
        lblJugador3.setVisible(false);
        lblJugador3Nombre.setVisible(false);
        txtJugador3.setVisible(false);
        imgJugador3P.setVisible(false);
        imgJugador3C.setVisible(false);


        lblJugador4.setVisible(false);
        lblJugador4Nombre.setVisible(false);
        txtJugador4.setVisible(false);
        imgJugador4P.setVisible(false);
        imgJugador4C.setVisible(false);

        btnStart1.setVisible(true);
        btnStart.setVisible(false);
        cantidadJugadores = 2;
    }

    @FXML
    private void Presionar3Jugador() {
        lblJugador3.setVisible(true);
        lblJugador3Nombre.setVisible(true);
        txtJugador3.setVisible(true);
        imgJugador3P.setVisible(true);
        imgJugador3C.setVisible(true);

        btnStart1.setVisible(false);
        btnStart.setVisible(true);
        cantidadJugadores = 3;
    }

    @FXML
    private void Presionar4Jugador() {
        lblJugador3.setVisible(true);
        lblJugador3Nombre.setVisible(true);
        txtJugador3.setVisible(true);
        imgJugador3P.setVisible(true);
        imgJugador3C.setVisible(true);


        lblJugador4.setVisible(true);
        lblJugador4Nombre.setVisible(true);
        txtJugador4.setVisible(true);
        imgJugador4P.setVisible(true);
        imgJugador4C.setVisible(true);

        btnStart1.setVisible(false);
        btnStart.setVisible(true);
        cantidadJugadores = 4;
    }

    @FXML
    private void PresionarStart() {
        List<Jugador> jugadores = new ArrayList<>();
        try{
            switch (cantidadJugadores) {
                case 2:
                    SistemaValidador.validarNombre(txtJugador1.getText());
                    SistemaValidador.validarNombre(txtJugador2.getText());
                    jugadores.add(new Jugador(txtJugador1.getText(), DINERO_INICIAL, 0));
                    jugadores.add(new Jugador(txtJugador2.getText(), DINERO_INICIAL, 0));
                    break;
                case 3:
                    SistemaValidador.validarNombre(txtJugador1.getText());
                    SistemaValidador.validarNombre(txtJugador2.getText());
                    SistemaValidador.validarNombre(txtJugador3.getText());
                    jugadores.add(new Jugador(txtJugador1.getText(), DINERO_INICIAL, 0));
                    jugadores.add(new Jugador(txtJugador2.getText(), DINERO_INICIAL, 0));
                    jugadores.add(new Jugador(txtJugador3.getText(), DINERO_INICIAL, 0));
                    break;
                case 4:
                    SistemaValidador.validarNombre(txtJugador1.getText());
                    SistemaValidador.validarNombre(txtJugador2.getText());
                    SistemaValidador.validarNombre(txtJugador3.getText());
                    SistemaValidador.validarNombre(txtJugador4.getText());
                    jugadores.add(new Jugador(txtJugador1.getText(), DINERO_INICIAL, 0));
                    jugadores.add(new Jugador(txtJugador2.getText(), DINERO_INICIAL, 0));
                    jugadores.add(new Jugador(txtJugador3.getText(), DINERO_INICIAL, 0));
                    jugadores.add(new Jugador(txtJugador4.getText(), DINERO_INICIAL, 0));
                    break;
                }
            Juego juego = new Juego(jugadores);

            TableroController controller = Navegacion.abrirVentana("/view/Tablero.fxml", "Monopoly");
            controller.setJuego(juego);
            Navegacion.cerrarVentana(btnStart);

        }catch(NombreVacioException e){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Nombre vacío");
            alert.setContentText("Por favor, ingrese un nombre para cada jugador.");
            alert.showAndWait();
        }
    }
}
