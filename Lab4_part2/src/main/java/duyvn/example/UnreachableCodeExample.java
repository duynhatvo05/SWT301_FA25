package duyvn.example;
import java.util.logging.Logger;

public class UnreachableCodeExample {
    private static final Logger LOG =
            Logger.getLogger(UnreachableCodeExample.class.getName());

    public static int getNumber() {
        int value = 42;
        LOG.info(() -> "Returning value: " + value);
        return value; // keep no statements after return
    }

    public static void main(String[] args) {
        LOG.info(() -> String.valueOf(getNumber()));
    }
}

