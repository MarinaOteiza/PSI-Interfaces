package Productes;
import ControlFitxers.Data;
public class Bienes extends Productes{
    private Data dataOf;
    private Data dataInt;
    private String descrip;
    private String code;
    private double ancho;
    private double alto;
    private double largo;
    private double peso;
    private int intercanvis;
    private boolean estat;
    private String nom;

    public Bienes (String nom,String code,String descrip,Data dataOf, double ancho, double alto,double largo,double peso, String tipus){
        super(code,descrip,dataOf,tipus);
        this.alto=alto;
        this.ancho=ancho;
        this.largo=largo;
        this.peso=peso;
    }
    public Bienes (String code,String descrip,Data dataOf,String tipus){
        super(code,descrip,dataOf,tipus);
    }
    public boolean getEstat(){
        return estat;
    }
    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void desactivaProducte() { estat=false;}
    /**
     * Método que hace la copia del bien
     *
     * @return duplicado de la instancia del bien
     */
    public Productes copia() {
        return new Bienes(nom,code,descrip,dataOf,ancho,alto,largo,peso,"Fisic");
    }
    /**
     * Método que muestra un bien
     *
     * @return String con toda la información
     */

    public String toString() {
        return "Servei [dataOf="+dataOf+",dataInt="+dataInt+ ", codi=" + code+ ", activacio=" +estat+ ", intercanvis=" +intercanvis;
    }



}