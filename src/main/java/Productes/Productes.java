package Productes;
import ControlFitxers.Data;

public abstract class Productes {
    private Data dataOf; //fecha de la oferta
    private Data dataInt; //fecha del intercambio
    private String descrip;   //descripcion del producto
    private String code;        //codigo del producto
    private boolean estat;
    private int intercanvis;
    private String nom;

    private boolean productTienePeticion;

    private String tipus_product;       // Fisic o Servei

    public Productes(String code, String descrip, Data dataOf,String tipus) {
        this.code=code;
        this.nom= nom;
        this.descrip = descrip;
        this.dataOf = dataOf;
        this.estat = true;              //el producto esta disponible
        this.intercanvis = 0;          //no se ha hecho ningun intercambio
        this.productTienePeticion=false;
        this.tipus_product=tipus;
    }

    /**
     * getter que obtiene la fecha de intercambio de un producto
     *
     * @return dataInt
     */
    public Data getDataInt() {
        return dataInt;
    }
    public String getDataString() {
        return dataInt.toString();
    }

    public void setDataInt(Data dataInt) {
        this.dataInt = dataInt;
    }

    /**
     * getter que obtiene la descripcion de un producto
     *
     * @return descrip
     */
    public String getDescrip() {
        return descrip;
    }

    public void setNom(String nom) {
        this.descrip = nom;
    }

    /**
     * getter que obtiene al fecha de al oferta
     *
     * @return DataOf
     */
    public Data getDataOf() {
        return dataOf;
    }
    public String getofString() {
        return dataOf.toString();
    }

    public void setDataOf(Data dataOf) {
        this.dataOf = dataOf;
    }

    public boolean isEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    /**
     * getter que obtiene el numero de intercambios de un producto
     *
     * @return intercanvis
     */
    public int getIntercanvis() {
        return intercanvis;
    }

    public void setIntercanvis(int intercanvis) {
        this.intercanvis = intercanvis;
    }

    /**
     * añade intercambio
     *
     */
    public void AfegeixIntercanvi() {
        intercanvis++;
    }

    public void setCode(String code) {
        this.code = code;
    }
    /**
     * getter que obte el codigo de un producto
     *
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Métode que desactiva un producto
     */
    public abstract void desactivaProducte();

    /**
     * Método que hace la copia del producto
     *
     * @return duplicado de la instancia de Productes
     */
    public abstract Productes copia();

    /**
     * Método que muestra el producto
     */
    public abstract String toString();

    public void setProductTienePeticion(boolean productTienePeticion) {
        this.productTienePeticion = productTienePeticion;
    }

    public String getTipus_product(){ return tipus_product;}

    public boolean isProductTienePeticion() {return productTienePeticion;}

    public String getNom() {
        return nom;
    }
}



