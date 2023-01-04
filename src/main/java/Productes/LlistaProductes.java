package Productes;
import ControlFitxers.Data;

public class LlistaProductes  {
    public Productes[] llista1;
    public int nElem;

    public LlistaProductes(int elem){
        nElem=0;
        llista1= new Productes[elem];
    }
    /**
     * Método que permite mostrar por pantalla LlistaProductes
     *
     * @return String con toda la informacion de la lista
     */
    public String toString() {
        String aux = "LLista Productes => Producte: " + nElem;
        for (int j = 0; j < nElem; j++) {
            aux = aux + "\n\tProducte " + (j + 1) + "\t " + llista1[j];
        }
        return aux;
    }
    public String ProductesString(){
        String aux = "LLista Productes => Producte: ";
        for (int j=0; j<nElem;j++){
            if(llista1[j].isEstat())
                aux =aux+ "\n\tProducte"+(j+1)+"\t"+llista1[j].getNom()+llista1[j].getCode();
        }
        return aux;
    }
    /**
     * Método que añade un servicio al final de la lista
     *
     * @param nuevo contiene lel nuevo producto que queremos añadir
     */
    public void afegirProducte(Productes nuevo) {
        if (nElem >= llista1.length) {
            Productes[]aux = new Productes[llista1.length * 2];
            for (int i = 0; i < nElem; i++)
                aux[i] = llista1[i];
            llista1 = aux;
        }
        llista1[nElem]=nuevo.copia();
        nElem++;
    }

    /**
     * Método que indica cuál es el servicio con mas intercambios
     *
     * @return la copia de la instancia del servicio
     */
    /*public String mesIntercanvis() {
        int numIntercanvis, l = 0,m=0;
        boolean trobat=false;
        while(!trobat&&m<nElem){
            if(llista1[m] instanceof Serveis)
                trobat=true;
            else m++;
        }
        numIntercanvis = llista1[m].getIntercanvis();
        while (m < nElem) {
            if((llista1[m] instanceof Serveis)&& (numIntercanvis <= llista1[m].getIntercanvis())) { //si el numero de inetrcanvis  es inferior al numero de intercanvis de la posicion analizada
                numIntercanvis = llista1[m].getIntercanvis(); //actualizamos el numero de dias max del cartel
                l= m; //guardamos la posicion de numIntercanvis en l
            }
            m++;
        }
        return llista1[l].toString(); //Se muestra por pantalla el servicio (con el mayor numero de intercanvis)
    }
    /** Método que descativa un producto
     *
     * @param code contiene el codigo del producto
     * @param data2 contiene la nueva fecha de desactivacion
     */
   /* public void desactivaServicio( String code,Data data2) {
        for (int n=0; n < nElem; n++) {
            if (llista1[n].getCode( ).equals(code))
                llista1[n].desactivaProducte();
            ((Serveis) llista1[n]).setDataDes(data2);
        }
    }
    public void desactivaBien( String code) {
        for (int n=0; n < nElem; n++) {
            if (llista1[n].getCode( ).equals(code))
                llista1[n].desactivaProducte();
        }
    }

    /** Método que muestra los servicios activos
     *
     * @return String lista con todos los servicios activos
     */
   /* public String mostraServeisActius(  ){
        LlistaProductes aux = new LlistaProductes(nElem);
        int i=0;
        while(i<nElem){
            if((llista1[i] instanceof Serveis)&&(llista1[i].isEstat())){
                aux.afegirProducte(llista1[i]);    //Se desplaza el resto de la lista para eliminarla y no dejar huecos
            }
            i++;
        }
        return aux.toString();
    }*/

    /** Método que muestra los bienes disponibles
     *
     * @return String lista con todos los bienes disponibles
     */
    public String mostraBensActius( ){ //lo dejo por si acaso pero creo que se puede quitar TODO
        LlistaProductes aux = new LlistaProductes(nElem);
        int i=0;
        while(i<nElem){
            if((llista1[i] instanceof Bienes)&&(llista1[i].isEstat())){
                aux.afegirProducte(llista1[i]);    //Se desplaza el resto de la lista para eliminarla y no dejar huecos
            }
            i++;
        }
        return aux.toString();
    }
    /** Método que elimina un producto de la lista siempre y cuando tenga mínimo un intercmabio
     *
     * @param code contiene el código del producto.
     */
    public void eliminaProducto(String code) {
        int i = 0;
        while (i < nElem) {
            if ((llista1[i].getCode().equals(code)) && (llista1[i].getIntercanvis() > 0)) {
                for (int k = i; k < nElem - 1; k++) {      //Si se encuentra el codigo en la lista de productos y tiene algun intercambio
                    llista1[k] = llista1[k + 1];    //Se desplaza el resto de la lista para eliminarlo y no dejar huecos
                }
                nElem--; //Si hemos eliminado un producto, actualizamos el nº de elementos que pasa a tener la lista
            } else i++; //Solo si no encontramos el producto
        }
    }
    /** Método que elimina un producto de la lista siempre y cuando tenga mínimo un intercmabio
     *
     * @return darrer producte de la llista
     */
    public Productes darrerElem( ){
        return llista1[nElem];
    }


    public int getnumProd() {
        return nElem;
    }
    /**
     *@;SoniaAlfonso
     * torna nElements LLista
     */
    public Productes getList(int i) {
        return llista1[i];
    }

    public void setProduct(int i, Productes s) {//TODO: hecho por Marina
        llista1[i]=s;
    }


    /**
     * * @;SoniaAlfonso
     * torna productes de la llista en la posicio i
     */

    /**Retornamos el tipo de producto que es
     *
     * @param code
     * @return codigo del producto uqe se busca
     */
    public String getTipusList(String code){ //TODO:creada por Marina
        int pos=-1;
        for(int i=0; i<this.nElem-1;i++){
            if (llista1[i].getCode().equals(code)){
                pos=i;
                break;
            }
        }
        return (llista1[pos].getTipus_product());
    }

}