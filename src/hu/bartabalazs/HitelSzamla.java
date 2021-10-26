package hu.bartabalazs;

public class HitelSzamla extends Szamla{

    private int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelKeret) {
        super(tulajdonos);
        this.hitelKeret = hitelKeret;
    }

    public int getHitelKeret() {
        return hitelKeret;
    }

    @Override
    public boolean kivesz(int osszeg) {
        boolean sikeres = true;
        if (osszeg >= this.hitelKeret) {
            sikeres = false;
        }
        return sikeres;
    }
}
