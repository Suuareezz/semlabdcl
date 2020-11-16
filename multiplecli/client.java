package multiplecli;

import java.io.*;
import java.util.logging.*;

public class client {
    private static Logger logger = Logger.getAnonymousLogger();

    public static void main(String argv[]) throws IOException {
        Handler handler = new SocketHandler("localhost", 5000);
        logger.addHandler(handler);
        logger.log(Level.SEVERE, "Hello, World");
        logger.log(Level.SEVERE, "Welcome Home");
        logger.log(Level.SEVERE, "Hello, World");
        logger.log(Level.SEVERE, "Welcome Home");
    }
}