public class Administrador {
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa;

    public Administrador(){
        poblacio_activa = new Treballador[num_poblacio_activa];
        for(int i = 0; i < num_poblacio_activa; i++){
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000.0f, 20, 65);
        }
    }
    public static void main(String[] args) {
        Administrador admin = new Administrador();

        //Ponemos en marcha los hilos
        for(int i = 0; i < admin.num_poblacio_activa; i++){
            admin.poblacio_activa[i].start();
        }
        //Esperamos a que todos terminen con join() antes de mostrar los datos
        for (int i = 0; i < admin.num_poblacio_activa; i++) {
            try {
                admin.poblacio_activa[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //Mostramos las estadísticas finales
        for (int i = 0; i < admin.num_poblacio_activa; i++) {
            Treballador t = admin.poblacio_activa[i];
            System.out.printf("%s -> edat: %d / total: %.2f%n", t.getName(), t.getEdat(), t.getCobrat());
        }
    }
}   
