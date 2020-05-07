package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class AdminDeletePage extends Container {
    private JLabel background;
    private JTextArea Zona;
    private JButton back;
    private JTextField Delete;
    private JButton deletebook;

    public AdminDeletePage(){
        setSize(555,700);
        setLayout(null);
        URL backurl=AdminMainMenu.class.getResource("icon/admenu.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,555,700);


////////////////////////////////////////////////////////////////////////////
        Zona = new JTextArea();
        Zona.setSize(500,400);
        Zona.setLocation(30,50);
        add(Zona);
       // JOptionPane.showMessageDialog(null, "Enter an id that you want to delete");

        ///////////////////////////////////////////////////////////////////////////
        back=new JButton();
        back.setBounds(350,500,130,55);
        URL burl=AdminAddBookPage.class.getResource("icon/backq.png");
        ImageIcon ba=new ImageIcon(burl);
        back.setIcon(ba);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Admin.showMainMenu();
            }
        });
        ////////////////////////////////////////////////////////

       Delete=new JTextField();
       Delete.setBounds(200,490,50,50);
       add(Delete);

        deletebook=new JButton();
        deletebook.setBounds(100,560,150,50);
        URL db=AdminMainMenu.class.getResource("icon/deletebuttonex.png");
        ImageIcon dbicon=new ImageIcon(db);
        deletebook.setIcon(dbicon);
        add(deletebook);
        deletebook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  Long id;
                  try{
                         id=Long.parseLong(Delete.getText());
                          Admin.deleteByID(id);
                          JOptionPane.showMessageDialog(null,"Open listpage to see changes");

                  }catch (Exception ex){
                      ex.printStackTrace();
                  }
            }
        });

        add(background);
    }

    public void Table(ArrayList<BookDate> books) {
        Zona.setText("");
        for (BookDate bd : books) {
            Zona.append(bd + "\n");
        }
    }

}
