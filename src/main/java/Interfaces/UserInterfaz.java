package InterfaceUser;

import dataUsr.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class UserInterfaz extends JFrame {
    private JPanel panellBotons = new JPanel();
    private JButton b1 = new JButton("Log In");
    private JButton b2 = new JButton("Registrarse");
    private String nom, correo;
    private int codiPostal;

    public UserInterfaz() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));


        panellBotons.setLayout(new FlowLayout());
        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        panellBotons.add(b1); // Afegim els botons al panell
        panellBotons.add(b2);
        this.add(panellBotons, BorderLayout.CENTER);
        MouseListener click=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                panellBotons.remove(b1);
                panellBotons.remove(b2);
                if (e.getSource() == b1){
                    pedirAlias();
                }
                else{
                    newRegister();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == b1)
                    b1.setBackground(Color.WHITE);
                else
                    b2.setBackground(Color.WHITE);

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == b1)
                    b1.setBackground(Color.PINK);
                else
                    b2.setBackground(Color.PINK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == b1)
                    b1.setBackground(Color.WHITE);
                else
                    b2.setBackground(Color.WHITE);
            }
        };


        b1.addMouseListener(click);
        b2.addMouseListener(click);
        setSize(400,400);
        //setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void newRegister() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        JButton fin= new JButton("Siguiente");
        this.add(fin);
        JLabel j=new JLabel(" ");
        this.add(j, BorderLayout.SOUTH);

        JLabel etiqueta1 = new JLabel("Indica tu alias ");
        this.add(etiqueta1);
        JTextField nom1 = new JTextField(25);
        this.add(nom1);

        JLabel etiqueta2 = new JLabel("Indica el tu correo electronico ");
        this.add(etiqueta2);
        JTextField nom2 = new JTextField(25);
        this.add(nom2);


        JLabel etiqueta3 = new JLabel("Indica tu codigo postal postal ");
        this.add(etiqueta3);
        JTextField nom3 = new JTextField(25);
        this.add(nom3);

        MouseListener click=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    if(nom1.getText().equals("")||nom2.getText().equals("")||nom3.getText().equals("")) throw new Exception();
                    else{
                        nom=nom1.getText();correo=nom2.getText(); codiPostal= Integer.parseInt(nom3.getText());
                        fin.setVisible(false);
                        etiqueta2.setVisible(false);etiqueta1.setVisible(false);etiqueta3.setVisible(false);
                        nom2.setVisible(false);nom1.setVisible(false);nom3.setVisible(false);
                        j.setText("Valores guardados correctamente");
                    }
                }catch(Exception exc){
                    j.setText("Todos los campos son obligatorios");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fin.setBackground(Color.PINK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                fin.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fin.setBackground(Color.PINK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fin.setBackground(Color.WHITE);
            }
        };

        fin.addMouseListener(click);
        panellBotons.updateUI();
    }

    private void pedirAlias() {
        //JPanel alias=new JPanel();
        JLabel mensajeAlias=new JLabel("Introduce tu alias");
        JButton fin= new JButton("Siguiente");
        fin.setBackground(Color.WHITE);
        JTextField introAlias=new JTextField(16);
        JLabel outAlias=new JLabel("");

        panellBotons.add(mensajeAlias); // Afegim els botons al panell
        panellBotons.add(introAlias);
        MouseListener click=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    nom=introAlias.getText();
                    if(nom.equals("marina")||nom.equals("")) throw new Exception();
                    fin.setVisible(false);
                    panellBotons.setVisible(false);
                    outAlias.setText("Alias correcto");
                }catch (Exception exc){
                    //System.out.println("");//sout+tab
                    outAlias.setText("Alias incorrecto, vuelve a probar");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fin.setBackground(Color.PINK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                fin.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fin.setBackground(Color.PINK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fin.setBackground(Color.WHITE);
            }
        };
        fin.addMouseListener(click);
        this.add(panellBotons);
        this.add(fin);
        this.add(outAlias);
        panellBotons.updateUI();
    }
    public void cambioUser(){
        this.add(new JLabel("Introduce el nuevo alias"), BorderLayout.NORTH);
        JButton fin= new JButton("Siguiente");
        fin.setBackground(Color.WHITE);
        JTextField introAlias=new JTextField(16);
        JLabel outAlias=new JLabel("");
        panellBotons.add(introAlias);
        MouseListener click=new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    nom=introAlias.getText();
                    if(nom.equals("marina")||nom.equals("")) throw new Exception();
                    fin.setVisible(false);
                    panellBotons.setVisible(false);
                    outAlias.setText("Alias correcto");
                }catch (Exception exc){
                    //System.out.println("");//sout+tab
                    outAlias.setText("Alias incorrecto, vuelve a probar");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fin.setBackground(Color.PINK);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                fin.setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fin.setBackground(Color.PINK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fin.setBackground(Color.WHITE);
            }
        };
        fin.addMouseListener(click);
        this.add(panellBotons);
        this.add(fin);
        this.add(outAlias);
        panellBotons.updateUI();
    }
}

