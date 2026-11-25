import java.util.Scanner;

public class Coet {

    private static final int NUM_MOTORS = 4;
    private final Motor[] motors = new Motor[NUM_MOTORS];

    public Coet() {
        for (int i = 0; i < NUM_MOTORS; i++) {
            motors[i] = new Motor(i);
        }
    }

    /** Comprova que p estigui entre 0 i 10 i l'estableix a tots els motors. */
    public void passaAPotencia(int p) {
        if (p < 0 || p > 10) {
            System.out.println("Error de valor: la potència ha d'estar entre 0 i 10");
            return;
        }
        System.out.println("Passant a potència " + p);
        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    /** Posa en marxa els 4 motors. */
    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public static void main(String[] args) {
        Coet coet = new Coet();
        coet.arranca();

        Scanner sc = new Scanner(System.in);
        int p;
        do {
            p = sc.nextInt();
            coet.passaAPotencia(p);
        } while (p != 0);

        sc.close();
    }
}
