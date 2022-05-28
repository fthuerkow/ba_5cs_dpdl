import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class SchuelerListe {

    private List<Schueler> schuelerListe;
    private String name;
    private String location;

    @XmlElement(name = "schueler")
    public List<Schueler> getSchuelerListe() {
        return schuelerListe;
    }

    public void setSchuelerListe(List<Schueler> schuelerListe) {
        this.schuelerListe = schuelerListe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
