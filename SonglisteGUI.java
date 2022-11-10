package TeamArbeitSonglisteV3;

import javax.swing.*; // JFrame, JTextField, JButton, JLabel
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*; // Container
import java.awt.event.*; // Adapter, Listener, Events
import java.io.File;

/**
 * Klasse fuer die Darstellung eines Fensters, welches sich um die Interaktion mit dem Benutzer kuemmert.
 * @author Rafid Fallaha
 *
 * Hinweis: wenn die Auswahl der Datei uebersprungen wird, wird im Dokumentordner eine neue .csv Datei angelegt.
 */
public class SonglisteGUI extends JFrame
{

	// boolean zu darkmode
	public boolean isDarkModeActive = false;

	// alle Labels
	private JLabel labelTitel = null;
	private JLabel labelInterpret = null;
	private JLabel labelAlbum = null;
	private JLabel labelJahr = null;
	private JLabel labelDarkmode = null;
	private JLabel labelLightmode = null;

	// alle Textfelder
	private JTextField textfTitel = null;
	private JTextField textfInterpret = null;
	private JTextField textfAlbum = null;
	private JTextField textfJahr = null;

	// alle Buttons
	private JButton buttonErster = null;
	private JButton buttonVoriger = null;
	private JButton buttonNaechster = null;
	private JButton buttonLetzter = null;
	private JButton buttonNeu = null;
	private JButton buttonLoeschen = null;
	private JButton buttonLoeschenAlle = null;

	// Konstruktor fuer unsere GUI
	public SonglisteGUI(Songliste songliste) {
		setTitle("Songliste");
		setBounds(700, 400, 385, 255);
		
		//Ein Fenster, indem man eine Datei auswaehlen kann, hier wird der Speicherort fuer die Songs ausgewaehlt
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(getContentPane());

		// Wenn korrekte DateiAngabe, ansonsten Defaultwert (welcher der Dokumentordner ist)
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File inputOutputDatei = fileChooser.getSelectedFile();
			songliste.setPfad(inputOutputDatei.getAbsolutePath());
		} else
			songliste.setPfad(fileChooser.getFileSystemView().getDefaultDirectory().toString() + "\\Songliste.csv");
		songliste.lesenSongs();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelTitel = new JLabel("Titel:"); // Label fuer Titel
		labelTitel.setBounds(10, 10, 60, 30);
		labelInterpret = new JLabel("Interpret:"); // Label fuer Intepret
		labelInterpret.setBounds(10, 40, 60, 30);
		labelAlbum = new JLabel("Album:"); // Label fuer Album
		labelAlbum.setBounds(10, 70, 60, 30);
		labelJahr = new JLabel("Jahr:"); // Label fuer Jahr
		labelJahr.setBounds(10, 100, 60, 30);

		textfTitel = new JTextField(); // Textfeld fuer Titel
		textfTitel.setBounds(70, 15, 300, 25);
		textfInterpret = new JTextField(); // Textfeld fuer Interpret
		textfInterpret.setBounds(70, 45, 300, 25);
		textfAlbum = new JTextField(); // Textfeld fuer Album
		textfAlbum.setBounds(70, 75, 300, 25);
		textfJahr = new JTextField(); // Textfeld fuer Jahr
		textfJahr.setBounds(70, 105, 60, 25);

		buttonErster = new JButton(); // Button fuer Erster
		buttonErster.setText("Erster");
		buttonErster.setBounds(10, 140, 91, 35);
		buttonVoriger = new JButton(); // Button fuer voriger
		buttonVoriger.setText("Voriger");
		buttonVoriger.setBounds(100, 140, 91, 35);
		buttonNaechster = new JButton(); // Button fuer naechster
		buttonNaechster.setText("Noechster");
		buttonNaechster.setBounds(190, 140, 91, 35);
		buttonLetzter = new JButton(); // Button fuer letzter
		buttonLetzter.setText("Letzter");
		buttonLetzter.setBounds(280, 140, 91, 35);
		buttonNeu = new JButton(); // Button fuer neu
		buttonNeu.setText("Neu");
		buttonNeu.setBounds(10, 175, 111, 35);
		buttonLoeschen = new JButton(); // Button fuer loeschen
		buttonLoeschen.setText("Loeschen");
		buttonLoeschen.setBounds(121, 175, 126, 35);
		buttonLoeschenAlle = new JButton(); // Button fuer alle loeschen
		buttonLoeschenAlle.setText("Alle loeschen");
		buttonLoeschenAlle.setBounds(247, 175, 124, 35);

		// Neues Button fuer unsere Wunderschoene DarkMode
		JButton buttonDarkmode = new JButton();
		buttonDarkmode.setBounds(340, 105, 30, 30);

		// Icon fuer das darkmode
		ImageIcon darkmode = new ImageIcon(getClass().getResource("dark.jpg"));
		labelDarkmode = new JLabel();
		labelDarkmode.setIcon(darkmode);
		labelDarkmode.setBounds(270, 105, 30, 30);

		// Icon fuer das lightmode
		ImageIcon lightmode = new ImageIcon(getClass().getResource("light.jpg"));
		labelLightmode = new JLabel();
		labelLightmode.setIcon(lightmode);
		labelLightmode.setBounds(300, 105, 30, 30);

		// ActionListener fuer Darkmode
		buttonDarkmode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color lightModeColor = new Color(255, 255, 255);
				Color darkModeColor = new Color(28, 31, 34);
				if (isDarkModeActive) {
					buttonDarkmode.setBackground(lightModeColor);
					textfTitel.setBackground(lightModeColor);
					textfTitel.setForeground(darkModeColor);
					textfInterpret.setBackground(lightModeColor);
					textfInterpret.setForeground(darkModeColor);
					textfAlbum.setBackground(lightModeColor);
					textfAlbum.setForeground(darkModeColor);
					textfJahr.setBackground(lightModeColor);
					textfJahr.setForeground(darkModeColor);

					buttonErster.setBackground(lightModeColor);
					buttonErster.setForeground(darkModeColor);
					buttonVoriger.setBackground(lightModeColor);
					buttonVoriger.setForeground(darkModeColor);
					buttonNaechster.setBackground(lightModeColor);
					buttonNaechster.setForeground(darkModeColor);
					buttonLetzter.setBackground(lightModeColor);
					buttonLetzter.setForeground(darkModeColor);
					buttonNeu.setBackground(lightModeColor);
					buttonNeu.setForeground(darkModeColor);
					buttonLoeschen.setBackground(lightModeColor);
					buttonLoeschen.setForeground(darkModeColor);
					buttonLoeschenAlle.setBackground(lightModeColor);
					buttonLoeschenAlle.setForeground(darkModeColor);

					getContentPane().setBackground(lightModeColor);
					labelTitel.setForeground(darkModeColor);
					labelInterpret.setForeground(darkModeColor);
					labelAlbum.setForeground(darkModeColor);
					labelJahr.setForeground(darkModeColor);

					isDarkModeActive = false;
				} else {

					buttonDarkmode.setBackground(darkModeColor);
					textfTitel.setBackground(darkModeColor);
					textfTitel.setForeground(lightModeColor);
					textfInterpret.setBackground(darkModeColor);
					textfInterpret.setForeground(lightModeColor);
					textfAlbum.setBackground(darkModeColor);
					textfAlbum.setForeground(lightModeColor);
					textfJahr.setBackground(darkModeColor);
					textfJahr.setForeground(lightModeColor);

					buttonErster.setBackground(darkModeColor);
					buttonErster.setForeground(lightModeColor);
					buttonVoriger.setBackground(darkModeColor);
					buttonVoriger.setForeground(lightModeColor);
					buttonNaechster.setBackground(darkModeColor);
					buttonNaechster.setForeground(lightModeColor);
					buttonLetzter.setBackground(darkModeColor);
					buttonLetzter.setForeground(lightModeColor);
					buttonNeu.setBackground(darkModeColor);
					buttonNeu.setForeground(lightModeColor);
					buttonLoeschen.setBackground(darkModeColor);
					buttonLoeschen.setForeground(lightModeColor);
					buttonLoeschenAlle.setBackground(darkModeColor);
					buttonLoeschenAlle.setForeground(lightModeColor);

					getContentPane().setBackground(darkModeColor);
					labelTitel.setForeground(lightModeColor);
					labelInterpret.setForeground(lightModeColor);
					labelAlbum.setForeground(lightModeColor);
					labelJahr.setForeground(lightModeColor);

					isDarkModeActive = true;
				}
			}
		});

		Container contentPane = // Komponenten zum Fenster fuegen
				getContentPane();
		contentPane.setLayout(null);
		// add Label
		contentPane.add(labelTitel);
		contentPane.add(labelInterpret);
		contentPane.add(labelAlbum);
		contentPane.add(labelJahr);
		contentPane.add(labelDarkmode);
		contentPane.add(labelLightmode);

		// add TextField
		contentPane.add(textfTitel);
		contentPane.add(textfInterpret);
		contentPane.add(textfAlbum);
		contentPane.add(textfJahr);
		// add Button
		contentPane.add(buttonErster);
		contentPane.add(buttonVoriger);
		contentPane.add(buttonNaechster);
		contentPane.add(buttonLetzter);
		contentPane.add(buttonNeu);
		contentPane.add(buttonLoeschen);
		contentPane.add(buttonLoeschenAlle);
		contentPane.add(buttonDarkmode);
		// wir wollen, dass es nicht Resizable ist
		setResizable(false);
		setVisible(true);

		// Speichert die Aenderungen ab, wenn das Fenster geschlossen wird
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				saveChanges(songliste);
				songliste.schreibenSongs();
			}
		});

		// Actionlistener fuer den Button Erster, was wenn man am Anfang ankommt eine
		// Meldung Zeigt und klaert, dass man am Anfang ist
		buttonErster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveChanges(songliste);
				Song aktuellerSong = songliste.getAktueller();
				if (aktuellerSong.equals(songliste.getErster())) {
					JOptionPane.showMessageDialog(getContentPane(), "Am Anfang angekommen");
				} else {
					aktuellerSong = songliste.getErster();
					songAnzeigen(aktuellerSong);
				}
			}
		});

		// Actionlistener fuer den Button Voriger, was wenn man am Anfang ankommt eine
		// Meldung Zeigt und klaert, dass man am Anfang ist
		buttonVoriger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveChanges(songliste);
				if (songliste.getNummerAktueller() < 1) {
					JOptionPane.showMessageDialog(getContentPane(), "Am Anfang angekommen");
				} else {
					Song aktuellerSong = songliste.getVoriger();
					songAnzeigen(aktuellerSong);
				}
			}
		});

		// Actionlistener fuer den Button Naechster, was wenn man am Ende ankommt eine
		// Meldung Zeigt und klaert, dass man am Ende ist
		buttonNaechster.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				saveChanges(songliste);
				Song aktuellerSong;
				if ((aktuellerSong = songliste.getNaechster()) == null) {
					JOptionPane.showMessageDialog(getContentPane(), "Am Ende angekommen");
				} else {
					songAnzeigen(aktuellerSong);
				}
			}
		});

		// Actionlistener fuer den Button Letzter, was wenn man am Ende ankommt eine
		// Meldung Zeigt und klaert, dass man am Ende it
		buttonLetzter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveChanges(songliste);
				Song aktuellerSong = songliste.getAktueller();
				if (aktuellerSong.equals(songliste.getLetzter())) {
					JOptionPane.showMessageDialog(getContentPane(), "Am Ende angekommen");
				} else {
					aktuellerSong = songliste.getLetzter();
					songAnzeigen(aktuellerSong);
				}
			}
		});

		// ActionListener fuer den Button Neu, es erstellt ein Neues Track und es wird
		// dann am Ende der Liste hingefuegt
		buttonNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Song aktuellerSong = null;
					aktuellerSong = new Song();
					songliste.anfuegenNeuen(aktuellerSong);
					songAnzeigen(aktuellerSong);
				} catch (Exception e2) {

				}
			}
		});
		// ActionListener fuer den Button loeschenAktuellen, es loescht wenn man auf ein
		// Track ist und es mit einer Meldung fragt ob wir es wirklich machen wollen
		buttonLoeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getContentPane(), "Diesen Track wirklich loeschen?", "Track Loeschen",
						JOptionPane.YES_NO_OPTION) == (JOptionPane.YES_OPTION)) {
					songliste.loeschenAktuellen();
					songAnzeigen(songliste.getAktueller());
				}
			}
		});

		// ActionListener fuer den Button loeschenAlle, was Alle Tracks loescht und es mit
		// einer Meldung fragt ob wir es wirklich machen wollen
		buttonLoeschenAlle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(getContentPane(), "Wirklich alle Tracks loeschen?", "rm -rf /*.mp3",
						JOptionPane.YES_NO_OPTION) == (JOptionPane.YES_OPTION)) {
					songliste.loeschenAlle();
					songAnzeigen(null);
				}
			}
		});

	}

	// Methode fuer das Speichern der Aenderungen unserer Liste. Es kontrolliert auch,
	// dass wenn wir im TextFeld Jahr schreiben, wir eine Ganzzahl geschrieben haben
	// oder nicht. Wenn nein, dann kriegen wir eine Meldung.
	private void saveChanges(Songliste songliste) {
		try {
			Song aktuellerSong = new Song(textfTitel.getText(), textfInterpret.getText(), textfAlbum.getText(),
					Integer.parseInt(textfJahr.getText()));
			songliste.aendernAktuellen(aktuellerSong);
		} catch (NumberFormatException e) {
//			textfJahr.setText("Muss eine Ganzzahl sein!");
			JOptionPane.showMessageDialog(getContentPane(), "Nur Ganzzahl sind gueltig; Aenderung nicht gespeichert");
		}
	}

	// Methode fuer das Zeigen unserer Tracks aus der DatenBank
	public void songAnzeigen(Song s) {
		if (s != null) {
			textfTitel.setText(s.getTitel());
			textfInterpret.setText(s.getInterpret());
			textfAlbum.setText(s.getAlbum());
			textfJahr.setText(String.valueOf(s.getErscheinungsjahr()));
		} else {
			textfTitel.setText("");
			textfInterpret.setText("");
			textfAlbum.setText("");
			textfJahr.setText("");
		}
	}
}
