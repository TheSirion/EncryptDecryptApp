package encryptdecrypt;

public class Encryptor implements Algorithm {
    public String unicode(String message, int key) {
        String crypto = "";
        for (char ch : message.toCharArray()) {
            ch += key;
            crypto += ch;
        }
        return crypto;
    }

    public String shift(String message, int key) {
        String crypto = "";
        for (char ch : message.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                ch += key;
                if (ch > 122) {
                    ch -= 26;
                }
            }
            crypto += ch;
        }
        return crypto;

    }
}
