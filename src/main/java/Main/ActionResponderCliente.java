package Main;

import dataUsr.LlistaUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static appUsr.RegUser.MostrarProductes;
import static appUsr.RegUser.responderPeticionesCliente;

public class ActionResponderCliente extends JDialog {
    private static final long serialVersionUID = 1L;
    private JLabel nom,nomC, prod, info;
    private JTextField nomF,nomFC, prodF;
    private String nomU, prodU,nomUC;
    private JFrame frame;
    JPanel controls = new JPanel();
    JPanel preg= new JPanel();
    private boolean ok;
    public ActionResponderCliente(LlistaUser llista, JFrame frame, String nomM){
        frame = new JFrame("Responder peticion");
        info = new JLabel("-Introduce tu informacion personal-");
        this.nomUC=nomM;
        nom = new JLabel("¿Cual es el usuario que enviaste una propuesta? ");
        nomF = new JTextField(30);
        nomF.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomU= nomF.getText();
                if(!llista.usuarioRegistrado(nomU))
                    nomF.setText("Introduce de nuevo el usuario.");
            }
        });
        MostrarProductes(nomU, llista);
        prod = new JLabel("Introduce el codigo: ");
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
        controls.add(nom);
        controls.add(nomF);
        controls.add(prod);
        controls.add(prodF);

        JButton acceptar = new JButton("Acceptar");
        JButton cancelar = new JButton("Cancelar");
        acceptar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok = true;
                setVisible(false);
                responderPeticionesCliente(llista,nomU,prodU,nomUC);
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