import javax.xml.bind.JAXBException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class XMLHTMLConverter {

    public static void main(String[] args) {

        Source xml = new StreamSource(new File("schuelerliste.xml"));
        Source xslt = new StreamSource("unserstyle.xml");

        converttohtml(xml, xslt);
    }

    public static void converttohtml(Source xml, Source xslt) {

        StringWriter sw = new StringWriter();

        try {

            FileWriter fw = new FileWriter("schuelerliste.html");

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(xslt);
            transformer.transform(xml, new StreamResult(sw));

            fw.write(sw.toString());
            fw.close();

        } catch (IOException | TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
