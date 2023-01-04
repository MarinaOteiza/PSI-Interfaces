package dataUsr;
import Peticiones.*;
import Productes.*;
import Productes.LlistaProductes;
import java.io.Serializable;
import ControlFitxers.Data;

/**
 *
 * @author Marina Oteiza
 *
 */

public class User implements Serializable {
    private String alias, correo;
    private int codiPost, nProd, nInter;
    private LlistaPeticiones intercamb;
    private LlistaProductes llistaProd;

    public User(String alias, String correo, int cod) {
        this.alias = alias;
        this.correo = correo;
        codiPost = cod;
        nProd = 0;
        nInter = 0;
        intercamb = new LlistaPeticiones(100); //POR AHORA PONEMOS UN TAMAÑO AL AZAR
        llistaProd = new LlistaProductes(500); //500 como max elem
    }

    /**
     * Esta función devuelve una copia del usuario que se le haya pasado
     *
     * @return aux copia de la información del registro de un usuario
     */
    /* Sonia Alfonso: otro constructor para tener más información en el fichero binario*/

    public User copia() {
        User aux = new User(alias, correo, codiPost); //creamos el usuario
        aux.nProd = this.nProd;
        aux.nInter = this.nInter;
        for (int i = 0; i < nProd-1; i++) {
            aux.llistaProd.setProduct(i, llistaProd.getList(i));
        }
        for (int i = 0; i < nInter-1; i++) {
            aux.intercamb.setLlistaPos(i, this.intercamb.getLlistaPos(i));
        }
        return aux;
    }

    /**
     * Busca el producto que tiene el código indicado y devuelve el valor de la posición de la lista
     * en la que se encuentra
     *
     * @param code código del producto que se quiere buscar
     * @return pos=-1 si no se ha encontrado el producto o pos=posición (i)
     * en la que se encuentra el producto en llistaProd[]
     */
    public int prodTrobatInt(String code) {
        //TODO:llamar a función que se encuentre en la classe productos
        //TODO: necesito un getter del codigo en productes o una funcion que busque un producto
        int pos = -1;
        for (int i = 0; i < llistaProd.getnumProd()-1; i++) {
            if (llistaProd.getList(i).getCode().equals(code)){
                pos=i;
                break;
            }
        }
        return pos;
    }

    /**
     * Busca el producto que tiene el código indicado y devuelve un booleano si lo encuentra o no
     *
     * @param code código del producto que se quiere buscar
     * @return trobat si se ha encontrado el código del producto en la lista de productos del usuario
     */
    public boolean prodTrobatBool(String code) { //TODO: esta función se queda aquí
        boolean trobat = false;
        for (int i = 0; i < llistaProd.getnumProd()-1; i++) {
            if (llistaProd.getList(i).getCode().equals(code)){
                trobat=true;
                break;
            }
        }
        return trobat;
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void masProd(){
        nProd++;
    }
    public void menosProd(){
        nProd--;
    }
    public void masIntercamb(){
        nInter++;
    }

    //SETTERS Y GETTERS

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public LlistaProductes getLlistaProd() {
        return llistaProd;
    }
    public LlistaPeticiones getIntercamb() {
        return intercamb;
    }

    public void setLlistaProd(LlistaProductes prod) {
        this.llistaProd = prod;
    }

    public int getCodiPost() {
        return codiPost;
    }

    public void setCodiPost(int codiPost) {
        this.codiPost = codiPost;
    }

    public int getnProd() {
        return nProd;
    }

    public void setnProd(int nProd) {
        this.nProd = nProd;
    }

    public int getnInter() {
        return nInter;
    }

    public void setnInter(int nInter) {
        this.nInter = nInter;
    }
    public Productes getProd(int i){
        return (llistaProd.getList(i));
    }
}