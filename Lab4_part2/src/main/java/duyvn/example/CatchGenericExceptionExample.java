package duyvn.example;
import java.util.logging.Logger;

public class CatchGenericExceptionExample {

    private static final Logger LOG =
            Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        String s = readValueFromRuntime();

        if (s == null) {
            LOG.warning("Variable 's' is null; skipping length computation");
            return;
        }

        // Dùng logger + Supplier để tránh concat eager
        LOG.info(() -> "Length = " + s.length());
    }

    static String readValueFromRuntime() {
        return System.getProperty("demo.value");
    }
}

