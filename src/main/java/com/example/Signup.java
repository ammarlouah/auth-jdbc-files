package com.example;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;

public class Signup extends Frame implements WindowListener,ActionListener{
    TextField nom = new TextField(12);
    TextField prenom = new TextField(12);
    TextField cne = new TextField(12);
    TextField appoge = new TextField(12);
    Label res = new Label();
    Label ln = new Label("Nom");
    Label lp = new Label("Prenom");
    Label lc = new Label("CNE");
    Label la = new Label("Appoge");
    Button sub = new Button("Submit");
    FlowLayout fl = new FlowLayout();
    Signup(String title){
        super(title);
        setLayout(fl);
        add(ln);
        add(nom);
        add(lp);
        add(prenom);
        add(lc);
        add(cne);
        add(la);
        add(appoge);
        add(sub);
        add(res);
        sub.addActionListener(this);
        addWindowListener(this); 
    }

    @Override
    public void actionPerformed(ActionEvent e){
        boolean test;
        if(e.getSource() == sub){
            try {
                test = Crud.insertEtud(Integer.parseInt(appoge.getText()), cne.getText(), nom.getText(), prenom.getText());
                if(test){
                    WriteFile.write(appoge.getText(), cne.getText(), nom.getText(), prenom.getText());
                    res.setText("Success");
                    res.setSize(90,90);
                    res.setBackground(Color.GREEN);
                }else{
                    res.setText("Echec");
                    res.setSize(90,90);
                    res.setBackground(Color.RED);
                }
            } catch (SQLException| IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public void windowActivated(WindowEvent e) {}    
    public void windowClosed(WindowEvent e) {}    
    public void windowClosing(WindowEvent e) {    
        dispose();    
    }    
    public void windowDeactivated(WindowEvent e) {}    
    public void windowDeiconified(WindowEvent e) {}    
    public void windowIconified(WindowEvent e) {}    
    public void windowOpened(WindowEvent arg0) {} 
}
