package controller;

import javafx.fxml.FXML;
import model.Casilla;
import model.Dado;
import model.Juego;
import model.Jugador;
import model.Propiedad;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Rectangle;
import static javafx.scene.paint.Color.*;
import java.util.List;
import java.util.Random;

import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.scene.layout.*;
import javafx.scene.Node;

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

    @FXML
    private Rectangle turno1;

    @FXML
    private Rectangle turno2;

    @FXML
    private Rectangle turno3;

    @FXML
    private Rectangle turno4;

    @FXML
    private Button btnLanzarDado;

    @FXML
    private ImageView ficha1;

    @FXML
    private ImageView ficha2;

    @FXML
    private ImageView ficha3;

    @FXML
    private ImageView ficha4;

    @FXML
    private VBox AvSantiago;

    @FXML
    private VBox AvVirginia;

    @FXML
    private VBox AvTablado;

    @FXML
    private VBox AvOriental;

    @FXML
    private VBox AvBaltica;

    @FXML
    private VBox AvVermont;

    @FXML
    private VBox AvConnecticut;

    @FXML
    private VBox AvIndiana;

    @FXML
    private ImageView avSantiagohotel;

    @FXML
    private ImageView AvVirginiaHotel;

    @FXML
    private ImageView AvTabladoHotel;

    @FXML
    private ImageView AvOrientalHotel;

    @FXML
    private ImageView AvBalticaHotel;

    @FXML
    private ImageView AvVermontHotel;

    @FXML
    private ImageView AvConnecticutHotel;

    @FXML
    private ImageView AvIndianaHotel;

    private Juego juego;

    int[] posicionesX = {
        748, 674, 600, 526, 452, 378,
        304, 230, 230, 230, 230, 230,
        230, 304, 378, 452, 526, 600,
        674, 748, 748, 748, 748, 748
    };

    int[] posicionesY = {
        492, 492, 492, 492, 492, 492,
        492, 492, 426, 359, 292, 225, 
        158, 158, 158, 158, 158, 158,
        158, 158, 225, 292, 359, 426
    };

    int[] desplazamientoX = {
        0, 0, 40, 36
    };

    int[] desplazamientoY = {
        4, 41, 0, 31
    };

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
        actualizarTurnoActual();
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
                    ficha1.setVisible(true);
                    break;
                case 1:
                    lblNombre2.setText(jugador.getNombre());
                    lblColor2.setText("Verde");
                    lblDinero2.setText(String.valueOf(jugador.getDinero()));
                    ficha2.setVisible(true);
                    break;
                case 2:
                    lblNombre3.setText(jugador.getNombre());
                    lblColor3.setText("Azul");
                    lblDinero3.setText(String.valueOf(jugador.getDinero()));
                    ficha3.setVisible(true);
                    break;
                case 3:
                    lblNombre4.setText(jugador.getNombre());
                    lblColor4.setText("Rosa");
                    lblDinero4.setText(String.valueOf(jugador.getDinero()));
                    ficha4.setVisible(true);
                    break;
            }
        }
    }

    private void actualizarTurnoActual() {
        if(juego.getTurnoActual() == 0){
            turno1.setFill(GREEN);
            turno2.setFill(LIGHTGRAY);
            turno3.setFill(LIGHTGRAY);
            turno4.setFill(LIGHTGRAY);
        } else if(juego.getTurnoActual() == 1){
            turno2.setFill(GREEN);
            turno1.setFill(LIGHTGRAY);
            turno3.setFill(LIGHTGRAY);
            turno4.setFill(LIGHTGRAY);
        } else if(juego.getTurnoActual() == 2){
            turno3.setFill(GREEN);
            turno1.setFill(LIGHTGRAY);
            turno2.setFill(LIGHTGRAY);
            turno4.setFill(LIGHTGRAY);
        } else if(juego.getTurnoActual() == 3){
            turno4.setFill(GREEN);
            turno1.setFill(LIGHTGRAY);
            turno2.setFill(LIGHTGRAY);
            turno3.setFill(LIGHTGRAY);
        }
    }

    @FXML
    private void mostrarCasa(Propiedad propiedad){
        VBox casas = null;

        switch (propiedad.getNombre()) {
            case "Avenida Santiago":
                casas = AvSantiago;
                break;

            case "Avenida Virginia":
                casas = AvVirginia;
                break;

            case "Avenida Tablado":
                casas = AvTablado;
                break;

            case "Avenida Oriental":
                casas = AvOriental;
                break;

            case "Avenida Báltica":
                casas = AvBaltica;
                break;

            case "Avenida Vermont":
                casas = AvVermont;
                break;

            case "Avenida Connecticut":
                casas = AvConnecticut;
                break;

            case "Avenida Indiana":
                casas = AvIndiana;
                break;
        }

        if(casas == null){
            return;
        }

        int numeroCasa = propiedad.getCantCasas();

         int contador = 0;

         for(Node fila: casas.getChildren()){
            if(fila instanceof HBox){
                for(Node nodo: ((HBox) fila).getChildren()){
                    if(nodo instanceof ImageView){
                        if(contador == numeroCasa){
                            nodo.setVisible(true);
                            return;
                        }
                    }
                    contador++;
                }
            }
         }
    }

    @FXML
    private void lanzarDado() {

        Jugador jugadorActual = juego.getJugadorActual();

        if(jugadorActual.getEnCarcel()){
             Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Cárcel");
            alert.setHeaderText("Estás en la cárcel");
            alert.setContentText("Pierdes este turno.");
            alert.showAndWait();

            jugadorActual.setTurnosPreso(jugadorActual.getTurnosPreso() - 1);

            jugadorActual.setEnCarcel(false);

            juego.siguienteTurno();
            actualizarTurnoActual();

            return;
        }

        Dado dado = new Dado();
        int resultado1 = dado.lanzarDado();
        int resultado2 = dado.lanzarDado();

        int movimiento = resultado1 + resultado2;

        System.out.println("Jugador actual: " + jugadorActual.getNombre());
        System.out.println("Resultado del dado: " + resultado1 + " + " + resultado2 + " = " + movimiento);

        int posicionAnterior = jugadorActual.getPosicion();

        int nuevaPosicion = posicionAnterior + movimiento;
        if (nuevaPosicion >= 24) {
            nuevaPosicion = nuevaPosicion % 24;
        } 

        jugadorActual.setPosicion(nuevaPosicion);

        if(juego.getTurnoActual() == 0){
            moverJugador(jugadorActual, ficha1, posicionAnterior, movimiento);
        } else if(juego.getTurnoActual() == 1){
            moverJugador(jugadorActual, ficha2, posicionAnterior, movimiento);
        } else if(juego.getTurnoActual() == 2){
            moverJugador(jugadorActual, ficha3, posicionAnterior, movimiento);
        } else if(juego.getTurnoActual() == 3){
            moverJugador(jugadorActual, ficha4, posicionAnterior, movimiento);
        }
    }

    private void moverJugador(Jugador jugador, ImageView ficha, int posicionAnterior, int movimiento) {

        try {
            new Thread(() -> {
                for (int i = 1; i <= movimiento; i++) {

                    int indice = (posicionAnterior + i) % 24;

                    int x = posicionesX[indice] + desplazamientoX[juego.getTurnoActual()];
                    int y = posicionesY[indice] + desplazamientoY[juego.getTurnoActual()];

                    Platform.runLater(() -> {
                        ficha.setLayoutX(x);
                        ficha.setLayoutY(y);
                    });

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Platform.runLater(() -> {
                    procesarCasilla(jugador);
                    actualizarInformacionJugadores();
                    juego.siguienteTurno();
                    actualizarTurnoActual();
                });
            }).start();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private void procesarCasilla(Jugador jugador){
        int posicion = jugador.getPosicion();

        Casilla casilla = juego.getCasillas().get(posicion);

        System.out.println("Cayó en la casilla: " + (posicion + 1));
        System.out.println("Tipo: " + casilla.getTipo());

        switch (casilla.getTipo()) {
            case PROPIEDAD:
                Propiedad p = casilla.getPropiedad();
                if(p.estaDisponible()){
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Propiedad Disponible");
                    alert.setHeaderText(p.getNombre());
                    alert.setContentText("Precio: $" + p.getPrecio() + "\n¿Desea comprar esta propiedad?");
                    ButtonType comprar = new ButtonType("Comprar");
                    ButtonType noComprar = new ButtonType("No Comprar");

                    alert.getButtonTypes().setAll(comprar, noComprar);
                    alert.showAndWait().ifPresent(respuesta -> {
                        if(respuesta == comprar){
                            if(jugador.getDinero() >= p.getPrecio()){

                                p.setPropietario(jugador);
                                jugador.agregarPropiedad(p);
                                jugador.pagar(p.getPrecio());

                                actualizarInformacionJugadores();

                                Alert comprado = new Alert(AlertType.INFORMATION);
                                comprado.setTitle("Propiedad comprada");
                                comprado.setHeaderText(null);
                                comprado.setContentText("Has comprado " + p.getNombre());
                                comprado.showAndWait();
                            }
                            else{
                                Alert dineroInsuficiente = new Alert(AlertType.WARNING);
                                dineroInsuficiente.setTitle("Dinero Insuficiente");
                                dineroInsuficiente.setHeaderText("No puedes comprar esta propiedad");
                                dineroInsuficiente.setContentText("Necesitas $" + p.getPrecio() + " para comprar esta propiedad");

                                dineroInsuficiente.showAndWait();
                            }
                        }else if(respuesta == noComprar){
                        }
                    });
                }
                else{
                    Jugador propetario = p.getPropietario();
                    if(propetario == jugador){

                        if(juego.tieneGrupo(jugador, p.getGrupo())){
                            if(p.puedeConstruirCasa()){
                                Alert construir = new Alert(AlertType.CONFIRMATION);
                                construir.setTitle("Construccion");
                                construir.setHeaderText("Tienes todo el grupo");
                                construir.setContentText("Tienes todas las propiedades del grupo " + p.getGrupo() + "\n¿Deseas construir una casa? \nPrecio de la casa $" + p.getPrecioCasa());

                                ButtonType construirC = new ButtonType("Construir");
                                ButtonType noConstruir = new ButtonType("No Construir");

                                construir.getButtonTypes().setAll(construirC, noConstruir);
                                construir.showAndWait().ifPresent(respuesta->{
                                    if(respuesta == construirC){
                                        if(jugador.getDinero() >= p.getPrecioCasa()){
                                            jugador.pagar(p.getPrecioCasa());

                                            p.setCantCasas(p.getCantCasas() + 1);
                                            p.setAlquiler(p.getAlquiler() * 2);

                                            mostrarCasa(p);

                                            actualizarInformacionJugadores();

                                            Alert construida = new Alert(AlertType.INFORMATION);
                                            construida.setTitle("Construccion");
                                            construida.setHeaderText("Casa Construida");
                                            construida.setContentText("Has costruido una casa en " + p.getNombre() + "\nNuevo Alquiler: " + p.getAlquiler());
                                            construida.showAndWait();
                                        }else{
                                            Alert dineroInsuficiente = new Alert(AlertType.WARNING);
                                            dineroInsuficiente.setTitle("Dinero Insuficiente");
                                            dineroInsuficiente.setHeaderText("No puedes construir en esta propiedad");
                                            dineroInsuficiente.setContentText("Necesitas $" + p.getPrecioCasa() + " para construir una casa en esta propiedad");

                                            dineroInsuficiente.showAndWait();
                                        }
                                    }
                                });
                            }else{
                                Alert alert = new Alert(AlertType.INFORMATION);
                                alert.setTitle("Propiedad");
                                alert.setHeaderText(null);
                                alert.setContentText("Esta propiedad ya tiene el numero maximo de casas");
                                alert.showAndWait();
                            }
                            
                        }else{
                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Propiedad");
                            alert.setHeaderText(null);
                            alert.setContentText("Haz caido en tu propia propiedad");
                            alert.showAndWait();
                        }
                    }
                    else{
                        int alquiler = p.getAlquiler();
                        juego.getBanco().cobrar(jugador, alquiler);
                        propetario.recibir(alquiler);

                        Alert cobro = new Alert(AlertType.INFORMATION);
                        cobro.setTitle("Alquiler");
                        cobro.setHeaderText("Debes pagar alquiler");
                        cobro.setContentText("Debes pagar $" + p.getAlquiler() + " de alquiler a" + p.getPropietario());
                        cobro.showAndWait();
                    }
                }
                break;
            case IMPUESTO:
                if(casilla.getPosicion() == 3){
                    Alert impuesto = new Alert(AlertType.INFORMATION);
                    impuesto.setTitle("Impuesto");
                    impuesto.setHeaderText("¡Has caido en una casilla de impuestos!");
                    impuesto.setContentText("Debes pagar $200 de impuestos.");
                    impuesto.showAndWait();

                    juego.getBanco().cobrar(jugador, 200);
                }
                else if(casilla.getPosicion() == 16){
                    Alert impuesto = new Alert(AlertType.INFORMATION);
                    impuesto.setTitle("Impuesto");
                    impuesto.setHeaderText("¡Has caido en una casilla de impuestos!");
                    impuesto.setContentText("Debes pagar $350 de impuestos.");
                    impuesto.showAndWait();

                    juego.getBanco().cobrar(jugador, 350);
                }                    
                break;
            case SUERTE:
                Random random = new Random();
                int carta = random.nextInt(4);

                switch (carta) {
                    case 0:
                        Alert suerte1 = new 
                        break;
                
                    default:
                        break;
                }
                break;
            case COMUNIDAD:
                System.out.println("Cayo en comunidad");
                break;
            case CARCEL:
                Alert visita = new Alert(AlertType.INFORMATION);
                visita.setTitle("Carcel");
                visita.setHeaderText("¡Estas de visita!");
                visita.setContentText("Bienvenido a La Victoria. Date una vuelta y sigue de largo");
                visita.showAndWait();
                break;
            case IR_A_LA_CARCEL:
                System.out.println("Cayo en ir a la carcel");

                jugador.setPosicion(7);
                jugador.setEnCarcel(true);
                jugador.setTurnosPreso(1);

                Platform.runLater(() ->{
                    ImageView ficha = null;

                    if(jugador == juego.getJugadores().get(0))
                        ficha = ficha1;
                    else if(jugador == juego.getJugadores().get(1))
                        ficha = ficha2;
                    else if(jugador == juego.getJugadores().get(2))
                        ficha = ficha3;
                    else if(jugador == juego.getJugadores().get(3))
                        ficha = ficha4;

                    if(ficha != null){
                        int turno = juego.getTurnoActual();

                        ficha.setLayoutX(posicionesX[7] + desplazamientoX[turno]);
                        ficha.setLayoutY(posicionesY[7] + desplazamientoY[turno]);
                    }
                });

                Alert carcel = new Alert(AlertType.INFORMATION);
                carcel.setTitle("¡A la carcel!");
                carcel.setHeaderText("Has sido enviado a la carcel");
                carcel.setContentText("Perderas tu proximo turno.");
                carcel.showAndWait();

                break;
            case PARADA:
                Propiedad pa = casilla.getPropiedad();
                if(pa.estaDisponible()){
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Propiedad Disponible");
                    alert.setHeaderText(pa.getNombre());
                    alert.setContentText("Precio: $" + pa.getPrecio() + "\n¿Desea comprar esta parada?");
                    ButtonType comprar = new ButtonType("Comprar");
                    ButtonType noComprar = new ButtonType("No Comprar");

                    alert.getButtonTypes().setAll(comprar, noComprar);
                    alert.showAndWait().ifPresent(respuesta -> {
                        if(respuesta == comprar){
                            if(jugador.getDinero() >= pa.getPrecio()){

                                pa.setPropietario(jugador);
                                jugador.agregarPropiedad(pa);
                                jugador.pagar(pa.getPrecio());

                                actualizarInformacionJugadores();

                                Alert comprado = new Alert(AlertType.INFORMATION);
                                comprado.setTitle("Propiedad comprada");
                                comprado.setHeaderText(null);
                                comprado.setContentText("Has comprado " + pa.getNombre());
                                comprado.showAndWait();
                            }
                            else{
                                Alert dineroInsuficiente = new Alert(AlertType.WARNING);
                                dineroInsuficiente.setTitle("Dinero Insuficiente");
                                dineroInsuficiente.setHeaderText("No puedes comprar esta propiedad");
                                dineroInsuficiente.setContentText("Necesitas $" + pa.getPrecio() + " para comprar esta propiedad");

                                dineroInsuficiente.showAndWait();
                            }
                        }else if(respuesta == noComprar){
                        }
                    });
                }
                else{
                    Jugador propetario = pa.getPropietario();
                    if(propetario == jugador){
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Propiedad");
                        alert.setHeaderText(null);
                        alert.setContentText("Haz caido en tu propia propiedad");
                        alert.showAndWait();
                    }
                    else{
                        int alquiler = pa.getAlquiler();
                        juego.getBanco().cobrar(jugador, alquiler);
                        propetario.recibir(alquiler);

                        Alert cobro = new Alert(AlertType.INFORMATION);
                        cobro.setTitle("Alquiler");
                        cobro.setHeaderText("Debes pagar alquiler");
                        cobro.setContentText("Debes pagar $" + pa.getAlquiler() + " de alquiler a" + pa.getPropietario());
                        cobro.showAndWait();
                    }
                }
                break;
            case SALIDA:
                System.out.println("Cayo en salida");
                break;
        }
    }
}
