package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class AdminMainMenu extends Container {


    JLabel background;

    JButton addbook;
    JButton listbook;
    JButton deletebook;
    JButton exit;
    public AdminMainMenu(){
        setSize(555,700);
        setLayout(null);
        URL backurl=AdminMainMenu.class.getResource("icon/admenu.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,555,700);

        addbook=new JButton();
        addbook.setBounds(195,200,150,50);
        URL ab=AdminMainMenu.class.getResource("icon/AddBookbuttonex.png");
        ImageIcon abicon=new ImageIcon(ab);
        addbook.setIcon(abicon);
        add(addbook);
        addbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showAddbookPage();
            }
        });

        listbook=new JButton();
        listbook.setBounds(195,270,150,50);
        URL lb=AdminMainMenu.class.getResource("icon/Listbookbuttonex.png");
        ImageIcon lbicon=new ImageIcon(lb);
        listbook.setIcon(lbicon);
        add(listbook);
           listbook.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   Admin.showListPage();
               }
           });

        deletebook=new JButton();
        deletebook.setBounds(195,340,150,50);
        URL db=AdminMainMenu.class.getResource("icon/deletebuttonex.png");
        ImageIcon dbicon=new ImageIcon(db);
        deletebook.setIcon(dbicon);
        add(deletebook);
        deletebook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Admin.showDeletePAge();
                JOptionPane.showMessageDialog(null, "Enter an id of book that you want to delete");
            }
        });
        exit=new JButton();
        exit.setBounds(195,410,150,50);
        URL ex=AdminMainMenu.class.getResource("icon/exitex.jpg");
        ImageIcon e=new ImageIcon(ex);
        exit.setIcon(e);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(background);
    }
}
