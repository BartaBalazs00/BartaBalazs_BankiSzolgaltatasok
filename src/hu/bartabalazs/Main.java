package hu.bartabalazs;

public class Main {

    public static void main(String[] args) {

        Tulajdonos t1 = new Tulajdonos("Barta Balázs");
        Tulajdonos t2 = new Tulajdonos("Beviz Elek");

        HitelSzamla h1 = new HitelSzamla(t1, 100000);
        System.out.println(h1.kivesz(10000));

        Kartya k1 = h1.UjKartya("123456789");
        System.out.println(k1.getKartyaSzam());
        System.out.println(k1.getTulajdonos().getNev());
        k1.getSzamla().befizet(10000);

        System.out.println(k1.getSzamla().kivesz(100000));
        System.out.println(k1.getSzamla().getAktualisEgyenleg());
        MegtakaritasSzamla m1 = new MegtakaritasSzamla(t1);
        Bank b1 = new Bank();
        b1.szamlaNyitas(t1, 0);
        b1.szamlaNyitas(t1, 0);
        System.out.println(b1.getLegnagyobbEgyenlegoSzamla(t1));
    }
}
