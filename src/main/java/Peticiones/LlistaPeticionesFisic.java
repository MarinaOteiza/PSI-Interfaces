package Peticiones;

import Productes.*;

//ÀITOR OLIVARES PERUCHO
public class LlistaPeticionesFisic extends Peticiones {
    private PeticioFisic[] LlistaF;
    private int numllist;

    public LlistaPeticionesFisic(String codi, String usuari, Productes producte, int num){
        super(codi,usuari,producte);
        LlistaF= new PeticioFisic[num];
        numllist=0;
    }

    public void addF(PeticioFisic f1){
        if(numllist<=LlistaF.length){
            LlistaF[numllist]=f1.copia();
            numllist++;
        }
    }

    public boolean contestarF(PeticioFisic f1, boolean resposta){
        int i=0, pos=0;
        boolean trobat=false, contestado=false;
        if(numllist<=LlistaF.length) {
            while (i < numllist && !trobat) {
                if (LlistaF[i].getPeticioAoD() == true) {
                    trobat = true;
                }
                i++;
            }
            if (!trobat) {
                i=0; trobat=false;
                while (i < numllist && !trobat){
                    if (LlistaF[i].equals(f1)) {
                        trobat = true; pos=i;
                    }
                    i++;
                }
                LlistaF[pos].contestarF(f1,resposta);
                contestado=true;
            }
        }
        return contestado;
    }

    public int buscarPeticio (String nomClient){
        int i=0;
        while (i<LlistaF.length){
            if(LlistaF[i].getUsuari_petic().equals(nomClient))
                return i;
        }
        i=-1;
        return i;
    }

    public PeticioFisic[] getLlistaF(){ return LlistaF;}
    public int getNumllist(){return numllist;}
}
