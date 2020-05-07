package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class StudentListPage extends Container {
    JLabel background;
    private JTextArea Zona;
    JButton back;
    public StudentListPage(){
        setSize(730,420);
        setLayout(null);
        URL backurl=AdminMainMenu.class.getResource("icon/studentmenu.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,730,420);

        Zona = new JTextArea();
        Zona.setBounds(50,30,400,300);

      //  Zona.setSize(500,400);
       // Zona.setLocation(30,50);
        add(Zona);


        back=new JButton();
        URL backbuttonurl=StudentOrderBookPage.class.getResource("icon/backq.png");
        ImageIcon buttonicon=new ImageIcon(backbuttonurl);
        back.setBounds(500,150,150,60);
        back.setIcon(buttonicon);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentConnectionbetween.showStudentPage();

            }
        });
        add(background);
    }


     public void Table(ArrayList<Orders> orders){
        Zona.setText("");
           for(Orders od: orders){
             Zona.append(od+"\n");
           }
     }
}
