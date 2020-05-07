package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class AdminListPage extends Container {
    private JLabel background;
    private JTextArea Zona;

    JButton back;
    public AdminListPage(){
        setSize(555,700);
        setLayout(null);
        URL backurl=AdminMainMenu.class.getResource("icon/admenu.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,555,700);


        Zona = new JTextArea();
        Zona.setSize(500,400);
        Zona.setLocation(30,50);
        add(Zona);
/*
        ArrayList<BookDate> books;
        Zona.setText("");
        for(BookDate bd: books){
            Zona.append(bd+"\n");

        }*/

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
        add(background);
    }
        public void Table(ArrayList<BookDate> books) {
            Zona.setText("");
            for (BookDate bd : books) {
                Zona.append(bd + "\n");
            }
              }


        }