package Peticiones;

import Productes.*;

//ÀITOR OLIVARES PERUCHO
public class LlistaPeticionesServei extends Peticiones {
    private PeticionesServei LlistaS[];
    private int numllist;

    public LlistaPeticionesServei(String codi, String usuari, Productes producte, int num){
        super(codi,usuari,producte);
        LlistaS= new PeticionesServei[num];
        numllist=0;
    }

    public void addS(PeticionesServei s1){
        if(numllist<=LlistaS.length){
            LlistaS[numllist]=s1.copia();
            numllist++;
        }
    }

    public boolean contestarS(PeticionesServei s1, boolean resposta){
        int i=0, pos=0;
        boolean trobat=false,contestado=false;
        while (i < numllist && !trobat){
            if (LlistaS[i].equals(s1)) {
                trobat = true; pos=i; contestado=true;
            }
            i++;
        }
        LlistaS[pos].contestarS(s1,resposta);
        return contestado;
    }

    public int buscarPeticio (String nomClient){
        int i=0;
        while (i<LlistaS.length){
            if(LlistaS[i].getUsuari_petic().equals(nomClient))
                return i;
        }
        i=-1;
        return i;
    }

    public PeticionesServei[] getLlistaS(){ return LlistaS;}
    public int getNumllist(){return numllist;}
}
