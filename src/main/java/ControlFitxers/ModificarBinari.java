package ControlFitxers;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;


public class ModificarBinari extends ObjectOutputStream {
    /* hereda de esta clase para añadir binarios al archivo*/

    public ModificarBinari(OutputStream out) throws IOException{
        super(out);
        /* personalizar excepcion añadiendo constructor*/


    }
    public ModificarBinari() throws IOException, SecurityException{
        /* otro constructor , sirve para poder lanzar una excepcion a un metodo*/
    }

    protected void writeStreamHeader() throws IOException{
        super.writeStreamHeader();
        reset();
    }
    /* para añadir el  texto sin borrar el anterior
    * reset de la cabezera para añadir continuamente */


}
