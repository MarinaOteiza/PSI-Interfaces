package ControlFitxers;

import Productes.Bienes;
import Productes.LlistaProductes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Fitxer {

    public LlistaProductes LeerBienes(String NomFitxer) throws IOException {
        int MaxLin = 500000;
        LlistaProductes nova = new LlistaProductes(MaxLin);
        Scanner lectura = new Scanner(new File(NomFitxer));
        Scanner part;
        // dividir información del fichero//
        int   dat1;
        String descripcio, frase, nom,codi;
        Data off;
        double ancho, alto, largo, peso;

        while (lectura.hasNext()) {
            frase = lectura.nextLine();
            part = new Scanner(frase);
            part.useDelimiter(";");
            part.useLocale(Locale.ENGLISH);
            nom= part.next();
            codi = part.next();
            descripcio = part.next();
            ancho = part.nextDouble();
            alto = part.nextDouble();
            largo = part.nextDouble();
            peso = part.nextDouble();
            dat1 = part.nextInt();
            off = new Data(dat1);
            Bienes benou = new Bienes(nom, codi, descripcio, off,  ancho, alto, largo, peso,"Fisic");
            nova.afegirProducte(benou);
            lectura.hasNext();

        }
        lectura.close();
        return nova;

    }
    /**
     * Procediment per a llegir un  archiu
     *  passa la informació a  una llista de productes
     * @param NomFitxer : passem el nom del Fitxer que conté la informació
     * @return Nova: LLista de Productes amb la informació
     */

    public LlistaProductes LeerProd(String NomFitxer) throws IOException {
        int MaxLin = 500000;
        LlistaProductes nova = new LlistaProductes(MaxLin);
        Scanner lectura = new Scanner(new File(NomFitxer));
        Scanner part;
        String code, descrip, frase;
        Data dataoff;
        int dt1;
        while (lectura.hasNext()) {
            frase = lectura.nextLine();
            part = new Scanner(frase);
            part.useDelimiter(";");
            part.useLocale(Locale.ENGLISH);
            code = part.next();
            descrip = part.next();
            dt1 = part.nextInt();
            dataoff = new Data(dt1);
            Bienes prod= new Bienes(code,descrip,dataoff,"Fisic")     ;
            nova.afegirProducte(prod);
            lectura.hasNext();
        }
        lectura.close();
        return nova;
    }


    public void ModificaFitxerProd(LlistaProductes n1, String NomFitxer) throws IOException {

        try (BufferedWriter escriptura = new BufferedWriter(new FileWriter(NomFitxer))) {
            int  intercanvis, dat1, dat2;
            String descripcio, frase, codi,nom, tipus;
            String off;
            int i;
            for ( i=0; i<n1.getnumProd(); i++) {
                codi=n1.getList(i).getCode();
                descripcio=n1.getList(i).getDescrip();
                off=n1.getList(i).getofString();
                frase=(codi+";"+descripcio+";" +off+";");
                escriptura.write(frase);
                escriptura.newLine();
            }
            escriptura.close();
        }
    }
    /**
     *Procediment per a escriure una llista de productes a un archiu
     *      * @param NomFitxer : passem el nom del Fitxer que conté la informació
     *      * @param n1: llista de productes
     */
    public LlistaProductes LeerServicios(String NomFitxer) throws IOException {
        int MaxLin = 500000;
        LlistaProductes nova = new LlistaProductes(MaxLin);
        Scanner lectura = new Scanner(new File(NomFitxer));
        Scanner part;
        // dividir información del fichero//
        int codi, intercanvis, dat1, dat2, dt3;
        String descripcio, frase;
        Data off, Inter, Des;
        boolean estat;

        while (lectura.hasNext()) {
            frase = lectura.nextLine();
            part = new Scanner(frase);
            part.useDelimiter(";");
            part.useLocale(Locale.ENGLISH);
            codi = part.nextInt();
            descripcio = part.next();
            estat = part.nextBoolean();
            intercanvis = part.nextInt();
            dat1 = part.nextInt();
            dat2 = part.nextInt();
            dt3 = part.nextInt();
            off = new Data(dat1);
            if (dat2 != 0) {
                Inter = new Data(dat2);
            } else Inter = new Data();
            Des= new Data(dt3);
            //Serveis Servei = new Serveis(codi, descripcio, off, Inter, estat, intercanvis,Des,"Servei");
            //nova.afegirProducte(Servei);
            lectura.hasNext();
        }
        lectura.close();
        return nova;
    }

/**
 * Procediment per a llegir un archiu
 *  passa la informació a  una llista de productes
 * @param NomFitxer : passem el nom del Fitxer que conté la informació
 * @return Nova: LLista de Productes amb la informació
 */

}