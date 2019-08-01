package encryptdecrypt;

public interface Algorithm {
    public String unicode(String message, int key);

    public String shift(String message, int key);


}
