package com.example;
import java.awt.*;
import java.awt.event.*;

public class Login extends Frame implements WindowListener,ActionListener{
    TextField cne = new TextField(12);
    TextField appoge = new TextField(12);
    Label lc = new Label("CNE : ");
    Label la = new Label("appoge : ");
    Button sub = new Button("Check");
    Label res = new Label();
    FlowLayout fl = new FlowLayout();
    Login(String title){
        super(title);
        setLayout(fl);
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
        if(e.getSource()==sub){
            try {
                test = Crud.selectEtud(Integer.parseInt(appoge.getText()), cne.getText());
                if(test){
                    WriteFile.write(appoge.getText(), cne.getText());
                    res.setText("Success");
                    res.setSize(90,90);
                    res.setBackground(Color.GREEN);
                }else{
                    res.setText("Echec");
                    res.setSize(90,90);
                    res.setBackground(Color.RED);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
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
