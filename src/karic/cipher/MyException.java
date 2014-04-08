package karic.cipher;

import java.io.IOException;
/**
 * Eigene Exceptionklasse f�r Inputfehler des Benutzers
 * @author Adin Karic
 * @version 2014-04-08
 *
 */
public class MyException extends IOException {
	/**
	 * Konstruktor dem ein String als Fehlermeldung �bergeben wird
	 * @param s die Fehlermeldung als String
	 */
	public MyException(String s){
		//Konstruktor der Superklasse wird aufgerufen
		super(s);
	}

}
