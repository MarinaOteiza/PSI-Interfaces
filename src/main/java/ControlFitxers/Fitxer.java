package ControlFitxers;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Fitxer {
        public Fitxer() {
            boolean modificat= false;

        }


        public  ListaBienes LeerBienes(String nomFitxer) throws IOException {
            int MaxLin = 10000;
            ListaBienes novallista = new ListaBienes(MaxLin); /* crear lista */

            Scanner lectura =new Scanner(new File(nomFitxer));
            Scanner part;  /* para dividir información */

            String  descripcio, tipus, frase;
            int altura, amplitud, fons,data1,data2, cod;
            float pes;
            Data off, intercanvi;

            /* variables a separar en el fichero*/

            while (lectura.hasNext()) {
                frase=lectura.nextLine();   /* leemos linea por linea*/
                part=new Scanner(frase);
                part.useDelimiter(";");
                part.useLocale(Locale.ENGLISH);

                cod=part.nextInt();
                descripcio=part.next();
                tipus=part.next();
                altura=part.nextInt();
                amplitud=part.nextInt(); /* altura, amplitud, fons en centimetres*/
                fons=part.nextInt();
                pes=part.nextFloat(); /* peso en kg*/

                data1=part.nextInt();
                data2=part.nextInt();

                off= new Data(data1);
                if (data2 != 0) {
                    intercanvi = new Data(data2);
                }
                else intercanvi= new Data();

                Bienes benou= new Bienes(cod, descripcio,tipus, off,altura, amplitud, fons, pes);
                benou.afegirIntercanvi(intercanvi);
                novallista.afegirBien(benou);
                System.out.println(frase);
                lectura.hasNext();
            }

            lectura.close();
            return novallista;
        }
        /* procediment per separar la informació en una llista de bens;
        Va tota la informació del producte;
         /*
         */


        public  void ModFitxerBens(ListaBienes n1) throws IOException {

            try (BufferedWriter escriptura = new BufferedWriter(new FileWriter("DadesBens.txt"))) {
                String descripcio, tipus, frase;
                int altura, amplitud, fons, codi;
                float pes;
                Data off, intercanvi;
                int i;
                for ( i=0; i<n1.getnumBienes(); i++) {

                    codi=n1.getLLista(i).GetCod();
                    descripcio=n1.getLLista(i).GetDesc();
                    tipus=n1.getLLista(i).GetTipus();
                    altura=n1.getLLista(i).GetAlt();
                    amplitud=n1.getLLista(i).GetAmp();
                    fons=n1.getLLista(i).GetFons();
                    pes=n1.getLLista(i).GetPes();
                    off=n1.getLLista(i).GetOff();
                    intercanvi=n1.getLLista(i).GetInt();


                    frase=(codi+";"+descripcio+";"+tipus+";"+altura+";"+amplitud+";"+fons+";"+pes+";"+off+";"+intercanvi+";");
                    escriptura.write(frase);

                    escriptura.newLine();
                }
                escriptura.close();

                /*la informació de la llista es gudrdarà en un fitxer*/
            }
        }

        public LlistaServeis LeerServicios(String nomFitxer) throws IOException {
            int MaxLin = 10000;
            LlistaServeis novallista = new LlistaServeis(MaxLin); /* crear lista */
            Scanner lectura =new Scanner(new File(nomFitxer));
            Scanner part;  /* para dividir información */

            String  titol, frase;
            int intercanvis, dat;
            boolean est;
            Data dataFi;

            /* variables a separar en el fichero*/

            while (lectura.hasNext()) {
                frase=lectura.nextLine();   /* leemos linea por linea*/
                part=new Scanner(frase);
                part.useDelimiter(";");
                part.useLocale(Locale.ENGLISH);
                titol=part.next();
                intercanvis=part.nextInt();
                est= part.nextBoolean();
                dat=part.nextInt();
                dataFi= new Data();
                Servei serveinou= new Servei(dataFi, titol, est, intercanvis);
                novallista.afegirServei(serveinou);
                System.out.println(frase);
                lectura.hasNext();
            }

            lectura.close();
            return novallista;
        }


    public  void ModFitxerServeis(LlistaServeis n1, String NomFitx) throws IOException {

        try (BufferedWriter escriptura = new BufferedWriter(new FileWriter(NomFitx))) {
            String descripcio, tipus, frase;
            int altura, amplitud, fons, codi;
            float pes;
            Data off, intercanvi;
            int i;
            for ( i=0; i<n1.getnumBienes(); i++) {

                codi=n1.getLLista(i).GetCod();
                descripcio=n1.getLLista(i).GetDesc();
                tipus=n1.getLLista(i).GetTipus();
                altura=n1.getLLista(i).GetAlt();
                amplitud=n1.getLLista(i).GetAmp();
                fons=n1.getLLista(i).GetFons();
                pes=n1.getLLista(i).GetPes();
                off=n1.getLLista(i).GetOff();
                intercanvi=n1.getLLista(i).GetInt();


                frase=(codi+";"+descripcio+";"+tipus+";"+altura+";"+amplitud+";"+fons+";"+pes+";"+off+";"+intercanvi+";");
                escriptura.write(frase);

                escriptura.newLine();
            }
            escriptura.close();
         }
    }






}




