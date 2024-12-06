package com.example.egoverment;

import java.security.MessageDigest;

public class Hashing {
    public static String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.println("We hate java, hashing failed");
            return"failed";
        }


    }
}