package encryptdecrypt;

public class MessageManipulationSelection {
    private Algorithm algorithm;

    public Algorithm setManipulation(String mode) {
        if (mode.equals("enc")) {
            algorithm = new Encryptor();
        } else if (mode.equals("dec")) {
            algorithm = new Decryptor();
        } else {
            System.out.println("Invalid input. Choose 'enc' or 'dec'.");
            return null;
        }
        return algorithm;
    }
}
