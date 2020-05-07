package Rk2.company;

import javax.swing.*;

public class AdminMainFrame extends JFrame {
     public static AdminMainMenu menu;
     public static AdminAddBookPage addBookPage;
     public static AdminListPage adminListPage;
     public static AdminDeletePage adminDeletePage;
     public AdminMainFrame(){
         setTitle("AdminFrame");
         setSize(555,700);
         setLayout(null);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setLocationRelativeTo(null);

         menu=new AdminMainMenu();
         menu.setLocation(0,0);
         add(menu);

         addBookPage=new AdminAddBookPage();
         addBookPage.setLocation(0,0);
         addBookPage.setVisible(false);
         add(addBookPage);

         adminListPage=new AdminListPage();
         adminListPage.setLocation(0,0);
         adminListPage.setVisible(false);
         add(adminListPage);

         adminDeletePage=new AdminDeletePage();
         adminDeletePage.setLocation(0,0);
         adminDeletePage.setVisible(false);
         add(adminDeletePage);
     }
}
