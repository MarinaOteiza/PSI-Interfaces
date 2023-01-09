package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import dataUsr.*;
import static appUsr.RegUser.MostrarProductes;
import static appUsr.RegUser.nuevaPeticion;

public class ActionSumarPeticiones extends JDialog {
    private static final long serialVersionUID = 1L;
    private JLabel nom, prod, info, infoC, nomC, prodC;
    private JTextField nomF, prodF,prodFC, nomFC;
    private String nomU, prodU,nomFU,prodFU;
    private JFrame frame;
    JPanel controls = new JPanel();
    JPanel controls2 = new JPanel();
    JPanel preg= new JPanel();
    JPanel preg2= new JPanel();
    private boolean ok;
    private Container cont, cont2;


    public ActionSumarPeticiones(LlistaUser llista, JFrame frame, String nomM){
        super(frame, "Introducir Peticion");
        info = new JLabel("-¿Cual es el usuario con quien quieres intercambiar y su producto?-");
        nom = new JLabel("Introduce el nombre del usuario: ");
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
                controls.setVisible(false);
                acceptar.setVisible(false);
                cancelar.setVisible(false);
                continuarAction(llista,nomM);
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

        cont = getContentPane();
        cont.add(controls, BorderLayout.CENTER);
        cont.add(preg, BorderLayout.NORTH);
        cont.add(botons, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setModal(true);
        setVisible(true);
    }

    private void continuarAction(LlistaUser llista,String nomM){
        frame = new JFrame("Introducir nueva peticion");
        infoC = new JLabel("-Introduce tu informacion-");
        this.nomFU=nomM;
        prodC = new JLabel("Introduce el producto que quieres intercambiar: ");
        prodFC = new JTextField(50);
        prodFU= prodFC.getText();

        ok=false;

        preg2.setLayout(new BorderLayout());
        preg2.add(info, BorderLayout.NORTH);

        controls2.setLayout(new GridLayout(4,2));
        controls2.add(prodC);
        controls2.add(prodFC);

        JButton acceptar2 = new JButton("Acceptar");
        JButton cancelar2 = new JButton("Cancelar");
        acceptar2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok = true;
                nuevaPeticion(llista,nomU, prodU,nomFU,prodFU);
            }
        });
        cancelar2.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ok = false;
                setVisible(false);
            }
        });

        // Creem un contenidor on posarem els botons Acceptar/Cancelar.
        JPanel botons = new JPanel(new FlowLayout());
        botons.add(acceptar2);
        botons.add(cancelar2);
        botons.updateUI();

        cont2 = getContentPane();
        cont2.add(controls2, BorderLayout.CENTER);
        cont2.add(preg2, BorderLayout.NORTH);
        cont2.add(botons, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
//TODO: bucle -> this.add(new JButton("producto.getCode()"))