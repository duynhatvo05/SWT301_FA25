package duyvn.example;
import java.util.logging.Logger;

public class NullPointerExample {
    private static final Logger LOG = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = (args.length > 0) ? args[0] : null;

        if (text == null || text.isEmpty()) {
            LOG.warning("Text is null or empty");
            return;
        }

        LOG.info("Text is not empty");
    }
}

