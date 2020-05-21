package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class AdminAddBookPage extends Container {
    JLabel background;

    JTextField booID;
    JTextField title;
    JTextField author;
    JTextField data;

    JButton confirm;
    JButton back;
    public  AdminAddBookPage(){
        setLayout(null);
        setSize(700, 700);
        setSize(555,700);
        setLayout(null);
        URL backurl=AdminMainMenu.class.getResource("icon/adbookpage.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,555,700);

        booID=new JTextField();
        booID.setBounds(220,245,200,40);
        add(booID);

        title=new JTextField();
        title.setBounds(220,290,200,40);
        add(title);

        author=new JTextField();
        author.setBounds(220,340,200,40);
        add(author);

        data=new JTextField();
        data.setBounds(220,385,200,40);
        add(data);

        confirm=new JButton();
        confirm.setBounds(350,440,130,55);
        URL curl=AdminAddBookPage.class.getResource("icon/Confirm.png");
        ImageIcon cicon=new ImageIcon(curl);
        confirm.setIcon(cicon);
        add(confirm);
         confirm.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                     try{
                         BookDate book=new BookDate(booID.getText(), title.getText(), author.getText(), data.getText(), null);
                         Admin.addBook(book);
                         JOptionPane.showMessageDialog(null,"InsertedBook");
                     }catch (Exception ex){
                         ex.printStackTrace();
                     }


             }
         });


        back=new JButton();
        back.setBounds(185,440,130,55);
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
}
