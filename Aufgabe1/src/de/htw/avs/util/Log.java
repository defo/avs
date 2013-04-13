package de.htw.avs.util;

/**
 * @author: Sven Willrich, 534022
 * @author: defo
 * Date: 10.04.2013
 * Classname: Log.java
 * Veranstaltung: AVS Exercise
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

	public static void write(String msg) {
		if (isEnabled()) {
			System.out.println("LOG: " + msg);
		}
	}
}
