package TeamArbeitSongliste;

public class Song {
	private String titel = "";
	private String interpret = "";
	private String album = "";
	private int erscheinungsjahr = 0;

	/**
	 * @return titel des Liedes
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * @param titel
	 *            des Liedes
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	 * @return interpret des Liedes
	 */
	public String getInterpret() {
		return interpret;
	}

	/**
	 * @param interpret
	 *            des Liedes
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	/**
	 * @return album des Liedes
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album
	 *            des Liedes
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * @return erscheinungsjahr des Liedes
	 */
	public int getErscheinungsjahr() {
		return erscheinungsjahr;
	}

	/**
	 * Das Erscheinungsjahr darf nicht negativ sein
	 * 
	 * @param erscheinungsjahr
	 *            des Liedes
	 */
	public void setErscheinungsjahr(int erscheinungsjahr) {
		if (erscheinungsjahr >= 0)
			this.erscheinungsjahr = erscheinungsjahr;
	}

	/**
	 * Vergleicht, ob der uebergebenen Song mit dem derzeitigen Song übereinstimmt.
	 * Es wird mit der Methode equals der Klasse String vergleicht.
	 * 
	 * @param song1
	 * @return true, wenn alle Membervariablen uebereinstimmen, ansonsten false;
	 */
	public boolean equals(Song song1) {
		boolean ret = false;
		if (song1.titel.equals(this.titel))
			if (song1.interpret.equals(this.interpret))
				if (song1.album.equals(this.album))
					if (song1.erscheinungsjahr == this.erscheinungsjahr)
						ret = true;
		return ret;
	}

	/**
	 * Vergleicht titel, Interpret, Album, Erscheinungsjahr in dieser Reihenfolge.
	 * Verglichen wird alphabetisch, d.h. a ist kleiner als b.
	 * 
	 * @param song1
	 *            - das zu vergleichende Objekt
	 * @return -1 falls der Song kleiner als der Song ist; 0 falls der Song gleich dem uebergebenen Song ist; 1 falls der Song groesser als der uebergebene Song ist
	 */
	public int compareTo(Song song1) {
		int ret = 0;
		// Kontrolle Titel
		for (int i = 0; i < this.titel.length() && i < song1.titel.length(); i++) {
			if (this.titel.charAt(i) != song1.titel.charAt(i)) {
				ret = (this.titel.charAt(i) - song1.titel.charAt(i) > 0) ? 1 : -1;
				i = this.titel.length();
			}
		}

		// Kontrolle interpret
		if (ret == 0) {
			for (int i = 0; i < this.interpret.length() && i < song1.interpret.length(); i++) {
				if (this.interpret.charAt(i) != song1.interpret.charAt(i)) {
					ret = (this.interpret.charAt(i) - song1.interpret.charAt(i) > 0) ? 1 : -1;
					i = this.interpret.length();
				}
			}
			// Kontrolle album
			if (ret == 0) {
				for (int i = 0; i < this.album.length() && i < song1.album.length(); i++) {
					if (this.album.charAt(i) != song1.album.charAt(i)) {
						ret = (this.album.charAt(i) - song1.album.charAt(i) > 0) ? 1 : -1;
						i = this.album.length();
					}
				}
				// Kontrolle erscheinungsjahr
				if (ret == 0) {
					ret = (this.erscheinungsjahr - song1.erscheinungsjahr > 0) ? 1 : -1;
				}
			}
		}
		return ret;
	}

	/**
	 * Erstellt ein neues Objekt Song und fuellt es mit den Werten von diesem Song
	 * 
	 * @return ein neues Objekt mit den gleichen Membervariablen wie diesen Song
	 */
	public Song clone() {
		Song ret = new Song();

		ret.titel = this.titel;
		ret.interpret = this.interpret;
		ret.album = this.album;
		ret.erscheinungsjahr = this.erscheinungsjahr;

		return ret;
	}

	/**
	 * gibt den titel, Album, Interpret, Erscheinungsjahr in dieser Reihenfolge als
	 * String zurueck. Sie werden mit einem Semicolon getrennt.
	 * 
	 * @return ret, ein String in der Form titel;album;interpret;erscheinungsjahr
	 */
	public String toString() {
		String ret = this.titel + ";" + this.album + ";" + this.interpret + ";" + this.erscheinungsjahr;

		return ret;
	}
	
	/**
	 * 
	 * @param tags
	 */
	public void setSong(String tags) {
		int SemiColonIndex1 = tags.indexOf(';');
		int SemiColonIndex2 = tags.indexOf(';', SemiColonIndex1+1);
		int SemiColonIndex3 = tags.indexOf(';', SemiColonIndex2+1);
		
		this.titel = tags.substring(0, SemiColonIndex1);
		this.album = tags.substring(SemiColonIndex1+1, SemiColonIndex2);
		this.interpret = tags.substring(SemiColonIndex2+1, SemiColonIndex3);
		
		this.erscheinungsjahr = 0;
		for (int i = SemiColonIndex3+1; i < tags.length(); i++) {
			this.erscheinungsjahr = this.erscheinungsjahr *10 +tags.charAt(i) - '0';
//			System.out.println(this.erscheinungsjahr);
		}
		
		//System.out.println("DebugPoint");
	}
}
