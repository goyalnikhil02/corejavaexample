package com.example.java8.security;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Encrypting {

	public static final String public_key_file = "C:\\Users\\g521784\\Desktop\\keypair\\public.key";

	public static final String private_key_file = "C:\\Users\\g521784\\Desktop\\keypair\\india.key";

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		try {
			EncryptionUtil util = new EncryptionUtil();

			PublicKey publicKey = readPublicKey(public_key_file);

			PrivateKey privateKey = readPrivateKey(private_key_file);

			byte[] message = "MY Name is  Goyal".getBytes("UTF8");
			byte[] secret = util.encrypt(publicKey, message);

			byte[] recovered_message = util.decrypt(privateKey, secret);
			System.out.println(new String(recovered_message, "UTF8"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static byte[] readFileBytes(String filename) throws IOException {
		Path path = Paths.get(filename);
		return Files.readAllBytes(path);
	}

	public static PublicKey readPublicKey(String filename)
			throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(readFileBytes(filename));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(publicSpec);
	}

	public static PrivateKey readPrivateKey(String filename)
			throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(readFileBytes(filename));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}

}
