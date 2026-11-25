import java.util.Random;

public class Motor extends Thread {

    private final int id;
    private final Random random = new Random();

    private int potenciaObjectiu = 0;
    private int potenciaActual = 0;
    private boolean ordenat = false; // s'ha rebut alguna ordre amb setPotencia

    public Motor(int id) {
        super("Motor " + id);
        this.id = id;
    }

    public synchronized void setPotencia(int p) {
        this.potenciaObjectiu = p;
        this.ordenat = true;
        notifyAll(); // desperta el motor si estava esperant
    }

    @Override
    public void run() {
        try {
            while (true) {
                // Espera fins que hi hagi alguna cosa a fer
                synchronized (this) {
                    while (potenciaActual == potenciaObjectiu
                            && !(potenciaObjectiu == 0 && ordenat)) {
                        wait();
                    }
                    // Objectiu 0 i potència 0 -> el motor s'atura i surt
                    if (potenciaActual == potenciaObjectiu) {
                        return;
                    }
                }

                // Temps de resposta aleatori entre 1 i 2 segons
                Thread.sleep(1000 + random.nextInt(1001));

                synchronized (this) {
                    String tipus;
                    if (potenciaActual < potenciaObjectiu) {
                        potenciaActual++;
                        tipus = "Incre.";
                    } else if (potenciaActual > potenciaObjectiu) {
                        potenciaActual--;
                        tipus = "Decre.";
                    } else {
                        continue; // l'objectiu ha canviat mentre dormia
                    }

                    if (potenciaActual == potenciaObjectiu) {
                        tipus = "FerRes";
                    }

                    System.out.println("Motor " + id + ": " + tipus
                            + " Objectiu: " + potenciaObjectiu
                            + " Actual: " + potenciaActual);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Motor " + id + " interromput");
        }
    }
}
