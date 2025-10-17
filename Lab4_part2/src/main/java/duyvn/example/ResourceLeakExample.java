package duyvn.example;
import java.io.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceLeakExample {

    private static final Logger LOG =
            Logger.getLogger(ResourceLeakExample.class.getName());

    public static void main(String[] args) {
        String fileName = "data.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Sửa 2: thay System.out bằng logger
                LOG.info(line);
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, e, () -> "Failed to read file: " + fileName);

        }
    }
}
