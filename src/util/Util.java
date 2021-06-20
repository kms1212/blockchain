package util;

import java.security.MessageDigest;

public class Util {
    public static String getHash(String input) {
        return getHash(input, "SHA-256");
    }

    public static String getHash (String input, String algorithm) {
        StringBuffer res = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(input.getBytes());
            byte bytes[] = md.digest();
            for (int i = 0; i < bytes.length; i++) {
                res.append(Integer.toString((bytes[i] & 0xFF ) + 0x100, 16).substring(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return res.toString();
    }
}
