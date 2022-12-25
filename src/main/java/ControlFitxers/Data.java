package ControlFitxers;

public class Data {
        /*Sonia */

        private int dia;
        private int mes;
        private int any;

        /**
         * Constructor  */

        public Data() {
            this.dia = 1;
            this.mes = 1;
            this.any = 2000;
        }

        /**
         * Constructor que rep la data per parametre
         */
        public Data(int dia, int mes, int any) {
            this.dia = dia;
            this.mes = mes;
            this.any = any;

        }


        /**
         * Getter
         * @return dia de la data
         */

        public Data(int numD) {
            int i= 2;
            String s= Integer.toString (numD);
            this.dia=Integer.parseInt(s.substring(0, i));
            this.mes=Integer.parseInt(s.substring(i, i+2));
            this.any=Integer.parseInt(s.substring(i+2,i+6 ));
        }

        public int getDia() {
            return dia;
        }

        /**
         * Getter
         * @return mes de la data
         */
        public int getMes() {
            return mes;
        }

        /**
         * Getter
         * @return any de la data
         */
        public int getAny() {
            return any;
        }

        /**
         * Setter conjunt per a poder validar la correctesa de la data rebuda.
         * Nomes es fa la modificacio de la data si que es rep per parametre es correcte.
         * @param dia
         * @param mes
         * @param any
         */

        public void setData(int dia, int mes, int any) {
            if (esDataCorrecta(dia, mes, any)) { // ens asegurem que hi ha una data valida
                this.dia = dia;
                this.mes = mes;
                this.any = any;
            }
        }

        /**
         * Metode que calcula sobre la instancia actual el valor del dia seguent
         */
        public void diaSeguent() {
            this.dia++;
            if (this.dia > diesMes(this.mes, this.any)) {
                this.dia = 1;
                this.mes++;
                if (this.mes > 12) {
                    this.mes = 1;
                    this.any++;
                }
            }
        }

        /**
         * Metode que calcula sobre la instancia actual el valor del dia anterior
         */
        public void diaAnterior() {
            this.dia--;
            if (this.dia < 1) {
                this.mes--;
                if (this.mes < 1) {
                    this.mes = 12;
                    this.any--;
                }
                this.dia = diesMes(this.mes, this.any);
            }
        }

        /**
         * Metode que comprova si la data actual es la mateixa a la que es rep per parametre
         * @param data - valor de data a comparar amb l'actual
         * @return si son iguals
         */
        public boolean esIgual(Data data) {
            if (this.dia == data.getDia() && this.mes == data.getMes() && this.any == data.getAny()) {
                return true;
            }
            return false;
        }

        /**
         * Metode que calcula quants dies falten per arribar des de la data actual a la
         * que rebem per parametre
         *
         * @param data - valor de data a la que calcular el numero de dies que falten
         * @return si la data que es rep per parametre es superior o igual a la data de
         *         la instancia sobre la que es crida el metode es retorna el numero de
         *         dies. Si la data que es rep per parametre es inferior es retorna -1.
         */
        public int numDiesAData(Data data) { // compta el nombre de dies entre dos dates
            Data dataTemp;
            int contador;
            // es necessari una nova instancia per no modificar la data actual
            dataTemp = new Data(dia, mes, any);
            if (dataTemp.esDataInferiorOigual(data)) {
                contador = 0;
                // la data rebuda es major que l'actual
                while (!dataTemp.esIgual(data)) {
                    dataTemp.diaSeguent(); // augmenta la data actual fins coincidir amb la rebuda per parametre
                    contador++;
                }
            } else
                contador = -1;
            return contador;
        }

        /**
         * Metode per comprova si la data actual es inferior a la passada per parametre
         *
         * @param nova
         * @return
         */
        public boolean esDataInferiorOigual(Data nova) {
            boolean esInferior;
            if (any<nova.any) esInferior=true;
            else if (any>nova.any) esInferior=false;
            else {
                // cas anys iguals
                if (mes<nova.mes) esInferior=true;
                else if (mes>nova.mes) esInferior=false;
                else {
                    // anys i mes iguals
                    if (dia<=nova.dia) esInferior=true;
                    else esInferior=false;
                }
            }
            return esInferior;

        }

        /**
         * Metode que comprova si la data actual correspon a un any de traspas
         * @return si es any de traspas
         */
        public boolean esDataAnyTraspas() {
            if (esAnyTraspas(this.any)) { // nomes amb l'any hi ha prou
                return true;
            } else {
                return false;
            }
        }

        // Metodes de classe (STATIC).
        // no s'apliquen sobre el contingut d'una instancia de data sino sobre valors
        // que es reben per parametre.
        // son metodes auxiliars

        private static boolean esDataCorrecta(int dia, int mes, int any) {
            boolean hoEs=true;
            if (dia < 1 || dia > 31) { // dia incorrecte
                hoEs= false;
            }
            if (mes < 1 || mes > 12) { // mes incorrecte
                hoEs= false;
            }
            if (dia > diesMes(mes, any)) { // dia del mes incorrecte
                hoEs= false;
            }
            return hoEs;
        }

        private static boolean esAnyTraspas(int any) { // ens estalviem crear una instancia de data
            if ((any % 4 == 0) && ((any % 100 != 0) || (any % 400 == 0))) {
                return true;
            } else {
                return false;
            }
        }

        private static int diesMes(int mes, int any) { // per saber quants dies te un mes d'un any
            int diesMes;
            if (mes == 2) {
                if (esAnyTraspas(any)) {
                    diesMes = 29;
                } else {
                    diesMes = 28;
                }
            } else {
                if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    diesMes = 30;
                } else {
                    diesMes = 31;
                }
            }
            return diesMes;
        }

        public String toString() {
            return(""+dia+""+mes+""+any);
        }

        public Data copia() {
            return new Data(dia, mes, any);
        }
    }


