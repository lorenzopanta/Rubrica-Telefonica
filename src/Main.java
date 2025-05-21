import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Rubrica rubrica = Rubrica.getInstance();
        String scelta = "0";


        while(!scelta.equals("6")){
            System.out.println("\n--- RUBRICA TELEFONICA ---");
            System.out.println("1. Aggiungi contatto");                 //FATTO
            System.out.println("2. Rimuovi contatto");                  //FATTO (potrei aggiungere controllo case sensitive)
            System.out.println("3. Cerca contatto");                    //FATTO (potrei aggiungere controllo case sensitive)
            System.out.println("4. Mostra tutti i contatti");           //FATTO
            System.out.println("5. Salva contatti su file di testo");   //FATTO
            System.out.println("6. Esci\n");                            //FATTO


            System.out.println("Scelta: ");
            Scanner scan = new Scanner(System.in);
            scelta = scan.next();

            switch(scelta){
                case "1":   //aggiungi contatto
                    System.out.println("Inserisci nome: ");
                    String c_nome = scan.next();
                    System.out.println("Inserisci numero di telefono: ");
                    long c_numero = scan.nextLong();
                    System.out.println("Inserisci email: ");
                    String c_email = scan.next();
                    Contatto nuovo_contatto = new Contatto(c_nome, c_numero, c_email);
                    rubrica.aggiungi(nuovo_contatto);
                    break;

                case "2":   //rimuovi contatto
                    System.out.println("Inserisci il nome del contatto da rimuovere: ");
                    String c_rimuovi = scan.next();
                    boolean rimuovi_trovato = false;

                    for(Contatto c : rubrica.lista){
                        if(c.getNome().equals(c_rimuovi)){
                            rubrica.rimuovi(c);
                            rimuovi_trovato = true;
                            break;
                        }
                    }
                    if(!rimuovi_trovato){
                        System.out.println("Contatto non trovato");
                    }

                    break;

                case "3":   //cerca contatto
                    System.out.println("Inserisci il nome del contatto da cercare: ");
                    String c_cerca = scan.next();
                    boolean cerca_trovato = false;

                    for(Contatto c : rubrica.lista){
                        if(c.getNome().equals(c_cerca)){
                            System.out.println(c);
                            cerca_trovato = true;
                            break;
                        }
                    }
                    if(!cerca_trovato){
                        System.out.println("Contatto non trovato");
                    }
                    break;

                case "4":   //mostra contatti
                    rubrica.mostraContatti();
                    break;

                case "5":   //salva contatti su txt
                    try(FileWriter writer = new FileWriter("testo.txt")){

                        for(Contatto c : rubrica.lista){
                            writer.write(c.toString() + "\n");
                        }
                        System.out.println("Contatti salvati correttamente su file");
                    }
                    catch(FileNotFoundException e){
                        System.out.println("Impossibile localizzare file di testo");
                    }
                    catch(IOException e){
                        System.out.println("Impossibile scrivere file");
                    }
                    break;

                case "6":   //esci
                    System.out.println("Programma terminato, arrivederci");
                    break;

                default:
                    System.out.println("Input non valido, riprovare");
            }
        }



        /*
        Contatto persona1 = new Contatto("Marco", 12345, "marco@gmail.com");
        Contatto persona2 = new Contatto("Luca", 67890, "luca@gmail.com");

        rubrica.aggiungi(persona1);
        rubrica.aggiungi(persona2);

        rubrica.mostraContatti();

         */
    }
}