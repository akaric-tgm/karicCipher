
package karic.cipher;
/**
 * Die Superklasse in der die Methoden encrypt und decrypt vom Interface Cipher implementiert und �berschrieben werden
 * @author Adin Karic
 * @version 2014-04-08
 *
 */
public class MonoAlphabeticCipher implements Cipher {
	// das geheimalphabet
	private String secretAlphabet;
	/**
	 * Der Konstruktor der das geheimalphabet auf das klaralphabet setzt(also noch keine Verschl�sselung)
	 */
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyz����";
	}
	/**
	 * getter Methode f�r das secretAlphabet
	 * @return das secretalphabet als String
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	/**
	 * Settermethode f�r das secretAlphabet
	 * @param text das neue secretAlphabet
	 * @throws MyException
	 */
	protected void setSecretAlphabet(String text) throws MyException {
		//wenn das neue secretalphabet 30 zeichen hat
		if(text.length()==30){
			this.secretAlphabet=text;
			//ansonsten wird eine MyException geworfen
		}else{
			throw new MyException("Bitte einen gueltigen Wert eingeben");
		}
	}
	/**
	 * Die encrypt Methode die �berschrieben wird und zum Verschl�sseln dient
	 * @param text den Text den man verschl�sseln will
	 * @return der verschl�sselte String
	 */
	@Override
	public String encrypt(String text) {
		//Klaralphabet
		String klar="abcdefghijklmnopqrstuvwxyz����";
		String versch="";
		boolean wf;
		//solange i kleiner als die L�nge des zu verschl�sselnden Textes
		for(int i = 0;i<text.length();i++){
			wf=true;
			//solange j kleiner als die L�nge des Klartextes
			for(int j = 0;j<klar.length();j++){
				//wenn das Zeichen an i von text gleich dem Zeichen an i von klar
				//dann wird versch um das zeichen an i von secretAlphabet erweitert
				if(text.toLowerCase().charAt(i)==klar.charAt(j)){
					versch+=this.secretAlphabet.toLowerCase().charAt(j);
					wf=false;
				}
			}
			//Falls das Zeichen nicht im Klaralphabet enthalten ist wird es beibehalten
			if(wf){
				versch+=text.charAt(i);
				wf=false;
			}
		}
		//der verschl�sselte String wird zur�ckgegeben
		return versch;
		
	}
	/**
	 * Die methode decrypt zum entschl�sseln
	 * @param text der zu entschl�sselnde Text
	 * @return der entschl�sselte String
	 */
	@Override
	public String decrypt(String text) {
		//Klaralphabet
		String klar="abcdefghijklmnopqrstuvwxyz����";
		String entsch="";
		boolean wf;
		//solange i kleiner als die L�nge des zu entschl�sselnden Textes
		for(int i = 0;i<text.length();i++){
			wf=true;
			//solange j kleiner als die L�nge des Klartextes
			for(int j = 0;j<klar.length();j++){
				//wenn das Zeichen an i von text gleich dem Zeichen an i von secretAlphabet
				//dann wird versch um das zeichen an i von klar erweitert
				if(text.toLowerCase().charAt(i)==this.secretAlphabet.toLowerCase().charAt(j)){
					entsch+=klar.charAt(j);
					wf=false;
				}
			}
			//Falls das Zeichen nicht im secretAlphabet enthalten ist wird es beibehalten
			if(wf){
				entsch+=text.charAt(i);
				wf=false;
			}
		}
		//der entschl�sselte String wird zur�ckgegeben
		return entsch;
	}
}



