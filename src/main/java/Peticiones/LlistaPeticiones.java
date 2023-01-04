package Peticiones;
import Main.Main;
import Productes.*;


//ÀITOR OLIVARES PERUCHO

public class LlistaPeticiones {
    private Peticiones LlistaP[];
    private int numllist;
    private Main finestra;

    public LlistaPeticiones(int num){
        LlistaP= new Peticiones[num];
        numllist=0;
    }

    public void addP(Peticiones p1){
        if(numllist<=LlistaP.length){
            LlistaP[numllist]=p1.copia();
            numllist++;
        }
    }

    public void subP(Peticiones p1){
        boolean trobat=false;
        int j=0, pos=0;
        if(numllist>0){
            while(!trobat && j<numllist) {
                if (LlistaP[j].equals(p1)) {
                    trobat = true;
                    pos = j;
                }
                j++;
            }
            if(trobat){
                int i=0;
                for(i=pos; i<numllist-1; i++){
                    LlistaP[i]=LlistaP[i+1];
                }
                i++;
                LlistaP[i]=LlistaP[i+1];
                numllist--;
            }

        }
    }

    public int getNumllist(){
        return numllist;
    }

    public Peticiones getLlistaPos(int i){
        return LlistaP[i];
    }

    public void setLlistaPos(int i, Peticiones p){
        LlistaP[i]=p.copia();
    }

    public Peticiones[] getLlistaPeticions(){
        return LlistaP;
    }

    public Peticiones copia(LlistaPeticiones llist, int i){
        return this.LlistaP[i]= llist.LlistaP[i];
    }

    public LlistaPeticiones copiaL(){
        LlistaPeticiones llista= new LlistaPeticiones(100);
        for(int i=0; i<this.numllist; i++){
            llista.LlistaP[i]=this.LlistaP[i];
        }
        llista.numllist=this.numllist;
        return llista;
    }

    public int trobatPeticion(Peticiones p){
        boolean trobat=false;
        int i=0;
        while (!trobat && i<numllist){
            if(LlistaP[i].equals(p)){
                return i;
            }
            i++;
        }
        return -1;
    }

    public int trobatPeticion(Productes p){
        boolean trobat=false;
        int i=0;
        while (!trobat && i<numllist){
            if(LlistaP[i].getProducte().equals(p.getNom())){
                return i;
            }
            i++;
        }
        return -1;
    }

    public void mostrarPeticPendents(Main finestra){
        System.out.println("A continuacion se mostrara tus productos con sus peticiones.");
        for(int i=0; i<numllist; i++){
            String FoS= LlistaP[i].getProducte().getTipus_product();
            if(FoS.equals("Fisico")){
                PeticioFisic[] llistF = ((LlistaPeticionesFisic)LlistaP[i]).getLlistaF();
                int numllist= ((LlistaPeticionesFisic)LlistaP[i]).getNumllist();
                for(int j=0; j<numllist;j++){
                    if(llistF[j].getPeticPendent()==true)
                        finestra.area.append("Producto: "+LlistaP[i].getProducte().getNom()+ "--> Alias: "+llistF[j].getUsuari_petic()+ "Intercambio: "+llistF[j].getPeticio_interc());
                }
            }else{
                PeticionesServei[] llistS = ((LlistaPeticionesServei)LlistaP[i]).getLlistaS();
                int numllist= ((LlistaPeticionesServei)LlistaP[i]).getNumllist();
                for(int j=0; j<numllist;j++){
                    if(llistS[j].getPeticPendent()==true)
                        finestra.area.append("Producto: "+LlistaP[i].getProducte().getNom()+ "--> Alias: "+llistS[j].getUsuari_petic()+ "Intercambio: "+llistS[j].getPeticio_intercS());
                }
            }
        }
    }

    public void mostrarPeticDenegats(Main finestra){
        System.out.println("A continuacion se mostrara tus productos denegados.");
        for(int i=0; i<numllist; i++){
            String FoS= LlistaP[i].getProducte().getTipus_product();
            if(FoS.equals("Fisico")){
                PeticioFisic[] llistF = ((LlistaPeticionesFisic)LlistaP[i]).getLlistaF();
                int numllist= ((LlistaPeticionesFisic)LlistaP[i]).getNumllist();
                for(int j=0; j<numllist;j++){
                    if(llistF[j].getPeticioAoD()==false)
                        finestra.area.append("Producto: "+LlistaP[i].getProducte().getNom()+ "--> Alias: "+llistF[j].getUsuari_petic()+ "Intercambio: "+llistF[j].getPeticio_interc());
                }
            }else{
                PeticionesServei[] llistS = ((LlistaPeticionesServei)LlistaP[i]).getLlistaS();
                int numllist= ((LlistaPeticionesServei)LlistaP[i]).getNumllist();
                for(int j=0; j<numllist;j++){
                    if(llistS[j].getPeticioAoD()==false)
                        finestra.area.append("Producto: "+LlistaP[i].getProducte().getNom()+ "--> Alias: "+llistS[j].getUsuari_petic()+ "Intercambio: "+llistS[j].getPeticio_intercS());
                }
            }
        }
    }

    public void mostrarPeticAcceptats(Main finestra){
        System.out.println("A continuacion se mostrara tus productos aceptados.");
        for(int i=0; i<numllist; i++){
            String FoS= LlistaP[i].getProducte().getTipus_product();
            if(FoS.equals("Fisico")){
                PeticioFisic[] llistF = ((LlistaPeticionesFisic)LlistaP[i]).getLlistaF();
                int numllist= ((LlistaPeticionesFisic)LlistaP[i]).getNumllist();
                for(int j=0; j<numllist;j++){
                    if(llistF[j].getPeticioAoD()==true)
                        finestra.area.append("Producto: "+LlistaP[i].getProducte().getNom()+ "--> Alias: "+llistF[j].getUsuari_petic()+ "Intercambio: "+llistF[j].getPeticio_interc());
                }
            }else{
                PeticionesServei[] llistS = ((LlistaPeticionesServei)LlistaP[i]).getLlistaS();
                int numllist= ((LlistaPeticionesServei)LlistaP[i]).getNumllist();
                for(int j=0; j<numllist;j++){
                    if(llistS[j].getPeticioAoD()==true)
                        finestra.area.append("Producto: "+LlistaP[i].getProducte().getNom()+ "--> Alias: "+llistS[j].getUsuari_petic()+ "Intercambio: "+llistS[j].getPeticio_intercS());
                }
            }
        }
    }
}



