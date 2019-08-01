package encryptdecrypt;

public class Decryptor implements Algorithm {
    public String unicode(String crypto, int key) {
        String message = "";
        for (char ch : crypto.toCharArray()) {
            ch -= key;
            message += ch;
        }
        return message;
    }

    public String shift(String crypto, int key) {
        String message = "";
        for (char ch : crypto.toCharArray()) {
            ch -= key;
            if (ch > 122) {
                ch -= 26;
            }
            if (ch < 97) {
                ch += 26;
            }
            message += ch;
        }
        return message;
    }
}
