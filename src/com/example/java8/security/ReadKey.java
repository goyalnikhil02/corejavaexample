package com.example.java8.security;

import java.io.File;
import java.io.FileInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;

public class ReadKey {

	/*protected PublicKey readPublicKey() {
		try {
			String public_Key = "public.key";
			File file = FileUtils.resolve(this, public_Key);
			FileInputStream fis = new FileInputStream(file);
			byte[] encodedPublicKey = new byte[(int) file.length()];
			fis.read(encodedPublicKey);
			fis.close();
			return eciesEncryptor.getPublicKeyFromHex(encodedPublicKey);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	protected PrivateKey readPrivateKey() {
		try {
			String private_key = "private.key";

			File file = FileUtils.resolve(this, private_key);
			FileInputStream fis = new FileInputStream(file);
			byte[] encodedPrivateKey = new byte[(int) file.length()];
			fis.read(encodedPrivateKey);
			fis.close();
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
			return eciesEncryptor.getPrivateKeyFromHex(encodedPrivateKey);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}*/
}
