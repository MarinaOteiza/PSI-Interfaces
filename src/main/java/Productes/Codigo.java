package Productes;

import java.util.concurrent.ThreadLocalRandom;
public class Codigo {
    private String[] codigo;
    private int numLlist;
    public Codigo(int i){
        codigo=new String[i];
        numLlist=0;
    }
    public String cadenaAleatoria() {
        int longitud=5;
        // El banco de caracteres
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        // La cadena en donde iremos agregando un carácter aleatorio
        String cadena = "";
        boolean trobat=false;
        while(!trobat){
            for (int i = 0; i < longitud; i++) {
                int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
                char caracterAleatorio = banco.charAt(indiceAleatorio);
                cadena += caracterAleatorio;
            }
            if(noEstaNumCodi(cadena))
                trobat=true;
        }

        return cadena;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        // nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
    private boolean noEstaNumCodi(String i){
        for(int j=0; j<numLlist; j++){
            if(codigo[j].equals(i)){
                return true;
            }
        }
        return false;
    }
}
