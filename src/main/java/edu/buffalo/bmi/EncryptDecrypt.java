package edu.buffalo.bmi;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.*;

public class EncryptDecrypt {
	private String algorithm = "AES";
	private SecretKeySpec keySpec = null;
	private byte[] key = "Wydopqswrlmesf==".getBytes();

	private Cipher cipher = null;

	public EncryptDecrypt() throws NoSuchAlgorithmException,
			NoSuchPaddingException {
		cipher = Cipher.getInstance(algorithm);
		keySpec = new SecretKeySpec(key, algorithm);
	}

	public String decrypt(String encryptedPwd) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException, IOException {
		byte[] encryptionBytes = org.apache.commons.codec.binary.Base64
				.decodeBase64(encryptedPwd);
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
		String recovered = new String(recoveredBytes);
		return recovered;
	}

	public String encrypt(String password) throws InvalidKeyException,
			BadPaddingException, IllegalBlockSizeException {
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		byte[] inputBytes = password.getBytes();
		byte[] finalResult = org.apache.commons.codec.binary.Base64
				.encodeBase64(cipher.doFinal(inputBytes));
		String encryptedStr = new String(finalResult);
		return encryptedStr;

	}

}