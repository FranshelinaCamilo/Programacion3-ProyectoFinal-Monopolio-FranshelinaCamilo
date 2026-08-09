package model;

import java.util.Random;

public class Dado {
    public int lanzarDado() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
