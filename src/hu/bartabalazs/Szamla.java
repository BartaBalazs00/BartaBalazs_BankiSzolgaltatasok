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
        this.aktualisEgyenleg+=osszeg;
    }
    public abstract boolean kivesz(int osszeg);
}
