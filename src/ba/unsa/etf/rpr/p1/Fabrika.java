package ba.unsa.etf.rpr.p1;

import java.util.*;
import java.util.function.Function;

public class Fabrika {

    private ArrayList<Masina> masine;

    public Fabrika() {
        masine = new ArrayList<>();
    }

    public ArrayList<Masina> getMasine() {
        return masine;
    }

    public void setMasine(ArrayList<Masina> masine) {
        this.masine = masine;
    }

    public Masina dodajKupljenuMasinu(String naziv, int serijski) {
        Masina masina = new KupljenaMasina(naziv,serijski);
        if(masine.contains(masina)){
           masine.get(masine.indexOf(masina)).setNaziv(naziv);
        }else{
            masine.add(masina);
        }
        return masina;
    }

    public Masina dodajDomacuMasinu(String naziv, int serijski) {
        Masina masina = new DomacaMasina(naziv,serijski);
        if(masine.contains(masina)){
            masine.get(masine.indexOf(masina)).setNaziv(naziv);
        }else{
            masine.add(masina);
        }
        return masina;
    }

    public void dodajMaterijal(String naziv, String materijal, int cijena) {
        boolean found = false;
        for(Masina element : masine){
            if(element.getNaziv().equals(naziv)){
                found = true;
                element.registrujMaterijal(materijal,cijena);
            }
        }
        if(!found)throw new IllegalArgumentException();
    }

    public Map<Masina, String> najviseProizvoda() {
        Map<Masina, String> result = new HashMap<>();
        for(Masina element : masine){
            ArrayList<Map.Entry<String,Integer>> x = new ArrayList<>(element.dajMogucnostProizvodnje().entrySet());
            x.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    if(o1.getValue().equals(o2.getValue())){
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            if(x.size()>0 && element.getUpaljen()){
                result.put(element,x.get(0).getKey());
            }
        }
        return result;
    }

    public Set<Masina> dajMasine(Function<Masina,Boolean> funkcija) {
        Set<Masina> result = new TreeSet<>();
        boolean jest = false;
        for(Masina element : masine){
            jest = false;
            if(funkcija == null){
                jest = true;
            }else{
                jest = funkcija.apply(element);
            }
            if(jest)result.add(element);
        }
        return result;
    }

    public Map<Masina, Integer> cijenaZaMaterijal(String materijal) {
        Map<Masina,Integer> result = new HashMap<>();
        for(Masina element : masine ){
            if(element.getUpaljen()){
                result.put(element, element.getMaterijali().getOrDefault(materijal, -1));
            }
        }
        return result;
    }

    @Override
    public String toString() {
        //1. Masina domaca je upaljena (preostalo 8 sati). Ona moze proizvesti materijale m1 (1), m3 (3), m5 (5).
        String result = "";
        for(int i=0;i<masine.size();i++){
            result+=i+1 +". "+masine.get(i)+"\n";
        }
        return result;
    }
}
