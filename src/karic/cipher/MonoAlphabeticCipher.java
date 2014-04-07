
package karic.cipher;

public class MonoAlphabeticCipher implements Cipher {
	private String secretAlphabet;
	
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	//Exception werfen!!
	protected void setSecretAlphabet(String text) {
		if(text.length()==30){
			this.secretAlphabet=text;
		}
	}
	@Override
	public String encrypt(String text) {
		String klar="abcdefghijklmnopqrstuvwxyzäöüß";
		String versch="";
		boolean wf;
		for(int i = 0;i<text.length();i++){
			wf=true;
			for(int j = 0;j<klar.length();j++){
				if(text.toLowerCase().charAt(i)==klar.charAt(j)){
					versch+=this.secretAlphabet.toLowerCase().charAt(j);
					wf=false;
				}
			}
			if(wf){
				versch+=text.charAt(i);
				wf=false;
			}
		}
		return versch;
		
	}
	@Override
	public String decrypt(String text) {
		String klar="abcdefghijklmnopqrstuvwxyzäöüß";
		String entsch="";
		boolean wf;
		for(int i = 0;i<text.length();i++){
			wf=true;
			for(int j = 0;j<klar.length();j++){
				if(text.toLowerCase().charAt(i)==this.secretAlphabet.toLowerCase().charAt(j)){
					entsch+=klar.charAt(j);
					wf=false;
				}
			}
			if(wf){
				entsch+=text.charAt(i);
				wf=false;
			}
		}
		return entsch;
	}
}



