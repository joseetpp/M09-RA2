public class PrincipalDiferents {
    public static void main(String[] args) {
        Fil filJuan = new Fil("Juan", Thread.MAX_PRIORITY, 0, true);
        Fil filPepe = new Fil("Pepe", Thread.MIN_PRIORITY, 0, true);

        filJuan.start();
        filPepe.start();

        System.out.println("Acaba thread main");
    }
}
