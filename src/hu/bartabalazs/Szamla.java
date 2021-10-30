package hu.bartabalazs;

public abstract class Szamla extends BankiSzolgaltatas{

    private int aktualisEgyenleg;

    public Szamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
    }

    public int getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }

    public void befizet(int osszeg){
        if(osszeg>0){
            this.aktualisEgyenleg+=osszeg;
        }
    }

    private void setAktualisEgyenleg(int aktualisEgyenleg) {
        this.aktualisEgyenleg = aktualisEgyenleg;
    }

    public abstract boolean kivesz(int osszeg);

    public Kartya UjKartya(String kartyaSzam){
        Kartya ujKartya = new Kartya(this.getTulajdonos(),Szamla.this , kartyaSzam);
        return ujKartya;
    }
}
