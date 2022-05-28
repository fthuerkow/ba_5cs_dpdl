import java.io.*;

public class Test {

    public static void main(String[] args) {
        File ordner = new File("bla/suelz/testdir");
        ordner.mkdirs();

        if(ordner.isDirectory()) {
            System.out.println("Ordner ist da");

            File unsereDatei = new File("bla/suelz/testdir/unsereDatei.txt");
            try {
                unsereDatei.createNewFile();
                File neuerName = new File("bla/suelz/testdir/neuerName.txt");
                unsereDatei.renameTo(neuerName);

            } catch (IOException e) {
                System.out.println("Fehler: Datei nicht angelegt.");
                //e.printStackTrace();
            }
        } else {
            System.out.println("Oberordner ist nicht da.");
        }
    }
}