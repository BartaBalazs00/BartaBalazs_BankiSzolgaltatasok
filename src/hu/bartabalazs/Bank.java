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
        int i = 0;
        int index = -1;
        while (index == -1 && i<szamlaLista.size()) {
            if(szamlaLista.get(i) != null){
                if(szamlaLista.get(i).getTulajdonos().getNev().equals(tulajdonos.getNev())){
                    index = i;
                }
                i++;
            }
        }

        if(index != -1){
            for (int j = index+1; j < szamlaLista.size(); j++) {
                if (szamlaLista.get(j).getTulajdonos().getNev().equals(tulajdonos.getNev())){
                    if(szamlaLista.get(j).getAktualisEgyenleg() > szamlaLista.get(index).getAktualisEgyenleg()){
                        index = j;
                    }
                }
            }
        }
        return szamlaLista.get(index);
    }
    public long getOsszHitelKeret(){
        int osszeg = 0;

        for (Szamla szamla: szamlaLista) {
            if(szamla.getClass().getTypeName().contains("HitelSzamla")){
                osszeg += ((HitelSzamla)szamla).getHitelKeret();
            }
        }
        return osszeg;
    }
}
