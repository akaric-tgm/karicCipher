package karic.test;

import static org.junit.Assert.*;
import karic.cipher.MonoAlphabeticCipher;
import karic.cipher.MyException;
import karic.cipher.SubstitutionCipher;

import org.junit.Test;

public class CipherTest {

	@Test
	public void testKonstMono() {
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		if(!a.getSecretAlphabet().equals("abcdefghijklmnopqrstuvwxyzäöüß")){
			throw new RuntimeException("Fail Konstruktor MonoAlphabeticCipher");
		}
	}
	@Test
	public void testKonstSubst() throws MyException {
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjklöäümnbvx");
		if(!a.getSecretAlphabet().equals("1234567890asdfertghjklöäümnbvx")){
			throw new RuntimeException("Fail SubstKonstruktor");
		}
	}
	@Test(expected=MyException.class)
	public void testsetSecret() throws MyException {
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjklöäümnbvxaergagagresrgdgaegdgargaer");
	}
	@Test
	public void testEncrypt() throws MyException {
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjklöäümnbvx");
		String s=a.encrypt("Hallo ich bin Adin");
		if(!s.equals("81sse 938 29f 149f")){
			throw new RuntimeException("Fail Encrypt");
		}
	}
	@Test
	public void testDecrypt() throws MyException {
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjklöäümnbvx");
		String s=a.encrypt("Hallo ich bin Adin");
		if(!a.decrypt(s).equals("hallo ich bin adin")){
			throw new RuntimeException("Fail Decrypt");
		}
	}
	@Test
	public void testSetSubst() throws MyException {
		SubstitutionCipher a = new SubstitutionCipher("1234567890asdfertghjklöäümnbvx");
		a.setSecretAlphabet("qwertzuiopüasdfghjklöä#yxcvbnm");
		if(!a.getSecretAlphabet().equals("qwertzuiopüasdfghjklöä#yxcvbnm")){
			throw new RuntimeException("Fail Decrypt");
		}
	}

}
