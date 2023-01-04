package ControlFitxers;

import dataUsr.User;

import java.io.*;

public class TestBinari {
    @SuppressWarnings("unused")
    public void AddBinario(String NomFitxer, User u1) throws IOException {
        try {
            FileOutputStream archivo = new FileOutputStream(NomFitxer, true);
            /* si no ponemos true nos puede dar error*/

            //OutputStream es una clase abstracta que representa la salida de escritura. //

            ModificarBinari escritura = new ModificarBinari(archivo);
            /* en vez de ObjectOutputStream podremos añadir seguidamente sin borrar el texto
            Classe a parte creada para poder añadir cambiando la cabezera sin borrar el contenido del archivo
             */

            escritura.writeObject(new User(u1.getAlias(), u1.getCorreo(), u1.getCodiPost()));
            System.out.println("añadiendo usuarios ....");
            escritura.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }


    }
    /* Se pasa El usuario que se quiere escribir en el fichero binario
    y el nombre de esto
    @param NomFitxer: fichero donde se escribirá
    @param u1: usuario
    Ha de existir texto para que este procedimiento no de error
     */

    public void escribirBinario(String NomFitxer, User u1) throws IOException {
        try {
            FileOutputStream archivo = new FileOutputStream(NomFitxer);

            //OutputStream es una clase abstracta que representa la salida de escritura. //

            ObjectOutputStream escritura = new ObjectOutputStream(archivo);

            escritura.writeObject(new User(u1.getAlias(), u1.getAlias(), u1.getCodiPost()));
            System.out.println("escribiendo usuarios...");
            escritura.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }


    }
    /* Se pasa El usuario que se quiere escribir en el fichero binario
    y el nombre de esto
    @param NomFitxer: fichero donde se escribirá
    @param u1: usuario
     */

    /* note: escribirBinario ha de ir antes de AddBinario, ha de existir texto para añadirlo*/

    public void leerBinario(String NomFitxer) throws ClassNotFoundException {
        User u = new User(null, null, 0);
        try {
            FileInputStream archivo = new FileInputStream(NomFitxer);
            ObjectInputStream lectura = new ObjectInputStream(archivo);
            while (true) {
                u = (User) lectura.readObject();
                System.out.println(u.toString());
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException e) {
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /* Se lee el fichero binario de los usuarios
    @param NomFitxer : fichero donde estan los usuarios
    Nota: ha de ser .bin
     */

}




