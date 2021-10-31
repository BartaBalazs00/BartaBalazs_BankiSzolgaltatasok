package hu.bartabalazs;

public class MegtakaritasSzamla extends Szamla{

    private double kamat;
    private static double alapkamat = 1.1;

    public MegtakaritasSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        this.kamat = alapkamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }

    @Override
    public boolean kivesz(double osszeg) {
        boolean siekrult = true;
        if(osszeg > getAktualisEgyenleg()){
            siekrult = false;
        } else {
            setAktualisEgyenleg(getAktualisEgyenleg()-osszeg);
        }
        return siekrult;
    }
    public void kamatJovaIras(){
        setAktualisEgyenleg(getAktualisEgyenleg()*kamat);
    }
}
