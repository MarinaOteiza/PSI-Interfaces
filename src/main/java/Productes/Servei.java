//Aina Goñalons

package Productes;

public class Servei {

    private Data dataFi;		// ultima data d'activacio servei
    private String titol;
    private boolean estat;
    private int intercanvis;

    public Servei(Data dataFi, String titol, boolean estat, int intercanvis) {

        this.dataFi=dataFi;
        this.titol=titol;
        this.estat=estat;
        this.intercanvis=intercanvis;
    }

    /** getter que obtiene la fecha final
     *
     * @return fecha final
     */
    public Data getDataFi() {
        return dataFi;
    }
    /** getter que obte el nombre de intercanvis
     *
     * @return intercanvis
     */
    public int getIntercanvis() {
        return intercanvis;
    }
    /** getter que obte el estado de activacion
     *
     * @return estat
     */
    public boolean getEstat( ) {
        return estat;
    }

    /** Método que hace la copia de Servei
     *
     * @return duplicado de la instancia de Servei
     */
    public Servei copia() {
        return (new Servei(dataFi, titol,estat,intercanvis));
    }

    /** Método que muestra Serevi
     *
     * @return String con toda la información
     */
    public String toString() {
        return "Servei [dataFi=" + dataFi + ", titol=" + titol+ ", activacio=" +estat+ ", intercanvis=" +intercanvis;
    }
    /** Mètode que desactiva un servei
     *
     */
    public void desactivaServei( ) {
        estat=false;
    }
    /** Mètode que canvia la data final del servei
     *
     * @param data2 conté la data final
     */
    public void canviaData (Data data2 ){
        dataFi=data2;
    }
    /** Método que comprueba si el servicio tiene ese titulo
     *
     * @param titol contiene el titulo
     * @return true (se ha encontrado el titulo) o false(no se ha encontrado el titulo)
     */
    public boolean esTrobaEnAquestTitol(String titol) {
        return this.titol.equalsIgnoreCase(titol);
    }


}
