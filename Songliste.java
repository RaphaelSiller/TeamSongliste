package TeamArbeitSonglisteV3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Speichert in einem beschränkten Array Songobjekte ab und 
 * verfügt über die Fähigkeit diese aus einer Textdatei zu lesen und 
 * diese in eine Textdatei zu schreiben
 * @author Raphael Siller
 *
 */
public class Songliste
{
	private Song[] songs;
	private int nummerAktueller; // Nummer des aktuellen Songs im Array
	private int anzahl; // der geladenen Programme
	private static int DEFAULT_MAXANZAHL = 1000; // Falls anzahl inkorrekt ist
	private String pfad = ""; // zu der Importierten Datei

	/**
	 * Konstruktor welcher das Array mit maxAnzahl initialisiert
	 * @param maxAnzahl, die groesse des Arrays, sprich die maximale Anzahl der Sings die abgespeichert werden koennen
	 */
	Songliste(int maxAnzahl) {
		DEFAULT_MAXANZAHL = maxAnzahl;
		songs = new Song[DEFAULT_MAXANZAHL];
		anzahl = 0;
		nummerAktueller = -1;
	}

	/**
	 * Importiert Songs aus einer .csv Datei. Der Pfad kann mit setPfad festgelegt
	 * werden
	 */
	public void lesenSongs() {
		// Ermittlung Anzahl der Songs
		try {
			anzahl = countLines(pfad);
		} catch (IOException e) {
			System.out.println("Fehler beim zaehlen der Zeilen");
		}

		// Lesen der Songs
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(pfad));
			try {
				for (int i = 0; i < anzahl; i++) {
					songs[i] = new Song();
					String tags = reader.readLine();
					songs[i].setSong(tags);
				}
			} catch (IOException e) {
				System.out.println("Fehler beim importieren der Songs");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fehler beim oeffnen der Datei");
		} catch (IOException e) {
			System.out.println("Fehler beim Schliessen der Datei");
		}
		System.out.println("Import fertig");
		nummerAktueller = 0;
	}
	
	/**
	 * Gibt den Index des aktuell ausgewaehlten Songs zurueck
	 * @return Nummer des aktuellen Songs
	 */
	public int getNummerAktueller() {
		return nummerAktueller;
	}

	/**
	 * Gibt die Anzahl der Songs zurück, die momentan im Array vorhanden sind
	 * @return die Anzahl der Songs die im Array momentan eingetragen sind
	 */
	public int getAnzahl() {
		return anzahl;
	}

	/**
	 * Liefert den aktuellen Song zurueck auf den der Songzeiger nummerAktueller
	 * zeigt
	 * 
	 * @return Liefert den aktuellen Song zurueck auf den der Songzeiger
	 *         nummerAktueller zeigt
	 */
	public Song getAktueller() {
		Song aktuellerSong = songs[nummerAktueller];
		return aktuellerSong;
	}

	/**
	 * Liefert den naechsten Song - falls vorhanden - zurueck und erhoeht den
	 * Songzeiger nummerAktueller um Eins. Gibt es keinen naechsten Song, wird null
	 * zurueck geliefert und der Songzeiger nicht erhoeht
	 * 
	 * @return naechster Song
	 */
	public Song getNaechster() {
		Song ret;
		if (songs[nummerAktueller + 1] != null) {
			ret = songs[nummerAktueller + 1];
			nummerAktueller++;
		} else {
			ret = null;
		}
		return ret;
	}

	/**
	 * Liefert den vorigen Song - falls vorhanden - zurueck und vermindert den
	 * Songzeiger um Eins. Gibt es keinen vorigen Song wird null zurueck geliefert
	 * und der Songzeiger nicht vermidert
	 * 
	 * @return den vorigen Song
	 */
	public Song getVoriger() {
		Song ret;
		if (songs[nummerAktueller - 1] != null && nummerAktueller > 0) {
			ret = songs[nummerAktueller - 1];
			nummerAktueller--;
		} else {
			ret = null;
		}
		return ret;
	}

	/**
	 * Liefert den ersten Song in der Songliste zurueck und setzt den Songzeiger auf
	 * diesen Song. Ist die Liste leer, wird null zurueck geliefert
	 * 
	 * @return den ersten Song in der Liste
	 */
	public Song getErster() {
		Song ret;
		if (songs != null && songs[0] != null) {
			ret = songs[0];
			nummerAktueller = 0;
		} else {
			ret = null;
		}
		return ret;
	}

	/**
	 * Liefert den letzten Song in der Songliste zurueck und setzt den Songzeiger auf
	 * diesen Song. Ist die Liste leer, wird null zurueck geliefert
	 * 
	 * @return den letzten Song
	 */
	public Song getLetzter() {
		Song ret;
		if (anzahl > 0)
			ret = songs[anzahl - 1];
		else
			ret = null;
		nummerAktueller = anzahl - 1;
		return ret;
	}

	/**
	 * @return Liest den Dateipfad aus
	 */
	public String getPfad() {
		return pfad;
	}

	/**
	 * @param Setzt den Dateipfad auf jene Datei aus welcher die Songs gelesen bzw. 
	 * in welche die Songs geschrieben werden soll
	 */
	public void setPfad(String pfad) {
		this.pfad = pfad;
	}

	/**
	 * Aendert den aktuellen Song auf den uebergebenen Song ab und sortiert ihn nicht
	 * ein
	 * 
	 * @param s der Song der die zu aendernden Werte enthaelt
	 * @return 0 falls die Aenderung erfolgreich durchgefuehrt werden konnte 
	 * 		  -1 falls kein zu aendernder Song uebergeben wurde 
	 *        -2 falls der aktuelle Song nicht bekannt ist
	 */
	public int aendernAktuellen(Song s) {
		if (true) {
			if (s != null) {
				if (nummerAktueller < 0)
					nummerAktueller = 0;
				songs[nummerAktueller] = s;
				return 0;
			} else
				return -1;
		} else
			return -2;
	}

	/**
	 * Traegt einen neuen Song am Ende der Songliste ein. Die Anzahl der Songs wird
	 * um Eins erhoeht und die nummerAktueller wird auf diesen Song gesetzt. Der Song
	 * wird nicht eingetragen, wenn im Array kein Platz mehr ist
	 * 
	 * @param s der einzutragende Song
	 * @return 0 falls das Eintragen erfolgreich war 
	 * 		  -1 falls kein einzutragender Song uebergeben wurde 
	 *        -2 falls die Songliste keinen Platz fuer einen weiteren Song hat
	 */
	public int anfuegenNeuen(Song s) {
		if (s != null) {
			if (anzahl < DEFAULT_MAXANZAHL) {
				if (anzahl < 0)
					anzahl = 0;
				songs[anzahl] = s;
				anzahl++;
				nummerAktueller = anzahl - 1;
				return 0;
			} else
				return -2;
		} else
			return -1;
	}

	/**
	 * Loescht den aktuellen Song aus der Liste. Dies kann nur passieren, wenn die
	 * Nummer des aktuellen Songs gesetzt ist. Da im Array eine Luecke entsteht,
	 * muessen alle nachfolgenden Songs um eine Stelle nach vorne geschoben werden.
	 * Der aktuelle Song wird jener Song der dem zu loeschenden Song folgt. Ist der
	 * zu loeschende Song der letzte Song in der Liste, so wird der aktuelle Song
	 * jener Song der vor dem zu loeschenden Song vorhanden ist. Ist der zu loeschende
	 * Song der einzige in der Liste, so wird die nummerAktueller auf -1 gesetzt.
	 * Beim Loeschen wird anzahl um Eins verringert
	 * 
	 * @return 0 falls das Loeschen erfolgreich durchgefuehrt werden konnte 
	 * 		  -1 falls der aktuelle Song noch nicht gesetzt wurde
	 */
	public int loeschenAktuellen() {
		if (songs[nummerAktueller] != null) {
			// Wenn letzter Song
			if (nummerAktueller == anzahl - 1) {
				songs[nummerAktueller] = null;
				nummerAktueller--;
			} else if (anzahl == 1) { // Wenn nur ein SOng uebrig ist
				songs[nummerAktueller] = null;
				nummerAktueller = -1;
			} else { // Default
				anzahl--;
				for (int i = nummerAktueller; i < songs.length - 1; i++) {
					songs[i] = songs[i + 1];
				}
				// songs[anzahl] = null;
				if (nummerAktueller > 0)
					nummerAktueller--;
			}
			return 0;

		} else
			return -1;
	}

	/**
	 * Loescht alle Songs aus der Liste. Setzt die Anzahl auf 0 und die Nummer des
	 * aktuellen Songs auf -1
	 * 
	 * @return 0 falls das Loeschen erfolgreich war 
	 * 		  -1 falls die Liste bereits leer ist
	 */
	public int loeschenAlle() {
		if (anzahl > 0) {
			for (int i = 0; i < anzahl; i++) {
				songs[i] = null;
			}
			nummerAktueller = -1;
			anzahl = 0;
			return 0;
		} else
			return -1;
	}

	/**
	 * Schreibt die Songs in die Textdatei. Dabei werden die in der Datei
	 * gespeicherten Songs geloescht.
	 * 
	 * @return 0 falls die Songs erfolgreich ein gefuegt werden konnten 
	 * 		  -1 falls der Pfad nicht gesetzt wurde 
	 *        -2 falls die Datei nicht angelegt werden konnte
	 */
	public int schreibenSongs() {
		if (anzahl > 1)
			Arrays.sort(songs, 0, anzahl);

		if (pfad != null && !pfad.isEmpty()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(pfad));
				// ACHTUNG: Am Ende jeder Zeile muss eine Zeilenschaltung \n eingefuegt werden
				// writer.write("Titel;Album;Interpret;Jahr\n");

				// Zeilenweises Ausgeben der einzelnen Songs
				for (int i = 0; i < songs.length; i++) {
					if (songs[i] != null) {
						String output = songs[i].toString() + "\n";
						writer.write(output);
					}
				}
				writer.close();
			} catch (IOException e) {
				System.out.println("Datei nicht angelegt");
				return -2;
			}
			return 0;
		} else {
			return -1;
		}
	}

	/**
	 * Kindly copied and modified from StackOverflow link:
	 * https://stackoverflow.com/a/18009472 gibt die Anzahl an Zeilen einer .csv
	 * zurueck.
	 * 
	 * @param filepath, zu der Datei, von der die Zeilen gezaehlt werden sollen
	 * @return die Anzahl der Zeilen
	 * @throws IOException
	 */
	public static int countLines(String filepath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
		String input;
		int count = 0;
		while ((input = bufferedReader.readLine()) != null) {
			count++;
		}

		// System.out.println("Count : "+count);
		bufferedReader.close();
		return count;
	}
}