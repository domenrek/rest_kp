package si.fri.prpo.zx2.ponudnik.entitete;

public class Jedilnik {

    private String dan;
    private String predjed;
    private String glavnaJed;
    private String sladica;

    public Jedilnik() {

    }

    public Jedilnik(String dan, String predjed, String glavnaJed, String sladica) {
        this.dan = dan;
        this.predjed = predjed;
        this.glavnaJed = glavnaJed;
        this.sladica = sladica;
    }

    // get / set

    public String getPredjed() {
        return predjed;
    }

    public void setPredjed(String predjed) {
        this.predjed = predjed;
    }

    public String getGlavnaJed() {
        return glavnaJed;
    }

    public void setGlavnaJed(String glavnaJed) {
        this.glavnaJed = glavnaJed;
    }

    public String getSladica() {
        return sladica;
    }

    public void setSladica(String sladica) {
        this.sladica = sladica;
    }

    public String getDan() {
        return dan;
    }

    public void setDan(String dan) {
        this.dan = dan;
    }
}
