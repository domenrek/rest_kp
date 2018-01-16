package si.fri.prpo.zx2.ponudnik.entitete;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ponudnik {

    private String ime;
    private String sedezPonudnika;

    public Ponudnik() {

    }

    public Ponudnik(String ime, String sedezPonudnika) {
        this.ime = ime;
        this.sedezPonudnika = sedezPonudnika;
    }

    // get / set
    @XmlElement
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    @XmlElement
    public String getSedezPonudnika() {
        return sedezPonudnika;
    }

    public void setSedezPonudnika(String sedezPonudnika) {
        this.sedezPonudnika = sedezPonudnika;
    }
}
