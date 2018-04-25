package edu.buffalo.bmi;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class Crypto {

	static String mPassword = null;
	public final static int SALT_LEN = 8;
//	byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//	byte[] mInitVec = null;
//	byte[] mInitVec =  new byte[16];
//	byte[] mSalt = null;
//	byte[] password = null;
	private Cipher mEcipher;
	private Cipher mDecipher;

	/**
	 * create an object with just the passphrase from the user. Don't do
	 * anything else yet
	 * 
	 * @param password
	 */
	public Crypto(String password) {
		mPassword = password;
	}

	/**
	 * return the generated salt for this object
	 * 
	 * @return
	 */
//	public byte[] getSalt() {
//		return (mSalt);
//	}

	/**
	 * return the initialization vector created from setupEncryption
	 * 
	 * @return
	 */
//	public byte[] getInitVec() {
//		return (mInitVec);
//	}

	/**
	 * debug/print messages
	 * 
	 * @param msg
	 */
	private void Db(String msg) {
		System.out.println("** Crypt ** " + msg);
	}

	/**
	 * this must be called after creating the initial Crypto object. It creates
	 * a salt of SALT_LEN bytes and generates the salt bytes using
	 * secureRandom(). The encryption secret key is created along with the
	 * initialization vectory. The member variable mEcipher is created to be
	 * used by the class later on when either creating a CipherOutputStream, or
	 * encrypting a buffer to be written to disk.
	 * 
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidParameterSpecException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException 
	 */
	//public String setupEncrypt(String mPassword)
	public ArrayList setupEncrypt(String mPassword)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidParameterSpecException,
			IllegalBlockSizeException, BadPaddingException,
			UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException{
		SecretKeyFactory factory = null;
		SecretKey tmp = null;
		ArrayList encryptedStrings = new ArrayList(); 
		
		// crate secureRandom salt and store as member var for later use
		byte[] mSalt = new byte[SALT_LEN];
				
		byte[] password = null;
		
		
		SecureRandom rnd = new SecureRandom();
		rnd.nextBytes(mSalt);
//		Db("generated salt :" + Hex.encodeHexString(mSalt));
//		encryptedStrings.add(Hex.encodeHexString(mSalt));
		Db("generated salt :" + new String(mSalt,"UTF-8"));
		encryptedStrings.add(new String(mSalt,"UTF-8"));

		factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		/*
		 * Derive the key, given password and salt.
		 */
		 KeySpec spec = new PBEKeySpec (mPassword.toCharArray (), mSalt,
		 65536, 128);
//		KeySpec spec = new PBEKeySpec(mPassword.toCharArray(), mSalt, 65536,
//				256);
		tmp = factory.generateSecret(spec);
		SecretKey secret = new SecretKeySpec(tmp.getEncoded(), "AES");

		try {
			Field field = Class.forName("javax.crypto.JceSecurity")
					.getDeclaredField("isRestricted");
			field.setAccessible(true);
			field.set(null, java.lang.Boolean.FALSE);
		} catch (Exception ex) {

		}

		/*
		 * Create the Encryption cipher object and store as a member variable
		 */
		mEcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//		mEcipher = Cipher.getInstance("AES/CBC/NoPadding");
//		mEcipher.init(Cipher.ENCRYPT_MODE, secret);
		byte[] mInitVec =  new byte[mEcipher.getBlockSize()];
		IvParameterSpec ivspec = new IvParameterSpec(mInitVec);
		mEcipher.init(Cipher.ENCRYPT_MODE, secret, ivspec);
		AlgorithmParameters params = mEcipher.getParameters();

		// get the initialization vectory and store as member var
//		mInitVec = params.getParameterSpec(IvParameterSpec.class).getIV();

//		Db("mInitVec is :" + Hex.encodeHexString(mInitVec));
//		encryptedStrings.add(Hex.encodeHexString(mInitVec));
		
		Db("mInitVec is :" + new String(mInitVec,"UTF-8"));
		encryptedStrings.add(new String(mInitVec,"UTF-8"));
		
//		byte[] encrypted = mEcipher.doFinal(mPassword.getBytes());
//		System.out.println("encrypted string:" + Hex.encodeHexString(encrypted));
		
		byte[] encrypted = mEcipher.doFinal(mPassword.getBytes("UTF-8"));
//		System.out.println("encrypted string:" + Hex.encodeHexString(encrypted));
		System.out.println("encrypted string:" + new String(encrypted,"UTF-8"));
		
//		byte[] encrypted = mEcipher.doFinal(mPassword.getBytes());
//		System.out
//		.println("encrypted string:" + Hex.encodeHex(encrypted));

//		encryptedStrings.add(Hex.encodeHexString(encrypted));
		encryptedStrings.add(new String(encrypted,"UTF-8"));
//		encryptedStrings.add(Hex..encodeHex(encrypted));
		//return Hex.encodeHexString(encrypted);
		return encryptedStrings;

	}

	/**
	 * If a file is being decrypted, we need to know the pasword, the salt and
	 * the initialization vector (iv). We have the password from initializing
	 * the class. pass the iv and salt here which is obtained when encrypting
	 * the file initially.
	 * 
	 * @param initvec
	 * @param salt
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidAlgorithmParameterException
	 * @throws DecoderException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws UnsupportedEncodingException 
	 */
	public String setupDecrypt(String initvec, String salt, String encrypted)
			throws NoSuchAlgorithmException, InvalidKeySpecException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, DecoderException,
			IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		SecretKeyFactory factory = null;
		SecretKey tmp = null;
		SecretKey secret = null;
		byte[] mSalt = new byte[8];
		byte[] password = null;


		// since we pass it as a string of input, convert to a actual byte
		// buffer here
//		mSalt = Hex.decodeHex(salt.toCharArray());
//		Db("got salt " + Hex.encodeHexString(mSalt));
		
		mSalt = salt.getBytes("UTF-8");
		Db("got salt " + new String(mSalt,"UTF-8"));

		// get initialization vector from passed string
//		mInitVec = Hex.decodeHex(initvec.toCharArray());
//		Db("got initvector :" + Hex.encodeHexString(mInitVec));
		
		
		
//		password = Hex.decodeHex(encrypted.toCharArray());
//		Db("got password :" + Hex.encodeHexString(password));
		
		password = encrypted.getBytes("UTF-8");
		Db("got password :" + new String(password,"UTF-8"));

		/* Derive the key, given password and salt. */

		factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//		KeySpec spec = new PBEKeySpec(mPassword.toCharArray(), mSalt, 65536,
//		KeySpec spec = new PBEKeySpec(encrypted.toCharArray(), mSalt, 65536,
		KeySpec spec = new PBEKeySpec(encrypted.toCharArray(), mSalt, 65536,128);

		tmp = factory.generateSecret(spec);
		secret = new SecretKeySpec(tmp.getEncoded(), "AES");

		/* Decrypt the message, given derived key and initialization vector. */
		mDecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//		mDecipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(mInitVec));
//		mDecipher.init(Cipher.DECRYPT_MODE, secret);
		byte[] mInitVec =  new byte[mDecipher.getBlockSize()];
		IvParameterSpec ivspec = new IvParameterSpec(mInitVec);
		
		mInitVec = initvec.getBytes("UTF-8");
		Db("got initvector :" + new String(mInitVec,"UTF-8"));

		mDecipher.init(Cipher.DECRYPT_MODE, secret, ivspec);
		
		
		
//		byte[] original = mDecipher.doFinal(Hex.decodeHex(encrypted
//				.toCharArray()));
		byte[] original = mDecipher.doFinal(password);

//		return new String(original);
		return new String(original,"UTF-8");

	}

}
