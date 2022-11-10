package TeamArbeitSonglisteV3;

/**
 * Hauptprogramm fuer die TeamArbeitSongliste. Wir haben das mit Liebe gemacht
 * und etwas unseres hinzugefuegt. (optionaler Darkmode und Auswahlfenster fuer die Datei)
 * 
 * @author Rafid Fallaha(GUI) und Raphael Siller(Songliste)
 */
public class SonglisteHauptprogramm
{

	public static void main(String[] args) {
		Songliste songliste = new Songliste(1000);
		SonglisteGUI gui = new SonglisteGUI(songliste);
		Song aktuellerSong = null;
		// Nicht mehr gebraucht, da bei Start die Datei ausgewaehlt werden muss
		// songliste.setPfad("C:\\Users\\unico\\Info\\Work\\TeamArbeitSongliste\\src\\TeamArbeitSongliste\\tracklist.csv");
		// songliste.setPfad("D:\\Songliste.csv");
		// songliste.lesenSongs();
		aktuellerSong = songliste.getAktueller();
		gui.songAnzeigen(aktuellerSong);

	}
}
