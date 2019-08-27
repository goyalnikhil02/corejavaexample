package com.example.java8.security;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.io.ByteArrayInputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EC {

   
    public static final String EC_ALGORITHM = "EC";
    public static final String ECIES_ALGORITHM = "ECIES";

    private static BouncyCastleProvider bcprovider = new BouncyCastleProvider();

    private Cipher cipher;

    static {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
    }

    @PostConstruct
    public void init() {
        try {
            cipher = Cipher.getInstance(ECIES_ALGORITHM, bcprovider);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public String encrypt(byte[] plainText, byte[] certificate) {
        try {
            return encrypt(plainText, getCertificateFromHex(certificate));
        } catch (Exception e) {
           
        }
        return null;
    }

    public String encrypt(byte[] plainText, X509Certificate certificate) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {

        return Base64.getEncoder().encodeToString(encrypt(plainText, certificate.getPublicKey()));
    }


    public byte[] encrypt(byte[] plainText, PublicKey publicKey) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        byte[] cipherText;
        byte[] plainTextBytes = plainText;



        cipher.init(Cipher.ENCRYPT_MODE, publicKey, new SecureRandom());
        cipherText = cipher.doFinal(plainTextBytes);

        return cipherText;
    }

    public byte[] decrypt(String b64CipheredText, byte[] privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeyException {

        return decrypt(Base64.getDecoder().decode(b64CipheredText), getPrivateKeyFromHex(privateKey));
    }

    public byte[] decrypt(byte[] cipherText, byte[] privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException,
            BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        return decrypt(cipherText, getPrivateKeyFromHex(privateKey));
    }

    public byte[] decrypt(String b64CipheredText, PrivateKey privateKey) throws
            BadPaddingException, IllegalBlockSizeException, InvalidKeyException {

        return decrypt(Base64.getDecoder().decode(b64CipheredText),privateKey);
    }

    public byte[] decrypt(byte[] cipherText, PrivateKey privateKey) throws BadPaddingException, IllegalBlockSizeException,
            InvalidKeyException {
        cipher.init(Cipher.DECRYPT_MODE, privateKey, new SecureRandom());
        return cipher.doFinal(cipherText);
    }

    private X509Certificate getCertificateFromHex(byte[] pubKey) throws CertificateException {
        return (X509Certificate) CertificateFactory.getInstance("X509", bcprovider).generateCertificate(new ByteArrayInputStream(pubKey));
    }

    public PrivateKey getPrivateKeyFromHex(byte[] encoded) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(EC_ALGORITHM, bcprovider);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);

        return keyFactory.generatePrivate(keySpec);
    }

    public PublicKey getPublicKeyFromHex(byte[] encoded) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeyFactory keyFactory = KeyFactory.getInstance(EC_ALGORITHM, bcprovider);
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encoded);

        return keyFactory.generatePublic(publicKeySpec);
    }

}
