 package encryptdecrypt;

 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.util.*;

 public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mode = "";
        String data = "";
        String in = "";
        String out = "";
        String result = "";
        String alg = "";
        int key = Integer.MIN_VALUE;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i+1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i+1]);
                    break;
                case "-data":
                    data = args[i+1];
                    break;
                case "-in":
                    in = args[i+1];
                    break;
                case "-out":
                    out = args[i+1];
                    break;
                case "-alg":
                    alg = args[i+1];
                    break;
                default:
                    break;
            }
        }

//        System.out.println(Arrays.toString(args));
//        System.out.println("Mode: " + mode);
//        System.out.println("Data: " + data);
//        System.out.println("Algorithm: " + alg);
//        System.out.println("Key: "+ key);

        if (data == "" && in == "") {
            data = scanner.nextLine();
        }

        if (in != "") {
            try {
                data = new String(Files.readAllBytes(Paths.get(in)));
                System.out.println(data);
            } catch (IOException e) {
                System.out.println("File not found.");
            }
        }

        MessageManipulationSelection algorithmSelection = new MessageManipulationSelection();
        Algorithm myAlgo = algorithmSelection.setManipulation(mode);
        result = setAlgorithm(myAlgo, alg, data, key);
        System.out.println(result);

        if (out != "") {
            File output = new File(out);
            try (FileWriter writer = new FileWriter(output)) {
                writer.write(result);
            } catch (IOException e) {
                System.out.println("Could not write file.");
            }
        }
    }

     static public String setAlgorithm(Algorithm algorithm, String alg, String message, int key) {
         if (alg.equals("unicode")) {
             return algorithm.unicode(message, key);
         } else if (alg.equals("shift")) {
             return algorithm.shift(message, key);
         } else {
             System.out.println("Invalid input. Choose 'unicode' or 'shift'.");
             return null;
         }
     }
}
