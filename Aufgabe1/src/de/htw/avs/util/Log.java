package de.htw.avs.util;

/**
 * @author: Sven Willrich, 534022
 * @author: defo Bienvenue,534195
 * Date: 10.04.2013
 * Classname: Log.java
 * Veranstaltung: AVS Exercise
 * Descritpion: This class is in charge of logging
 */

public class Log {

	private static boolean isEnabled = true;

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public static void setEnabled(boolean isEnabled) {
		Log.isEnabled = isEnabled;
	}

	/**
	 * @return the isEnabled
	 */
	public static boolean isEnabled() {
		return isEnabled;
	}
	/**
	 * @param msg the message
	 * /

	public static void write(String msg) {
		if (isEnabled()) {
			System.out.println("*** LOG: " + msg + " ***");
		}
	}
}
