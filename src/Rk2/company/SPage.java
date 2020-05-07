package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SPage extends Container {
    JLabel background;

    JButton add;
    JButton list;
    JButton back;
    public SPage(){
        setSize(730,420);
        setLayout(null);
        URL backurl=AdminMainMenu.class.getResource("icon/studentmenu.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,730,420);

        add=new JButton();
        URL addurl=SPage.class.getResource("icon/orderbook.png");
        ImageIcon addicon=new ImageIcon(addurl);
        add.setBounds(240,130,180,60);
        add.setIcon(addicon);
        add(add);
         add.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 StudentConnectionbetween.showOrderBook();
             }
         });
        list=new JButton();
        URL listurl=SPage.class.getResource("icon/liststud.png");
        ImageIcon listicon=new ImageIcon(listurl);
        list.setBounds(240,200,180,60);
        list.setIcon(listicon);
        add(list);
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentConnectionbetween.showListPage();
            }
        });



        back=new JButton();
        URL backicon=SPage.class.getResource("icon/backq.png");
        ImageIcon backbuttonicon=new ImageIcon(backicon);
         back.setBounds(240,280,180,60);
         back.setIcon(backbuttonicon);
         add(back);
         back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 StudentConnectionbetween.showStudentMenu();
             }
         });
       add(background);
    }
}
