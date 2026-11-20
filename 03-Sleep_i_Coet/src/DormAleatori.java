import java.util.Random;

public class DormAleatori extends Thread{
    private final Long tempsCreacio;
    private final Random random;

    public DormAleatori(String nom) {
        super(nom);
        this.tempsCreacio = System.currentTimeMillis();
        this.random = new Random();
    }
}