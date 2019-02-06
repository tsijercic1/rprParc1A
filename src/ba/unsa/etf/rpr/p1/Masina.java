package ba.unsa.etf.rpr.p1;

import java.util.*;

public class Masina implements Comparable{
    private String naziv;
    private int serijski;
    private final int maxRadniSati = 8;
    private Boolean upaljen;
    private int radniSati;
    private Map<String,Integer> materijali;

    public Masina() {
        materijali = new HashMap<>();
        upaljen = false;
    }

    public Masina(String naziv, int serijski) {
        this.setNaziv(naziv);
        this.setSerijski(serijski);
        materijali = new HashMap<>();
        upaljen = false;
    }

    public Map<String, Integer> getMaterijali() {
        return materijali;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.matches("[^a-zA-Z]+") || naziv.length()<2)throw new IllegalArgumentException();
        this.naziv = naziv;
    }

    public int getSerijski() {
        return serijski;
    }

    public void setSerijski(int serijski) {
        if(serijski > 99999 || serijski <= 0){
            throw new IllegalArgumentException();
        }
        this.serijski = serijski;
    }

    public Boolean getUpaljen() {
        return upaljen;
    }

    public void setUpaljen(Boolean upaljen) {
        this.upaljen = upaljen;
    }

    public int getRadniSati() {
        return radniSati;
    }

    public void setRadniSati(int radniSati) {
        this.radniSati = radniSati;
    }

    public void upali() {
        if (upaljen){
            throw new WrongMachineState();
        }
        upaljen = true;
        radniSati = maxRadniSati;
    }

    public void ugasi() {
        if(!upaljen)throw new WrongMachineState();
        upaljen = false;
    }

    public int proizvedi(String materijal) {
        if(materijali.containsKey(materijal)){
            if(materijali.get(materijal)<=radniSati){
                int x = materijali.get(materijal);
                radniSati-=x;
                return x;
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public void resetuj() {
        ugasi();
        upali();
    }

    public int preostaloSati() {
        return radniSati;
    }

    public Set<String> dajMaterijaleMoguceZaProizvesti() {
        Set<String> result = new TreeSet<>();
        for(Map.Entry<String,Integer> element : materijali.entrySet()){
            if(element.getValue()<=radniSati){
                result.add(element.getKey());
            }
        }
        return result;
    }

    public Map<String, Integer> dajMogucnostProizvodnje() {
        Map<String, Integer> result = new HashMap<>();
        for(Map.Entry<String,Integer> element : materijali.entrySet()){
            result.put(element.getKey(),radniSati/element.getValue());
        }
        return result;
    }
    public void registrujMaterijal(String materijal, Integer cijena){
        if(cijena > 5 || cijena < 1)throw new IllegalArgumentException();
        if(!materijali.containsKey(materijal)){
            materijali.put(materijal,cijena);
        }
    }

    @Override
    public String toString() {

        String result = "Ona moze proizvesti materijale ";
        ArrayList<Map.Entry<String, Integer>> x = new ArrayList<>(materijali.entrySet());
        x.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(int i=0;i<x.size();i++){
            if (i == 0){
                result += x.get(i).getKey()+" ("+x.get(i).getValue()+")";
            }else{
                result += ", "+x.get(i).getKey()+" ("+x.get(i).getValue()+")";
            }
        }
        result+=".";
        return "Masina "+naziv+" je "+((upaljen)?"upaljena (preostalo "+radniSati+" sati). ":"ugasena. ")+result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Masina masina = (Masina) o;

        return serijski == masina.serijski;
    }

    @Override
    public int hashCode() {
        return serijski;
    }

    @Override
    public int compareTo(Object o) {
        Masina t = (Masina)o;
        if(this.dajMaterijaleMoguceZaProizvesti().size() == t.dajMaterijaleMoguceZaProizvesti().size()){
            return this.getNaziv().compareTo(t.getNaziv());
        }
        return (t.dajMaterijaleMoguceZaProizvesti().size()>this.dajMaterijaleMoguceZaProizvesti().size())?-1:1;
    }
}
