import java.io.*;
import java.util.logging.*;

public class MeinLogger {

    public static void main(String[] args) throws IOException {

        Logger log = Logger.getLogger("Test");
        Handler h = new FileHandler("LoggerText.txt");
        SimpleFormatter f = new SimpleFormatter();

        h.setFormatter(f);
        log.addHandler(h);

        //Unterschiedlichen Log-Level
        log.setLevel(Level.FINE);

        //Text in Log-Datei schreiben
        log.severe("SCHWERER FEHLER!!! HIGH VOLTAGE!");
        log.info("INFO FEHLER");

        // Eine Ebene tiefer als gesetztes Log-Level (FINE)
        log.finest("FEINSTE MELDUNG");
    }
}
