package controller;
import javafx.fxml.FXML;
import utils.Musica;
import utils.Navegacion;
import javafx.scene.control.Button;

public class InicioController {
    @FXML
    private Button BtnInicio;

    @FXML
    private void initialize() {
        Musica.iniciar();
    }

    @FXML
    private void abrirSeleccion(){
        Navegacion.abrirVentana("/view/Seleccion.fxml", "Seleccion de jugadores");
        Navegacion.cerrarVentana(BtnInicio); 
    } 

    @FXML
    private void abrirConfiguracion(){
        Navegacion.abrirVentana("/view/Configuracion.fxml", "Configuración");
        Navegacion.cerrarVentana(BtnInicio);
    } 
}
