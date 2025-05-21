import java.util.ArrayList;

public class Rubrica {

    //singleton
    private static Rubrica istanza;
    private Rubrica(){
    }
    public static Rubrica getInstance(){
        if(istanza == null){
            istanza = new Rubrica();
        }
        return istanza;
    }
    //singleton

    ArrayList<Contatto> lista = new ArrayList<>();

    public void aggiungi(Contatto contatto){
        lista.add(contatto);
        System.out.println("Contatto aggiunto correttamente alla lista");
    }

    public void rimuovi(Contatto contatto){
        lista.remove(contatto);
        System.out.println("Contatto rimosso correttamente dalla lista");
    }

    public void mostraContatti(){
        for(Contatto c : lista){
            System.out.println(c);
        }
    }


}
