package Productes;

public class Serveis extends Productes{
    private Data dataOf;
    private Data dataInt;
    private String descrip;
    private boolean estat;
    private int intercanvis;
    private Data dataDes;
    private String code;
    private String nom;

    public Serveis(String nom,String code, String descrip, Data dataOf, Data DataDes,String tipus){
        super(nom,code,descrip,dataOf,tipus);
        this.dataDes=null; //creamos una fecha de descativacion
    }

    public Data getDataDes() {
        return dataDes;
    }

    public void setDataDes(Data dataDes) {
        this.dataDes = dataDes;
    }
    /**
     * Método que desactiva un servicio
     *
     */
    public void desactivaProducte(){ estat=false;}

    /**
     * Método que hace la copia del servicio
     *
     * @return duplicado de la instancia del servicio
     */
    public Productes copia() {
        return new Serveis(nom,code,descrip,dataOf,dataDes,"Servicio");
    }
    /**
     * Método que muestra Serevi
     *
     * @return String con toda la información
     */
    public String toString() {
        return "Servei [dataOf="+dataOf+",dataFi=" + dataDes + ", codi=" + code+ ", activacio=" +estat+ ", intercanvis=" +intercanvis;
    }
}