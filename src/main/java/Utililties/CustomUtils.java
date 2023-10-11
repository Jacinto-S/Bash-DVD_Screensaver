package Utililties;

import java.util.logging.Logger;

public class CustomUtils {
    public CustomUtils() {
    }
    public static void logErrorAndQuit(String errorMessage) {
        Logger warning = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        warning.severe(errorMessage);
        System.out.println("Closing Program...");
        System.exit(1);
    }
}
