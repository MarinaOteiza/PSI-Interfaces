package Interfaces;

import dataUsr.LlistaUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Main.*;

public class CambioUser extends JFrame{
    private String nom;
    private JPanel panellBotons = new JPanel();

    public CambioUser(LlistaUser llista){
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        panellBotons.setLayout(new FlowLayout());
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
                    if(!llista.usuarioRegistrado(nom)||nom.equals("")) throw new Exception();
                    fin.setVisible(false);
                    panellBotons.setVisible(false);
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
        new Main(llista, nom);
    }
}
