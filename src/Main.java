import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Rubrica rubrica = Rubrica.getInstance();
        String scelta = "99";

        while(!scelta.equals("0")){
            System.out.println("\n--- RUBRICA TELEFONICA ---");
            System.out.println("1. Aggiungi contatto");                 //FATTO
            System.out.println("2. Rimuovi contatto");                  //FATTO
            System.out.println("3. Cerca contatto");                    //FATTO
            System.out.println("4. Mostra tutti i contatti");           //FATTO
            System.out.println("5. Scrivi contatti della rubrica su file di testo");   //FATTO
            System.out.println("6. Aggiungi contatti alla rubrica da file di testo");   //FATTO
            System.out.println("0. Esci\n");                            //FATTO


            System.out.println("Scelta: ");
            Scanner scan = new Scanner(System.in);
            scelta = scan.next();

            switch(scelta){
                case "1":   //aggiungi contatto
                    System.out.println("Inserisci nome: ");
                    String c_nome = scan.next();
                    if (c_nome.trim().isEmpty()) {      //controllo che il nome non sia vuoto o formato solo da spazi
                        System.out.println("Errore - Nome non valido");
                        break;
                    }

                    System.out.println("Inserisci numero di telefono: ");
                    if (!scan.hasNextLong()) {                               //controllo 1: verifico che l'input possa appartenere al tipo long
                        System.out.println("Errore - Inserire solo numeri");
                        scan.next();      //questa riga evita che l'input errato rimanga nel buffer
                        break;
                    }
                    long c_numero = scan.nextLong();
                    if (String.valueOf(c_numero).length() < 5) {            //controllo 2: verifico che il numero non sia troppo corto
                        System.out.println("Errore - Numero troppo corto");
                        break;
                    }

                    System.out.println("Inserisci email: ");
                    String c_email = scan.next();
                    if (!c_email.contains("@") || !c_email.contains(".")) {     //controllo che l'email contenga sia @ che .
                        System.out.println("Errore - Email non valida");
                        break;
                    }

                    Contatto nuovo_contatto = new Contatto(c_nome, c_numero, c_email);
                    rubrica.aggiungi(nuovo_contatto);
                    break;

                case "2":   //rimuovi contatto
                    System.out.println("Inserisci l'email del contatto da rimuovere: ");
                    String c_rimuovi = scan.next();
                    boolean rimuovi_trovato = false;

                    for(Contatto c : rubrica.lista){
                        if(c.getEmail().equalsIgnoreCase(c_rimuovi)){
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
                        if(c.getNome().equalsIgnoreCase(c_cerca)){
                            System.out.println(c);
                            cerca_trovato = true;
                        }
                    }
                    if(!cerca_trovato){
                        System.out.println("Contatto non trovato");
                    }
                    break;

                case "4":   //mostra contatti
                    rubrica.mostraContatti();
                    break;

                case "5":   //scrivi contatti su txt
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

                case "6":   //leggi contatti da txt
                    try(BufferedReader reader = new BufferedReader(new FileReader("testo.txt"))){
                        String line;
                        while((line = reader.readLine()) != null){

                            String[] parti = line.split(" \\| ");       //separa la linea in 3 parti usando | come separatore
                            String testo_nome = parti[0];
                            long testo_numero = Long.parseLong(parti[1]);   //parseLong() converte da String a long
                            String testo_email = parti[2];

                            Contatto testo_contatto = new Contatto(testo_nome, testo_numero, testo_email);
                            rubrica.aggiungi(testo_contatto);

                        }
                    }
                    catch(FileNotFoundException e){
                        System.out.println("Impossibile localizzare file di testo");
                    }
                    catch(IOException e){
                        System.out.println("Impossibile leggere file");
                    }
                    break;

                case "0":   //esci
                    System.out.println("Programma terminato, arrivederci");
                    break;

                default:
                    System.out.println("Input non valido, riprovare");
            }
        }

    }
}