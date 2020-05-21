package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class StudentOrderBookPage extends Container {
    public static String name;
    public static String surname;
    JLabel background;

    JButton take;
    JButton back;
    public StudentOrderBookPage(){
        setSize(730,420);
        setLayout(null);
        URL backurl=AdminMainMenu.class.getResource("icon/studentmenu.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,730,420);

          BookDate[]books=null;
        ArrayList<BookDate>list=StudentConnectionbetween.listBooks();
        books=list.toArray(new BookDate[list.size()]);

            JComboBox comboBox=new JComboBox(books);
            comboBox.setBounds(230,130,350,20);
            add(comboBox);

            take=new JButton();
            URL takeurl=StudentOrderBookPage.class.getResource("icon/orderbook.png");
            ImageIcon ticon=new ImageIcon(takeurl);
            take.setBounds(230,180,150,60);
            take.setIcon(ticon);
            add(take);
            take.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     BookDate thatbook=(BookDate) comboBox.getSelectedItem();
                     Orders orders=new Orders(null, thatbook.getBookId(),name,surname);
                     StudentConnectionbetween.addOrder(orders);
                     JOptionPane.showMessageDialog(null,"book ordered  successfully look at orderlist bellow");
                }
            });


            back=new JButton();
            URL backbuttonurl=StudentOrderBookPage.class.getResource("icon/backq.png");
            ImageIcon buttonicon=new ImageIcon(backbuttonurl);
            back.setBounds(230,230,150,60);
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

        public  static void addName(String n){
          name=n;
        }
        public static void addSurname(String n){
        surname=n;
        }

}
