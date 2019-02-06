package ba.unsa.etf.rpr.p1;

import java.util.Map;
import java.util.Set;

public class KupljenaMasina extends Masina {
    public KupljenaMasina() {
        super();
    }

    public KupljenaMasina(String naziv, int serijski) {
        super(naziv, serijski);
    }

    @Override
    public String getNaziv() {
        return super.getNaziv();
    }

    @Override
    public void setNaziv(String naziv) {
        super.setNaziv(naziv);
    }

    @Override
    public int getSerijski() {
        return super.getSerijski();
    }

    @Override
    public void setSerijski(int serijski) {
        super.setSerijski(serijski);
    }

    @Override
    public Boolean getUpaljen() {
        return super.getUpaljen();
    }

    @Override
    public void setUpaljen(Boolean upaljen) {
        super.setUpaljen(upaljen);
    }

    @Override
    public int getRadniSati() {
        return super.getRadniSati();
    }

    @Override
    public void setRadniSati(int radniSati) {
        super.setRadniSati(radniSati);
    }

    @Override
    public void upali() {
        super.upali();
    }

    @Override
    public void ugasi() {
        super.ugasi();
    }

    @Override
    public int proizvedi(String materijal) {
        return super.proizvedi(materijal);
    }

    @Override
    public void resetuj() {
        super.resetuj();
    }

    @Override
    public int preostaloSati() {
        return super.preostaloSati();
    }

    @Override
    public Set<String> dajMaterijaleMoguceZaProizvesti() {
        return super.dajMaterijaleMoguceZaProizvesti();
    }

    @Override
    public Map<String, Integer> dajMogucnostProizvodnje() {
        return super.dajMogucnostProizvodnje();
    }

    @Override
    public void registrujMaterijal(String materijal, Integer cijena) {
        super.registrujMaterijal(materijal, cijena);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return super.compareTo(o);
    }
}
