package Rk2.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;


public class StudentMainMenu  extends Container {
    JTextField usertxt;
    JPasswordField passwordtxt;

    JButton loginbutton;
    JButton forgotbutton;
    JButton exitbutton;
    JButton  registr;

    JLabel background;
    URL  urlbackground;
    public  StudentMainMenu() {
         setSize(770, 456);
         setLayout(null);
//
              urlbackground=StudentMainMenu.class.getResource("icon/Background.jpg");
              ImageIcon back=new ImageIcon(urlbackground);
              background=new JLabel("",back,JLabel.CENTER);
              background.setBounds(0,0,770,456);
              add(background);
               //
              usertxt=new JTextField();
              usertxt.setBounds(270,131,160,25);
              add(usertxt);

              passwordtxt=new JPasswordField();
              passwordtxt.setBounds(270,225,160,25);
              add(passwordtxt);

       /*  ImageIcon loginicon;
         URL url=StudentMainMenu.class.getResource("8925.jpg");
         loginicon=new ImageIcon(url);
        exitbutton.setIcon(loginicon);*/
///////
       loginbutton=new JButton("");
       loginbutton.setBounds(185,290,150,50);
       ImageIcon loginicon;
       URL LOG=StudentMainMenu.class.getResource("icon/loginbutton.png");
       loginicon=new ImageIcon(LOG);
       loginbutton.setIcon(loginicon);
       add(loginbutton);
             loginbutton.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     ArrayList<Student> students=StudentConnectionbetween.listStudents();
                    for(int i=0;i<students.size();i++){

                          if(!students.get(i).getLogin().equals(usertxt.getText()) || !students.get(i).getPassword().equals(passwordtxt.getText())){
                            JOptionPane.showMessageDialog(null,"Wrong login or password","",JOptionPane.ERROR_MESSAGE);
                          }

                             if(students.get(i).getLogin().equals(usertxt.getText()) && students.get(i).getPassword().equals(passwordtxt.getText())){
                                 JOptionPane.showMessageDialog(null,"Welcome!");
                                 StudentConnectionbetween.Loginadd(students.get(i).getLogin());
                                 StudentConnectionbetween.showStudentPage();
                                 setVisible(false);
                                 usertxt.setText("");
                                 passwordtxt.setText("");
                                 String name=students.get(i).getName();
                                 String surname=students.get(i).getSurname();
                                 StudentOrderBookPage.addName(name);
                                 StudentOrderBookPage.addSurname(surname);
                             }

                    }

                 }
             });
       /////////////////////////////////////
          forgotbutton=new JButton();//signup burron
          forgotbutton.setBounds(365,290,150,50);
          URL fr=StudentMainMenu.class.getResource("icon/Signupbuttonex.png");
          ImageIcon forgoricon=new ImageIcon(fr);
          forgotbutton.setIcon(forgoricon);
          add(forgotbutton);
          forgotbutton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                    StudentConnectionbetween.showStudentRegistration();
              }
          });
          ////////////////////////////////////////////////////
          registr=new JButton();//forgot button
          registr.setBounds(280,345,150,50);
          URL rg=StudentMainMenu.class.getResource("icon/Forgoex.png");
          ImageIcon rgicon=new ImageIcon(rg);
          registr.setIcon(rgicon);
          add(registr);
          registr.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 StudentConnectionbetween.showForgotPage();
             }
         });

//////////////////////////////////////////////////////////
          exitbutton=new JButton();
          exitbutton.setBounds(625,355,80,50);
          URL exiturl=StudentMainMenu.class.getResource("icon/exitex.jpg");
          ImageIcon exiticon=new ImageIcon(exiturl);
          add(exitbutton);
          exitbutton.setIcon(exiticon);
          exitbutton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  System.exit(0);
              }
          });
        /////////////////////////////////////////////////////////////////////
        add(background);





    }
}
