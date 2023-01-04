package dataUsr;

import ControlFitxers.Data;
import Peticiones.*;
import Productes.*;
import Productes.LlistaProductes;

import javax.swing.*;

/**
 *
 * @author Marina Oteiza
 *
 */
public class LlistaUser{
    private User[] llista;
    private int nElem;
    private Codigo codi;
    public LlistaUser(int elem){
        nElem = 0;
        llista = new User[elem];
        codi = new Codigo(1000);
    }

    /**Añadimos un nuevo usuario a la lista
     *
     * @param u usuario nuevo que va a ser registrado
     */
    public void nuevoUsr(User u){
        if(nElem==0) {
            llista[nElem]=u.copia();
            nElem++;
        }else {
            if(!usuarioRegistrado(u) && nElem<=llista.length) { //Lo añadimos si el usuario no se ha registrado anteriormente
                llista[nElem]=u.copia();
                nElem++;
            }
        }
    }

    /**Comprobamos si el alias del usuario pasado por parámetro aparece ya en llista[]
     *
     * @param u usuario nuevo que va ser buscado
     * @return trobat true si se ha encontrado, false si no
     */
    public boolean usuarioRegistrado(User u) {
        boolean trobat=false;
        for(int i=0;i<nElem;i++) {
            if(llista[i].getAlias().equals(u.getAlias())){
                trobat=true;
                break;
            }
        }
        return(trobat);
    }

    /**Comprobamos si el alias del usuario pasado por parámetro aparece ya en llista[]
     *
     * @param alias que se quiere comprobar
     * @return trobat true si se ha encontrado, false si no
     */
    public boolean usuarioRegistrado(String alias) {
        boolean trobat=false;
        for(int i=0;i<nElem;i++) {
            if(llista[i].getAlias().equals(alias)){
                trobat=true;
                break;
            }
        }
        return(trobat);
    }

    /**Buscamos la posición en la que se encuentra el usuario en llista[]
     *
     * @param alias para saber qué usuario tenemos que buscar
     * @return pos posición del usuario en llista[]
     */
    public int posUsuario(String alias) {
        int pos=0;
        for(int i=0;i<nElem;i++) {
            if(llista[i].getAlias().equals(alias)) pos=i;
        }
        return pos;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**Añadimos un intercambio a un usuario
     *
     * @param alias para saber qué usuario tenemos que modificar
     * @param inter intercambio que se quiere añadir
     * @return correcto true si se ha podido añadir, false si no
     */
    public boolean nuevoIntercambio(String alias, Peticiones inter) {//TODO: esta funcion sigue teniendo que ser así????
        boolean correcto=false;
        int pos;
        if(this.usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            llista[pos].getIntercamb().addP(inter);
            llista[pos].masIntercamb();
            correcto=true;
        }
        return correcto;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Esta función añade un nuevo producto: bien al usuario indicado
     *
     * @param nom nombre del producto
     * @param code código del producto
     * @param descripcion del producto
     * @param peso del bien y sus dimensiones (alto, largo, ancho)
     * @param data1 fecha en la que se publica el producto
     */
    public void nouBe(String alias, String nom, String code, String descripcion, Data data1, double alto, double largo, double ancho, double peso){
        Bienes b = new Bienes(nom, code, descripcion, data1, ancho, alto, largo, peso,"Fisic");
        int pos=this.posUsuario(alias);
        llista[pos].getLlistaProd().afegirProducte(b);
        llista[pos].masProd();
    }


   /* public void nouServei(String alias, String nom, String code, String descripcion, Data data1, Data data2){
        Serveis s = new Serveis(nom, code, descripcion, data1, data2, "servicio");
        int pos=this.posUsuario(alias);
        llista[pos].getLlistaProd().afegirProducte(s);
        llista[pos].masProd();
    }*/

    public boolean compProd(String alias, String code){
        return(llista[this.posUsuario(alias)].prodTrobatBool(code));//TODO: esperar a getter
    }

    /**Quitamos el bien que el usuario indica, teniendo en cuanta que no haya sido anteriormente intercambiado
     *
     * @param alias nombre del usuario
     * @param codigo del srevicio a desactivar
     */
    public void quitaBien(String alias, String codigo){
        int pos=this.posUsuario(alias);
        llista[pos].getLlistaProd().eliminaProducto(codigo);
        llista[pos].menosProd();
    }

    /**Desactivamos el servicio de un usuario (aquel que ha introducido por consola)
     *
     * @param alias nombre del usuario
     * @param codigo del srevicio a desactivar
     * @param data2 fecha del día en que se desactiva el servicio
     */
    /*public void desactServicio(String alias, String codigo, Data data2){
        llista[this.posUsuario(alias)].getLlistaProd().desactivaServicio(codigo, data2);
    }*/

    /**Printamos los productos del usuario indicado
     *
     * @param alias nombre del usuario
     */
    public String prodActToString(String alias) {
        return llista[this.posUsuario(alias)].getLlistaProd().ProductesString();
    }

    public String getTipusProducte(String alias, String code) {//
        int i = 0, j = 0;
        int pos=this.posUsuario(alias);
        return (llista[pos].getLlistaProd().getTipusList(code));
    }


    //SETTERS Y GETTERS

    public int getPosicionPeticionLlista(String alias, Productes p){
        int pos=0;
        if(this.usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            return llista[pos].getIntercamb().trobatPeticion(p); //TODO: a que funcion quieres llamar? getIntercamb();???
        }
        return 0;
    }



    public Peticiones getPeticionLlista(String alias, int i){
        int pos=0;
        if(this.usuarioRegistrado(alias)) {
            pos= this.posUsuario(alias);
            return llista[pos].getIntercamb().getLlistaPos(i); //TODO: a que funcion quieres llamar? getIntercamb();???
        }
        return null;
    }
    public User[] getLlista() {
        return llista;
    }


    public void setLlista(User[] llista) {
        this.llista = llista;
    }


    public int getnElem() {
        return nElem;
    }


    public void setnElem(int nElem) {
        this.nElem = nElem;
    }

    public Codigo getCodigo(){return codi;}

    public Productes getLlistaProd(int i, String code){
        int j=0;
        try{
            while(j<llista[i].getnProd()){
                if (llista[i].getProd(j).getCode().equals(code))
                    return (llista[i].getProd(j));
            }
            return (llista[i].getProd(0));
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "No hay productos", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR");
        }
        return  null;
    }

}
