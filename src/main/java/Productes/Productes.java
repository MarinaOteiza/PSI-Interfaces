package Productes;

import appUsr.RegUser;
import ControlFitxers.Data;

public class Productes {
        private int codi;
        private String descripcion;
        private Data oferta;
        private RegUser usuari;
        private String tipus;


        public Productes(int cod, String desc, Data off, RegUser usu, String typ) {
            codi= cod;
            descripcion= desc;
            oferta= off;
            usuari= usu;
            tipus= typ;

        }
        public Productes(){

        }

        public int GetCod() {
            return codi
                    ;
        }

        public String getDescripcion() {
            return descripcion;
        }
        public Data getOferta() {
            return oferta;
        }

        public RegUser getUsuari() {
            return usuari;
        }

        public String getTipus() {
            return tipus;
        }



    }

}
