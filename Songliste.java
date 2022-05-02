package TeamArbeitSongliste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Songliste {
	private Song[] songs;
	private int nummerAktueller; //Nummer des aktuellen Songs im Array
	private int anzahl;	//der geladenen Programme
	private static int DEFAULT_MAXANZAHL = 1000; //Falls anzahl inkorrekt ist
	private String pfad = "D:\\Songliste.csv"; //zu der Importierten Datei
	
	Songliste() {
		songs = new Song[DEFAULT_MAXANZAHL];
		anzahl = 0;
		nummerAktueller = -1;
	}
	/**
	 * Importiert Songs aus einer .csv Datei. Der Pfad kann mit setPfad festgelegt werden
	 */
	public void lesenSongs() {
		//Ermittlung Anzahl der Songs
		try {
			anzahl = countLines(pfad) -1;
		} catch (IOException e) {
			System.out.println("Fehler beim zaehlen der Zeilen");
		}
		
		//Lesen der Songs
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(pfad));
			try {
				reader.readLine();
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
		
		
		
	}
	
	
	
	/**
	 * @return Liest den Dateipfad aus
	 */
	public String getPfad() {
		return pfad;
	}

	/**
	 * @param Setzt den Dateipfad auf jene Datei aus welcher die Songs gelesen bzw. in
	 *            welche die Songs geschrieben werden soll
	 */
	public void setPfad(String pfad) {
		this.pfad = pfad;
	}
	
	/**
	 * Ändert den aktuellen Song auf den übergebenen Song ab und sortiert ihn nicht ein
	 * @param s der Song der die zu ändernden Werte enthält
	 * @return 0 falls die Änderung erfolgreich durchgeführt werden konnte 
	 * 		  -1 falls kein zu ändernder Song übergeben wurde
	 *  	  -2 falls der aktuelle Song nicht bekannt ist
	 */
	int aendernAktuellen(Song s) {
		if(s != null) {
			if(songs[nummerAktueller] != null) {
				songs[nummerAktueller] = s;
				return 0;
			} else
				return -1;
		} else
			return -2;
	}
	
	
	/**
	 * Kindly copied and modified from StackOverflow link: https://stackoverflow.com/a/18009472
	 * gibt die Anzahl an Zeilen einer .csv zurueck.
	 * @param filepath, zu der Datei, von der die Zeilen gezaehlt werden sollen
	 * @return die Anzahl der Zeilen
	 * @throws IOException
	 */
	public static int countLines(String filepath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
	     String input;
	     int count = 0;
	     while((input = bufferedReader.readLine()) != null)
	     {
	         count++;
	     }

//	     System.out.println("Count : "+count);
	     bufferedReader.close();
	     return count;
	}
	
}
