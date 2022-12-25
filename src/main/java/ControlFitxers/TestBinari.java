package ControlFitxers;

import dataUsr.User;

import java.io.*;

public class TestBinari {
    @SuppressWarnings("unused")
    public void AddBinario() throws IOException {
        try {
            int i = 15;
            FileOutputStream archivo = new FileOutputStream("usuari.bin", true);

            //OutputStream es una clase abstracta que representa la salida de escritura. //

            ModificarBinari escritura = new ModificarBinari(archivo);
            /* en vez de ObjectOutputStream podremos añadir seguidamente
            sin borrar texto
             */

            escritura.writeObject(new User(15, "sonia"));
            System.out.println("añadido");
            escritura.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }


    }

    public void escribirBinario() throws IOException {
        try {
            int i = 15;
            FileOutputStream archivo = new FileOutputStream("usuari.bin");

            //OutputStream es una clase abstracta que representa la salida de escritura. //

            ObjectOutputStream escritura = new ObjectOutputStream(archivo);

            escritura.writeObject(new User(15, "sonia"));
            System.out.println("añadido");
            escritura.close();


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }


    }


    /* escribirBinario ha de ir antes de AddBinario, ha de existir texto para añadirlo*/

    public void leerBinario() throws ClassNotFoundException {
        User u = new User();
        try {
            FileInputStream archivo = new FileInputStream("usuari.bin");
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

}




