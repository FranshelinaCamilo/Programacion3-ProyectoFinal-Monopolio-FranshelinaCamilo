package controller;
import javafx.fxml.FXML;
import utils.Navegacion;

public class InicioController {
    @FXML
    private void abrirTableroController(){
        Navegacion.abrirVentana("/view/Tablero.fxml", "Monopolio");
    } 
}
