package duyvn.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class PathTraversalExample {
    private static final Logger LOG = Logger.getLogger(PathTraversalExample.class.getName());

    public static void main(String[] args) throws IOException {
        String userInput = "../secret.txt";
        File file = new File(userInput);

        if (file.exists()) {
            // try-with-resources để tránh rò rỉ tài nguyên (khuyến nghị thêm)
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                LOG.info("Reading file: " + file.getPath());
                // xử lý đọc nếu cần
            }
        }
    }
}
