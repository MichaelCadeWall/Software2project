package Encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class PasswordENC {
    private String key = "1qazxsw23edcvfr45tgbnhy67ujm,ki8";
    private byte[] raw = key.getBytes();
    private SecretKeySpec skey = new SecretKeySpec(raw, "AES");
    private Cipher c;

    public PasswordENC() {
        try {
            c = Cipher.getInstance("AES");
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
    }

    public byte[] encryptPass(String password) {
        try {
            c.init(Cipher.ENCRYPT_MODE, skey);
            byte[] encrypted = c.doFinal(password.getBytes());
            return encrypted;
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(byte[] strToDecrypt) {
        try {
            c.init(Cipher.DECRYPT_MODE, skey);
            byte[] decrypted = c.doFinal(strToDecrypt);
            String stm = new String(decrypted, StandardCharsets.UTF_8);
            return stm;
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public String byteToString(byte[] input) {
        String holder = "";
        for (int i = 0; i < input.length; i++) //to int array in string form
        {
            holder = holder + (int) input[i] + " ";
        }
        return holder;
    }

    public byte[] stringToByte(String input) {
        String[] data = input.split(" ");

        int[] comp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            comp[i] = Integer.parseInt(data[i]);
        }

        byte[] almost = new byte[comp.length];
        for (int i = 0; i < comp.length; i++) {
            almost[i] = (byte) comp[i];
        }
        return almost;
    }

}
