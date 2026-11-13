public class PrincipalEstricte {
    public static void main(String[] args) {
        Fil filJuan = new Fil("Juan", Thread.NORM_PRIORITY, 10, false);
        Fil filPepe = new Fil("Pepe", Thread.NORM_PRIORITY, 10, false);

        filJuan.start();
        filPepe.start();

        System.out.println("Termina thread main");
    }
}