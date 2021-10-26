package hu.bartabalazs;

public class MegtakaritasSzamla extends Szamla{

    private double kamat;
    private static double alapkamat;
    public MegtakaritasSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapkamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamaet(int kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(int osszeg) {
        boolean siekrult = true;
        if(osszeg >= getAktualisEgyenleg()){
            siekrult = false;
        }
        return siekrult;
    }
    public void kamatJovaIras(){

    }
}
