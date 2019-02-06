package ba.unsa.etf.rpr.p1;

public class Main {

    public static void main(String[] args) {
        Fabrika fabrika = new Fabrika();

        Masina kupljena = fabrika.dodajKupljenuMasinu("kupljena", 521);
        Masina domaca = fabrika.dodajDomacuMasinu("domaca", 1251);

        fabrika.dodajMaterijal("kupljena", "m5", 5);
        fabrika.dodajMaterijal("kupljena", "m1", 1);

        fabrika.dodajMaterijal("domaca", "m1", 1);
        fabrika.dodajMaterijal("domaca", "m5", 5);
        fabrika.dodajMaterijal("domaca", "m3", 3);
        kupljena.upali();
        domaca.upali();
        System.out.println(fabrika);


        System.out.println("Nema maina, pokretni testove!");
    }
}
