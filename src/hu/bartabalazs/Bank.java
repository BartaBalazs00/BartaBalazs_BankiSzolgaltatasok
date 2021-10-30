package hu.bartabalazs;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    //Szamla[] szamlaLista;
    List<Szamla> szamlaLista = new ArrayList<>();
    //private int szamlakSzama = 0;
    public Bank() {
        //szamlaLista = new Szamla[szamlakSzama];
    }
    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        Szamla szamla;
        try {
            if (hitelKeret > 0) {
                HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos, hitelKeret);
                //szamlaLista[this.szamlakSzama] = hitelSzamla;
                szamlaLista.add(hitelSzamla);
                szamla = hitelSzamla;
            } else {
                MegtakaritasSzamla megtakaritasSzamla = new MegtakaritasSzamla(tulajdonos);
                //szamlaLista[this.szamlakSzama] = megtakaritasSzamla;
                szamlaLista.add(megtakaritasSzamla);
                szamla = megtakaritasSzamla;
            }
            //this.szamlakSzama++;
            return szamla;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
    public int osszEgyenleg(Tulajdonos tulajdonos){
        int egyenleg = 0;
        for (Szamla szamla : szamlaLista) {
            if (szamla.getTulajdonos().getNev().equals(tulajdonos.getNev())) {
                egyenleg += szamla.getAktualisEgyenleg();
            }
        }
        return egyenleg;
    }
    public Szamla getLegnagyobbEgyenlegoSzamla(Tulajdonos tulajdonos){
        boolean elsoTalalat = false;
        int i = 0;
        int index = -1;
        while (!elsoTalalat && i<=szamlaLista.size()) {
            if(szamlaLista.get(i) != null){
                if(szamlaLista.get(i).getTulajdonos().getNev().equals(tulajdonos.getNev())){
                    index = i;
                    elsoTalalat = true;
                }
                i++;
            }
        }

        for (int j = index+1; j < szamlaLista.size(); j++) {
            if (szamlaLista.get(j).getTulajdonos().equals(tulajdonos)){
                if(szamlaLista.get(j).getAktualisEgyenleg() > szamlaLista.get(j).getAktualisEgyenleg()){
                    index = j;
                }
            }
        }
        return szamlaLista.get(index);
    }
    public long osszHitelKeret(){
        int osszeg = 0;
        for (Szamla szamla: szamlaLista) {
            osszeg += ((HitelSzamla)szamla).getHitelKeret();
        }
        return osszeg;
    }
}
