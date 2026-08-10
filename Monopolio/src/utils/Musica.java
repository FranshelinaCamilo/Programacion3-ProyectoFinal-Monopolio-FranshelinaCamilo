package utils;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Musica {
    private static MediaPlayer reproductor;
    private static double volumen = 0.5;

    public static void iniciar() {
        if (reproductor == null) {
            Media media = new Media(
                Musica.class.getResource("/Recursos/AWalk.mp3").toExternalForm()
            );

            reproductor = new MediaPlayer(media);
            reproductor.setCycleCount(MediaPlayer.INDEFINITE);
            reproductor.setVolume(volumen);
            reproductor.play();
        }
    }

    public static void setVolumen(double volumen) {
        Musica.volumen = volumen;

        if (reproductor != null) {
            reproductor.setVolume(volumen);
        }
    }

    public static double getVolumen() {
        return volumen;
    }
}
