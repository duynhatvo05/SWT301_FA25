package duyvn.example;

import java.util.logging.Logger;

final class Constants {
    private Constants() {}
    static final int MAX_USERS = 100;
}

public class InterfaceFieldModificationExample {
    private static final Logger LOG =
            Logger.getLogger(InterfaceFieldModificationExample.class.getName());

    public static void main(String[] args) {
        int limit = Constants.MAX_USERS;
        LOG.info(() -> "MAX_USERS = " + limit);
    }
}

