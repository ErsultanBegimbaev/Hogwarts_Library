package Rk2.company;

import javax.swing.*;

public class StudentFrame extends JFrame {
    public static StudentMainMenu studentMainMenu;
    public static StudentRegistration studentRegistration;
    public static SPage sPage;
    public static StudentOrderBookPage studentOrderBookPage;
    public static StudentListPage studentListPage;
    public static StudentForgotPage studentForgotPage;
    public StudentFrame(){
        setTitle(" SFrame");
        setSize(770,456);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        studentMainMenu=new StudentMainMenu();
        studentMainMenu.setLocation(0,0);
         add(studentMainMenu);

         studentRegistration=new StudentRegistration();
         studentRegistration.setLocation(0,0);
         studentRegistration.setVisible(false);
         add(studentRegistration);

         sPage=new SPage();
         sPage.setLocation(0,0);
         sPage.setVisible(false);
         add(sPage);

         studentOrderBookPage=new StudentOrderBookPage();
         studentOrderBookPage.setLocation(0,0);
         studentOrderBookPage.setVisible(false);
         add(studentOrderBookPage);

         studentListPage=new StudentListPage();
         studentListPage.setLocation(0,0);
         studentListPage.setVisible(false);
         add(studentListPage);

         studentForgotPage=new StudentForgotPage();
         studentForgotPage.setLocation(0,0);
         studentForgotPage.setVisible(false);
         add(studentForgotPage);
      }

}
