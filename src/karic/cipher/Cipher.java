package karic.cipher;
/**
 * Das Cipher Interface mit den Methode encrypt und decrypt zum Verschl�sseln
 * @author Adin Karic
 * @version 2014-04-08
 *
 */
public interface Cipher {
	/**
	 * Die Methode encrypt die verschl�sselt
	 * @param text der uebergebene String zum Verschl�sseln
	 * @return der verschl�sselte String
	 */
	public String encrypt(String text);
	/**
	 * Die Methode decrypt die entschl�sselt
	 * @param text der uebergebene String zum Entschl�sseln
	 * @return der entschl�sselte String
	 */
	public String decrypt(String text);

}
