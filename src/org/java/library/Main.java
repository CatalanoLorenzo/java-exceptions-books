package org.java.library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Scrivere un programma che inserisce`n`libri in un array,dove`n`e' definito dall'utente.
//
//Chiedere i dati per ogni libro(`titolo`,`numero pagine`,`autore`,`editore`)
//,istanzia un nuovo oggetto della classe`Libro`e*lo inserisce nell’array*.
//Quando vengono inseriti i dati, in caso di violazione dei vincoli di integrita' 
//(es. **non accettare titolo o autore o editore vuoto**, **numero pagine ≤ 0**), 
//scatenare un'eccezione, informare l'utente del problema, e chiedere nuovamente il set di dati.
//Al termine dell’inserimento scrivere tutti i titoli dei libri in un file (uno per riga) 
//e in seguito rileggerli dal file mostradoli a video.

public class Main {

	public static void main(String[] args) {
		// ---------------------------------------------------------
		Scanner input = new Scanner(System.in);
		int numeroLibri = 0;
		try {
			System.out.print("Quanti libri ci sono nella Libreria? :");
			numeroLibri = Integer.valueOf(input.nextLine());
			if (numeroLibri <= 0) {
				System.err.println("devi inserire almeno un libro");
				System.out.print("Quanti libri ci sono nella Libreria? :");
				numeroLibri = Integer.valueOf(input.nextLine());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		Libri[] libreria = new Libri[numeroLibri];
		// ---------------------------------------------------------

		for (int i = 0; i < libreria.length; i++) {
			try {

				System.out.print("Qual'è il titolo del libro?:");
				String titolo = input.nextLine();

				System.out.print("Quante pagine ha il libro?:");
				int numeroPagine = Integer.valueOf(input.nextLine());
				if (numeroPagine <= 0) {
					System.err.println("Non puo avere meno pagine di 1");

					System.out.println("Quante pagine ha il libro?:");
					numeroPagine = Integer.valueOf(input.nextLine());
				}

				System.out.print("Qual'è l'autore del libro?:");
				String autore = input.nextLine();

				System.out.print("Qual'è l'editore del libro?:");
				String editore = input.nextLine();

				libreria[i] = new Libri(titolo, numeroPagine, autore, editore);

			} catch (Exception e) {
				System.out.println(" Errore : " + e.getMessage());
				i--;
			}

		}
		input.close();
		// ---------------Scrittura in un file--------------
		// creo una variabile di tipo FileWriter vuota
		FileWriter myWriter = null;
		// creo una vriabile di tipo stringa
		// e gli inserisco il percoso del file
		final String FILE_PATH = "./PROVA.TXT";

		// eseguo le istruzioni di scritturo in un try-catch per poter intercettare
		// eventuali errori
		try {

			// associo alla variabile una nuova istanza di filewrite cosi che tramite il
			// percorso del file puo adare a scrivere in questultimo che se non esiste lo
			// crerà lui e tramite il true gli dico che deve aggiungere al file sestesso e
			// non sostituire
			myWriter = new FileWriter(FILE_PATH, true);

			// ciclo per ogni libro presente nella libreria
			for (int x = 0; x < libreria.length; x++) {

				// e per ognuno di essi lo scrivo nel file (essendo il singolo libro una stringa
				// ToString)
				myWriter.write(libreria[x] + "\n");

			}

			// cerco eventuali errori di tipo IOException
		} catch (IOException e) {
			// nel caso stampo un errore in console
			System.err.println("Error updating file: " + e.getMessage());
		} finally {
			// dopodiche chiudo la scrittura del file
			try {
				myWriter.close();
				// amenoche non ci siano errori nella scrittura

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File tmpFile = new File(FILE_PATH);
		Scanner reader = null;
		try {

			reader = new Scanner(tmpFile);

			while (reader.hasNextLine()) {

				String line = reader.nextLine();
				System.out.println(line);
			}
		} catch (Exception e) {

			System.out.println("Error reading file: " + e.getMessage());
		} finally {

			if (reader != null)
				reader.close();
		}

	}

}
