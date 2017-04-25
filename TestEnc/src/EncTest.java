import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncTest {

	public static String encrypt(String key, byte[] initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector);
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("US-ASCII"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted));

			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static String decrypt(String key, byte[] initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector);
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("US-ASCII"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CFB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] decodeBase64 = Base64.decodeBase64(encrypted);
			byte[] original = cipher.doFinal(decodeBase64);

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		String key = "[[Veriz0n6a9ea57463b911e6aWWWdcd"; // 128 bit key
		
		byte[] initVector = new byte[] { (byte) 0xff, (byte) 0xf1, 0x02, 0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f, 0x03, 0x04, 0x05, 0x06, 0x07};

//		String encrypt = encrypt(key, initVector, "xmlTest01");
//		//System.out.println(encrypt);
//		System.out.println(decrypt(key, initVector, encrypt));
		
		System.out.println(decrypt(key, initVector, "ba3nPIKtJRVX"));
		
		
//		String key = "Bar12345Bar12345"; // 128 bit key
//        String initVector = "RandomInitVector"; // 16 bytes IV
//
//        System.out.println(decrypt(key, initVector,
//                encrypt(key, initVector, "Hello World")));
	}
}
