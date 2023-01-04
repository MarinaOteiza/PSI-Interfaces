package Main;

import Productes.*;
import dataUsr.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static appUsr.RegUser.*;

public class Main extends JFrame{
    private static final long serialVersionUID = 1L;
    public JTextArea area = new JTextArea(); //Aitor
    private String nomU,correo;                      //Aitor
    private LlistaUser llista;
    private JFrame frame;
    public Main(LlistaUser llista, String nom){
        nomU=nom;
        this.llista=llista;

        JButton button = new JButton("SumarPeticion");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ActionSumarPeticiones d = new ActionSumarPeticiones(llista,frame);
            }
        });
        JButton button2 = new JButton("Responder Usuario");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ActionResponderUsu r = new ActionResponderUsu(llista);
            }
        });
        JButton button3 = new JButton("Responder Cliente");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ActionResponderCliente rc = new ActionResponderCliente(llista);
            }
        });
        JButton button4 = new JButton("Mostrar Peticiones");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
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
        JLabel nom = new JLabel("Introduce tu nombre de usuario: ");
        JTextField nomF = new JTextField(30);
        nomF.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomU= nomF.getText();
                if(!llista.usuarioRegistrado(nomU))
                    nomF.setText("Introduce de nuevo el usuario.");
            }
        });
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
    public static void main(String[] args) {
        LlistaUser llista = new LlistaUser(100);
        new Main(llista, null); //TODO ÁITOR: ya llamo a Main() desde mi interfaz
    }

}
