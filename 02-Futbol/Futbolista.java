public class Futbolista extends Thread{
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;
    
    public Futbolista(String nom){
        super(nom);
        this.ngols=0;
        this.ntirades=0;
    }

    public static int getNumJugadors() {
        return NUM_JUGADORS;
    }

    public static int getNumTirades() {
        return NUM_TIRADES;
    }

    public static float getProbabilitat() {
        return PROBABILITAT;
    }

    public int getNgols() {
        return ngols;
    }

    public void setNgols(int ngols) {
        this.ngols = ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public void setNtirades(int ntirades) {
        this.ntirades = ntirades;
    }
    public void run(){
        for(int i = 0; i<NUM_TIRADES; i++){
            this.ntirades++;
        }
        if(Math.random() < PROBABILITAT){
            this.ngols++;
        }
    }

    public static void main(String[] args){
        String[] noms = {
            "Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo",
            "Lewan", "Belli", "Arnau", "Aspas", "Messi", "MBapé"
        };

        Futbolista[] futbolistas = new Futbolista[NUM_JUGADORS];
        
    }
}