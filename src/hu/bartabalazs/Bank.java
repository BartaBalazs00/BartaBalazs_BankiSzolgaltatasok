package hu.bartabalazs;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    Szamla[] szamlaLista;

    public Bank(int szamlakSzama) {
        szamlaLista = new Szamla[szamlakSzama];
    }
    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        Szamla szamla;
        if(hitelKeret>0){
            HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista[0] = hitelSzamla;
            szamla = hitelSzamla;
        } else {
            MegtakaritasSzamla megtakaritasSzamla = new MegtakaritasSzamla(tulajdonos);
            szamlaLista[0] = megtakaritasSzamla;
            szamla = megtakaritasSzamla;
        }
        return szamla;
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
        while (!elsoTalalat || i!=szamlaLista.length) {
            if(szamlaLista[i].getTulajdonos().equals(tulajdonos)){
                index = i;
                elsoTalalat = true;
            }
            i++;
        }

        for (int j = index+1; j < szamlaLista.length; j++) {
            if (szamlaLista[j].getTulajdonos().equals(tulajdonos)){
                if(szamlaLista[j].getAktualisEgyenleg() > szamlaLista[j].getAktualisEgyenleg()){
                    index = j;
                }
            }
        }
        return szamlaLista[index];
    }
    public long osszHitelKeret(){
        int osszeg = 0;
        for (Szamla szamla: szamlaLista) {
            osszeg += ((HitelSzamla)szamla).getHitelKeret();
        }
        return osszeg;
    }
}
