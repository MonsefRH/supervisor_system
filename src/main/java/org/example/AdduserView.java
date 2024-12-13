package org.example;

import java.awt.*;
import java.sql.SQLException;

public class AdduserView {
    Frame frame;
    Panel panel;
    Label l1;
    TextField NomField;
    TextField PrenomField;
    TextField EmailField;
    TextField PhoneField;
    Button InsertButton;

     public void  start() {
         frame = new Frame();
         panel = new Panel();
         frame.setTitle("Add User");
         l1 = new Label("Ajouter un nouveau membre ");
        NomField = new TextField(10);
        PrenomField = new TextField(10);
        EmailField = new TextField(10);
        PhoneField = new TextField(10);
        InsertButton = new Button("Inserer");
        InsertButton.addActionListener(e -> {
            if (NomField.getText().equals("") || PrenomField.getText().equals("") || EmailField.getText().equals("") || PhoneField.getText().equals("")) {
                System.out.println("Remplir tous les champs");
            }
            else {
                MembreDaoImpl md = new MembreDaoImpl();
                Member member = new Member(NomField.getText(), PrenomField.getText(), EmailField.getText(), PhoneField.getText());
                try{
                    md.insrer(member);
                }catch (SQLException sqlerror){
                    sqlerror.printStackTrace();
                }

            }
        });
        panel.add(l1);
        panel.add(NomField);
        panel.add(PrenomField);
        panel.add(EmailField);
        panel.add(PhoneField);
        panel.add(InsertButton);
        frame.add(panel);
         frame.setSize(400, 300);
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
     }
}
