package hu.bartabalazs;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Szamla> szamlaLista;

    public Bank() {
        szamlaLista = new ArrayList<>();
    }
    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos, hitelKeret);
        szamlaLista.add(hitelSzamla);
        return hitelSzamla;
    }
    public int osszEgyenleg(Tulajdonos tulajdonos){
        int egyenleg = 0;
        for (int i = 0; i < szamlaLista.size() ; i++) {
            if(szamlaLista.get(i).getTulajdonos().getNev().equals(tulajdonos.getNev())){
                egyenleg += szamlaLista.get(i).getAktualisEgyenleg();
            }
        }
        return egyenleg;
    }
    public Szamla getLegnagyobbEgyenlegoSzamla(Tulajdonos tulajdonos){
        boolean elsoTalalat = false;
        int i = 0;
        int index = -1;
        int egyenleg = 0;
        while (!elsoTalalat || i!=szamlaLista.size()) {
            if(szamlaLista.get(i).getTulajdonos().equals(tulajdonos)){
                egyenleg = szamlaLista.get(i).getAktualisEgyenleg();
                index = i;
                elsoTalalat = true;
            }
            i++;
        }

        for (int j = index+1; j < szamlaLista.size(); j++) {
            if (szamlaLista.get(j).getTulajdonos().equals(tulajdonos)){
                if(szamlaLista.get(j).getAktualisEgyenleg() > szamlaLista.get(index).getAktualisEgyenleg()){
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
