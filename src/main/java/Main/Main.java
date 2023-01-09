package Main;

import Interfaces.UserInterfaz;
import Productes.*;
import dataUsr.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import static appUsr.RegUser.*;

public class Main extends JFrame{
    private static final long serialVersionUID = 1L;
    public JTextArea area = new JTextArea(); //Aitor
    private String nomU;                      //Aitor
    private LlistaUser llista;
    private JFrame frame;


    public Main(LlistaUser llista, String nom){
        setVisible(false);
        this.llista=llista;
        this.nomU=nom;
        JButton button = new JButton("SumarPeticion");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ActionSumarPeticiones d = new ActionSumarPeticiones(llista,frame,nomU);
            }
        });
        JButton button2 = new JButton("Responder Usuario");
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ActionResponderUsu r = new ActionResponderUsu(llista,frame,nomU);
            }
        });
        JButton button3 = new JButton("Responder Cliente");
        button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ActionResponderCliente rc = new ActionResponderCliente(llista,frame,nomU);
            }
        });
        JButton button4 = new JButton("Mostrar Peticiones");
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                button.setVisible(false);
                button2.setVisible(false);
                button3.setVisible(false);
                button4.setVisible(false);
                MostrarPeticiones(llista);
            }
        });

        JPanel botons = new JPanel(new FlowLayout());

        botons.add(button);
        botons.add(button2);
        botons.add(button3);
        botons.add(button4);

        Container cont = getContentPane();
        cont.add(botons);

        setSize(600,300);
        setVisible(true);
    }
    //===========================MOSTRAR PETICIONES=============================================================================
    public void afegirTextArea(String s) {
        if(s.equals("Pendientes")){
            peticionesPendintes(llista,nomU,this);
        }else{
            if(s.equals("Denegadas")){
                peticionesRechazadas(llista,nomU,this);
            }else{
                if(s.equals("Aceptadas")){
                    peticionesAceptadas(llista,nomU,this);
                }
            }
        }
    }
    public void MostrarPeticiones(LlistaUser llista){
        JPanel panellBotons = new JPanel();
        JButton b1 = new JButton("Pendientes");
        JButton b2 = new JButton("Denegadas");
        JButton b3 = new JButton("Aceptadas");

        // Forcem la disposici� dels objectes que tindr�
        // la finestra principal al tipus "BorderLayout"
        this.setLayout(new BorderLayout());
        // Afegim els dos control al contenidor principal.
        this.add(area, BorderLayout.CENTER);

        // Forcem la disposici� dels objectes continguts en el panell.
        panellBotons.setLayout(new FlowLayout());
        // Afegim els botons al panell.
        panellBotons.add(b1);
        panellBotons.add(b2);
        panellBotons.add(b3);

        // Afegim el panell a la finestra.
        this.add(panellBotons, BorderLayout.NORTH);

        panellBotons.updateUI();

        // Classe de tractar� l'esdeveniment sobre el bot�.
        ActionMostrarPeticiones accioBoto = new ActionMostrarPeticiones(this);
        // Indiquem que cada bot� utilitzi la classe anterior per tractar l'esdeveniment.
        // NOTA: Cada bot� pot tenir una classe diferent per tractar el seu esdeveniment.
        b1.addActionListener(accioBoto);
        b2.addActionListener(accioBoto);
        b3.addActionListener(accioBoto);

        // Necessari per alliberar la mem�ria quan tanquem la finestra.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Forcem les mides de l'objecte contenidor, es a dir, la finestra.
        setSize(600,300);
        // Fem la finestra visible.
        setVisible(true);
    }
    //=====================================================================================================

}
