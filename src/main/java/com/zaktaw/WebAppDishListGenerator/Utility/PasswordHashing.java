package com.zaktaw.WebAppDishListGenerator.Utility;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {

    // code from https://www.geeksforgeeks.org/md5-hash-in-java/
    public static String hashPassord(String password)  {
        // Static getInstance method is called with hashing MD5
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // digest() method is called to calculate message digest
        // of an input digest() return array of byte
        byte[] messageDigest = md.digest(password.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
}
