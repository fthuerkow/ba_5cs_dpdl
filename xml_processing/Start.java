import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class Start {

    public static void main(String[] args) {

        var sList = new ArrayList<Schueler>();

        var schueler1 = new Schueler();
        schueler1.setName("Klaus Peter");
        schueler1.setJahrgang("1986");
        schueler1.setNummer(12);

        var schueler2 = new Schueler();
        schueler2.setName("Dieter Ulrich");
        schueler2.setJahrgang("1999");
        schueler2.setNummer(3);

        var schueler3 = new Schueler();
        schueler3.setName("Wolfgang Pieper");
        schueler3.setJahrgang("1965");
        schueler3.setNummer(5);

        sList.add(schueler1);
        sList.add(schueler2);
        sList.add(schueler3);

        var liste = new SchuelerListe();
        liste.setSchuelerListe(sList);

        converttoxml(liste);

    }

    private static void converttoxml(SchuelerListe liste) {

        //Create JAXB Context
        JAXBContext jaxbContext = null;
        try {

            jaxbContext = JAXBContext.newInstance(SchuelerListe.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //StringWriter sw = new StringWriter();
            //jaxbMarshaller.marshal(liste, sw);
            //String xmlContent = sw.toString();

            File datei = new File("schuelerliste.xml");
            jaxbMarshaller.marshal(liste, datei);


            //System.out.println( xmlContent );

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
