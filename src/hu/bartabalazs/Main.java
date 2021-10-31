package hu.bartabalazs;

public class Main {

    public static void main(String[] args) {

        //kettő tulajdonos
        Tulajdonos t1 = new Tulajdonos("Barta Balázs");
        Tulajdonos t2 = new Tulajdonos("Beviz Elek");

        //1 hitelszamla
        HitelSzamla h1 = new HitelSzamla(t1, 100000);
        System.out.println(h1.kivesz(10000));

        //Kártya
        Kartya k1 = h1.ujKartya("123456789");
        System.out.println(k1.getKartyaSzam());
        System.out.println(k1.getTulajdonos().getNev());

        //kártya vásárlás befizetés hitelmszámlán
        System.out.println("20000 ft vásárlás : " + (k1.vasarlas(20000) ? "sikeres":"nem sikeres"));
        System.out.println("Számla aktuális egyenlege: "+k1.getSzamla().getAktualisEgyenleg());
        System.out.println("10000 ft befizetés");
            k1.getSzamla().befizet(10000);
        System.out.println("Számla aktuális egyenlege: "+k1.getSzamla().getAktualisEgyenleg());
        System.out.println("80000 ft vásárlás : " + (k1.vasarlas(80000) ? "sikeres" : "nem sikeres"));
        System.out.println("Számla aktuális egyenlege: "+k1.getSzamla().getAktualisEgyenleg());
        System.out.println("100 ft vásárlás : " + (k1.vasarlas(100) ? "sikeres" : "nem sikeres"));

        System.out.println("100000 ft vásárlás : " + (k1.getSzamla().kivesz(100000)? "sikeres" : "nem sikeres"));
        System.out.println("Számla aktuális egyenlege: "+k1.getSzamla().getAktualisEgyenleg());

        System.out.println("\n");
        //megtakaritas számla
        System.out.println("megtakarítás Számla");
        MegtakaritasSzamla m1 = new MegtakaritasSzamla(t1);
        System.out.println("A kamat mértéke: "+m1.getKamat());
        System.out.println("A kamat megváltoztatása 1.2-re");
        m1.setKamat(1.2);
        System.out.println("A kamat mértéke: "+m1.getKamat());
        System.out.println("feltült 10000 forintot ");
        m1.befizet(10000);
        System.out.println("Aktuáli egyenleg: "+m1.getAktualisEgyenleg());
        System.out.println("kivesz 5000 forintot: " + (m1.kivesz(5000) ? "sikerült" : "Nem sikerült"));
        System.out.println("Aktuáli egyenleg: "+m1.getAktualisEgyenleg());
        System.out.println("kivesz 10000 forintot: " + (m1.kivesz(10000) ? "sikerült" : "Nem sikerült"));
        System.out.println("Aktuáli egyenleg: "+m1.getAktualisEgyenleg());
        System.out.println("kamat jóváírás");
        m1.kamatJovaIras();
        System.out.println("Aktuáli egyenleg: "+m1.getAktualisEgyenleg());


        //Bank
        System.out.println("\nBank létrehozása");
        Bank b1 = new Bank();

        b1.szamlaNyitas(t1, 0);
        b1.szamlaNyitas(t1, 0);
        b1.szamlaNyitas(t2, 0);//Beviz Elek
        b1.szamlaNyitas(t1, 10000);
        b1.szamlaNyitas(t1, 10000);
        b1.szamlaNyitas(t1, 20000);

        b1.szamlaLista.get(0).befizet(10000);
        b1.szamlaLista.get(1).befizet(100000);
        b1.szamlaLista.get(2).befizet(500000);//Beviz Elek
        b1.szamlaLista.get(3).befizet(200000);
        b1.szamlaLista.get(4).befizet(200000);
        b1.szamlaLista.get(5).befizet(200000);

        System.out.println("számla típusa:");
        System.out.println(b1.szamlaLista.get(2).getClass());
        System.out.println(b1.szamlaLista.get(4).getClass());

        System.out.println(t1.getNev()+" legnagyobb egyenlegő számlája: "+b1.getLegnagyobbEgyenlegoSzamla(t1).getAktualisEgyenleg());
        System.out.println(t1.getNev() + " összes egyenlege: "+ b1.osszEgyenleg(t1));
        System.out.println("Össz hitelkeret: " + b1.getOsszHitelKeret());
    }
}
