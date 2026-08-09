package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

public class Navegacion {
    public static <T> T abrirVentana(String ruta, String titulo) {
        try{
            FXMLLoader loader = new FXMLLoader(Navegacion.class.getResource(ruta));
            
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(scene);
            stage.show();

            return loader.getController();
        } catch (Exception e) {
            throw new RuntimeException("Error al abrir la ventana: " + ruta, e);
        }
    }

    public static void cerrarVentana(Node node) {
        try {
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            throw new RuntimeException("Error al cerrar la ventana: " + node.getScene().getWindow(), e);
        }
    }
}
