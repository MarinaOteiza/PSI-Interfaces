package Main;

import Productes.Productes;
import dataUsr.LlistaUser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static appUsr.RegUser.MostrarProductes;
import static appUsr.RegUser.responderPeticiones;

public class ActionResponderUsu extends JDialog {
    private static final long serialVersionUID = 1L;
    private JLabel nom, prod, info;
    private JTextField nomF, prodF;
    private String nomU, prodU;
    private JFrame frame;
    JPanel controls = new JPanel();
    JPanel preg= new JPanel();
    private boolean ok;
    public ActionResponderUsu(LlistaUser llista, JFrame frame, String nomM){
        super(frame,"Responder peticion");
        info = new JLabel("-Introduce tu informacion personal-");
        this.nomU=nomM;
        MostrarProductes(nomU, llista);
        prod = new JLabel("Introduce el codigo de tu producto: ");
        prodF = new JTextField(50);
        prodF.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prodU= prodF.getText();
                if (!llista.compProd(nomU, prodU))
                    prodF.setText("Introduce de nuevo el codigo.");
            }
        });
        ok=false;

        preg.setLayout(new BorderLayout());
        preg.add(info, BorderLayout.NORTH);

        controls.setLayout(new GridLayout(4,2));
        controls.add(prod);
        controls.add(prodF);

        JButton acceptar = new JButton("Acceptar");
        JButton cancelar = new JButton("Cancelar");
        acceptar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok = true;
                setVisible(false);
                responderPeticiones(llista,nomU,prodU);
            }
        });
        cancelar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok = false;
                setVisible(false);
            }
        });

        // Creem un contenidor on posarem els botons Acceptar/Cancelar.
        JPanel botons = new JPanel(new FlowLayout());
        botons.add(acceptar);
        botons.add(cancelar);

        Container cont = getContentPane();
        cont.add(controls, BorderLayout.CENTER);
        cont.add(preg, BorderLayout.NORTH);
        cont.add(botons, BorderLayout.SOUTH);


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pack();
        setVisible(true);
    }

}