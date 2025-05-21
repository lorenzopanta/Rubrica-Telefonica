# 📒 Rubrica Telefonica in Java
Applicazione da terminale scritta in Java che permette di gestire una rubrica di contatti.  
Supporta l'aggiunta, rimozione, ricerca, visualizzazione e salvataggio/caricamento dei contatti da un file `.txt`.

## 🚀 Funzionalità
- Aggiunta di un nuovo contatto (con controlli su input: nome, numero, email)
- Rimozione di un contatto tramite email
- Ricerca contatti per nome (case-insensitive)
- Visualizzazione di tutti i contatti
- Salvataggio dei contatti su file di testo
- Caricamento dei contatti da file di testo

## 💾 Formato file di testo
Ogni riga rappresenta un contatto nel seguente formato:
Nome | Numero | Email

## 🧱 Struttura del progetto
- `Main.java` – contiene il menù e la logica principale dell'app
- `Contatto.java` – classe per rappresentare un contatto
- `Rubrica.java` – classe Singleton che gestisce la lista dei contatti

# Requisiti
Java JDK 8 o superiore
