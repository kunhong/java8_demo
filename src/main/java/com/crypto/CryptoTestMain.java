package com.crypto;

public class CryptoTestMain {
    public static void main(String[] args) {
        AESAlgorithm aesAlgorithm = new AESAlgorithm();

        try {
            String enc = aesAlgorithm.encyrpt("My Name is KunHong");
            String dec = aesAlgorithm.decrypt(enc);

            System.out.println(enc);
            System.out.println(dec);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
