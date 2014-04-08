package karic.test;

import static org.junit.Assert.*;
import karic.cipher.MonoAlphabeticCipher;
import karic.cipher.MyException;
import karic.cipher.SubstitutionCipher;

import org.junit.Test;
/**
 * JUnit-Testklasse zum Testen der Cipherklassen
 * @author Adin Karic
 * @version 2014-04-08
 */
public class CipherTest {
	/**
	 * Testet den Konstruktor der MonoAlphabeticCipher-Klasse
	 */
	@Test
	public void testKonstMono() {
		//Objekt wird erzeugt
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		//wenn das secretAlphabet nicht dem schon vorher definierten entspricht wird eine
		//RuntimeException geworfen
		if(!a.getSecretAlphabet().equals("abcdefghijklmnopqrstuvwxyz����")){
			throw new RuntimeException("Fail Konstruktor MonoAlphabeticCipher");
		}
	}
	/**
	 * Testet den Konstruktor der SubstitutionCipher-Klasse
	 */
	@Test
	public void testKonstSubst() throws MyException {
		//Objekt wird erzeugt
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjkl���mnbvx");
		//wenn das secretAlphabet nicht dem im Parameter �bergebenen entspricht wird eine
		//RuntimeException geworfen
		if(!a.getSecretAlphabet().equals("1234567890asdfertghjkl���mnbvx")){
			throw new RuntimeException("Fail SubstKonstruktor");
		}
	}
	/**
	 * Testet die setter-Methode im substitioncipher konstruktor, es wird eine MyException erwartet
	 */
	@Test(expected=MyException.class)
	public void testsetSecret() throws MyException {
		//fehlerhafter Parameter, deswegen wird eine MyException geworfen
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjkl���mnbvxaergagagresrgdgaegdgargaer");
	}
	/**
	 * Testet die encrypt Methode
	 */
	@Test
	public void testEncrypt() throws MyException {
		//Objekt mit secretAlphabet wird erzeugt
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjkl���mnbvx");
		//Text wird verschl�sselt
		String s=a.encrypt("Hallo ich bin Adin");
		//wenn der verschl�sselte Text nicht dem durch vorige Tests definierten verschl�sselten Text gleicht wird eine RuntimeException geworfen
		if(!s.equals("81sse 938 29f 149f")){
			throw new RuntimeException("Fail Encrypt");
		}
	}
	/**
	 * Testet die decrypt methode
	 */
	@Test
	public void testDecrypt() throws MyException {
		//Objekt mit secretAlphabet wird erzeugt
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjkl���mnbvx");
		String s=a.encrypt("Hallo ich bin Adin");
		//wenn der entschl�sselte Text nicht dem durch vorige Tests definierten entschl�sselten Text gleicht wird eine RuntimeException geworfen
		if(!a.decrypt(s).equals("hallo ich bin adin")){
			throw new RuntimeException("Fail Decrypt");
		}
	}
	/**
	 * Testet die setSecretAlphabet-Methode der SubstitutionCipher Klasse
	 */
	@Test
	public void testSetSubst() throws MyException {
		//Objekt mit secretAlphabet wird erzeugt
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjkl���mnbvx");
		//neues secretAlphabet wird gesetzt
		a.setSecretAlphabet("qwertzuiop�asdfghjkl��#yxcvbnm");
		// wenn das durch getterMethoden erhaltene geheimalphabet nicht dem vorher gesetzten entspricht wird eine RuntimeException geworfen
		if(!a.getSecretAlphabet().equals("qwertzuiop�asdfghjkl��#yxcvbnm")){
			throw new RuntimeException("Fail setSubst");
		}
	}

}
