package com.example.sinyakkirill.lab_4_5.hash;

import android.util.Log;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Sinyak Kirill on 09.11.2016.
 */

public class MD5Hash {
    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;byte[] digest = new byte[0];
        try {
                messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                messageDigest.update(st.getBytes());
                digest = messageDigest.digest();
            }
        catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            Log.d("Box", "error get Instance in get hash function");
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);
        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }
       return md5Hex;
    }
}
