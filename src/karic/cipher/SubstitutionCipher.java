package karic.cipher;

public class SubstitutionCipher extends MonoAlphabeticCipher {
	
	public SubstitutionCipher(String secretAlphabet) throws MyException{
		super.setSecretAlphabet(secretAlphabet);
	}
	@Override
	public void setSecretAlphabet(String secretAlphabet) throws MyException{
		super.setSecretAlphabet(secretAlphabet);
	}
	
}
