package Peticiones;

//ÀITOR OLIVARES PERUCHO
public class PeticioFisic {
    private String peticio_interc;
    private String usuari_petic;
    private int valoracio_usuari;
    private int valoracio_usupetic;
    private boolean petic_pendent;
    private boolean peticio_AoD;            //Peticio acceptada o denegada

    public PeticioFisic(String petiint, String usupeti){
        peticio_interc=petiint;
        usuari_petic=usupeti;
        valoracio_usuari=0;
        valoracio_usupetic=0;
        peticio_AoD=false;
        petic_pendent=true;
    }

    public PeticioFisic copia(){
        PeticioFisic pf= new PeticioFisic(this.peticio_interc, this.usuari_petic);
        return pf;
    }

    public void contestarF(PeticioFisic f1, boolean AoD){
        if(AoD==true){
            f1.peticio_AoD=true;
        }
    }

    public void valoracioFU(int valUsu){
        valoracio_usuari=valUsu;
    }

    public void valoracioFC(int valClient){
        valoracio_usupetic=valClient;
    }

    public boolean getPeticioAoD(){
        return(peticio_AoD);
    }

    public String getPeticio_interc(){return peticio_interc;}

    public String getUsuari_petic(){ return  usuari_petic;}

    public boolean getPeticPendent(){return petic_pendent;}
}
