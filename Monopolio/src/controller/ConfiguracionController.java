package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import utils.Musica;
import utils.Navegacion;

public class ConfiguracionController {
    @FXML
    private Slider slVolumen;

    @FXML
    private Button btn2;

    @FXML
    private void initialize() {
        slVolumen.setValue(Musica.getVolumen() * 100);

        slVolumen.valueProperty().addListener((obs, viejo, nuevo) -> {
            Musica.setVolumen(nuevo.doubleValue() / 100);
        });
    }

    @FXML
    private void abrirInicio(){
        Navegacion.abrirVentana("/view/Inicio.fxml", "Inicio");
        Navegacion.cerrarVentana(btn2); 
    } 
}
