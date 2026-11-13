public class Fil extends Thread{
    private int delay;
    private boolean ambTreball;
    
    public Fil(String nom, int prioritat, int delay, boolean ambTreball) {
        super(nom);
        this.setPriority(prioritat); 
        this.delay = delay;
        this.ambTreball = ambTreball;
    }

    @Override
    public void run(){
        for(int i = 1; i<9; i++){
            if(ambTreball){
                for (int j = 0; j < 1000; j++) {
                    // Bucle vacío para consumir tiempo de procesador
                }
            }
            //Pausa controlada (Comportamiento 3)
            if(delay> 0){
                try{
                    Thread.sleep(delay);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(getName() + " " + i);
        }
        System.out.println("Acaba el fil " + getName());
    }
}
