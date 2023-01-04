package Peticiones;

import Productes.*;

//ÀITOR OLIVARES PERUCHO
public class Peticiones {
    protected String codi;
    protected String usuari;
    protected Productes producte;

    public Peticiones(String codi, String usuari, Productes producte) {
        this.codi = codi;
        this.usuari = usuari;
        this.producte = producte;
    }

    public Productes getProducte() {return producte;}

    public Peticiones copia(){
        Peticiones p= new Peticiones(this.codi, this.usuari, this.producte);
        return p;
    }
}