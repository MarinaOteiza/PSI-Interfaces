package Main;

import java.awt.event.*;
import javax.swing.*;

public class ActionMostrarPeticiones implements ActionListener {
    private Main finestra;

    public ActionMostrarPeticiones(Main finestra) {
        this.finestra = finestra;
    }

    // Qu� passa quan es fa "click"?
    public void actionPerformed(ActionEvent evt) {
        // Obtenim la refer�ncia del control que ha provocat l'esdeveniment.
        JButton b = (JButton) evt.getSource();
        // Obtenim el text del bot�.
        String s = b.getText();
        // Enviem el text al TextArea
        finestra.afegirTextArea(s);
    }

}
