package Rk2.company;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class StudentRegistration extends Container {
       JLabel background;
       URL backurl;

     JTextField logintxt;
     JTextField passwordtxt;
     JTextField nametxt;
     JTextField surnametxt;

     JComboBox facultis;
     JComboBox course;

     JButton confirm;
     JButton check;
     JButton backbutton;
    public StudentRegistration(){
        String[] faculty={"Gryffindor","Ravenclaw","Hufflepuff", "Slythering"};
        String[] grades={"1", "2", "3", "4"};
        setSize(770,456);//512 384
        setLayout(null);
        backurl=StudentRegistration.class.getResource("icon/Registration.jpg");
             ImageIcon  back=new ImageIcon(backurl);
             background=new JLabel("",back,JLabel.CENTER);
             background.setBounds(0,0,770,456);


             logintxt=new JTextField();
             logintxt.setBounds(300,110,200,20);
             add(logintxt);

             passwordtxt=new JTextField();
             passwordtxt.setBounds(300,150,200,20);
             add(passwordtxt);

             nametxt=new JTextField();
             nametxt.setBounds(300,190,200,20);
             add(nametxt);


             surnametxt=new JTextField();
             surnametxt.setBounds(300,230,200,20);
             add(surnametxt);

             facultis=new JComboBox(faculty);
             facultis.setBounds(300,270,200,20);
             add(facultis);

             course=new JComboBox(grades);
             course.setBounds(300,310,200,20);
             add(course);

             check=new JButton();
             URL ch=StudentRegistration.class.getResource("icon/checkisit.jpg");
             ImageIcon checkicon=new ImageIcon(ch);
             check.setBounds(520,100,100,40);
             check.setIcon(checkicon);
             add(check);
             check.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     Search();
                 }
             });
             confirm=new JButton();
             URL url=StudentRegistration.class.getResource("icon/Confirm.png");
             ImageIcon icon=new ImageIcon(url);
             confirm.setBounds(450,350,140,50);
             confirm.setIcon(icon);
             add(confirm);

             confirm.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      String Login=logintxt.getText();
                      String password=passwordtxt.getText();
                      String name=nametxt.getText();
                      String surname=surnametxt.getText();
                      String faculty=(String)facultis.getSelectedItem();
                      String grade=(String)course.getSelectedItem();
                      ArrayList<Student> students=StudentConnectionbetween.listStudents();

                      if(Login.equals("") ||password.equals("")|| name.equals("")||surname.equals("")){
                      JOptionPane.showMessageDialog(null,"fill empty spaces");
                      }
                      else if(!Login.equals("") ||!password.equals("")|| !name.equals("")||!surname.equals("")){
                             try {
                                 Student student=new Student(Login ,password ,name ,surname ,faculty ,grade);
                                 StudentConnectionbetween.addStudent(student);
                                 JOptionPane.showMessageDialog(null, "you just entered");
                             }catch (Exception ex){
                                 ex.printStackTrace();
                             }

                         }


                  }
              });

             backbutton=new JButton();
             URL burl=StudentRegistration.class.getResource("icon/backq.png");
             ImageIcon b=new ImageIcon(burl);
             backbutton.setBounds(150,350,140,50);
             backbutton.setIcon(b);
             add(backbutton);
             backbutton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        StudentConnectionbetween.showStudentMenu();
                        logintxt.setText("");
                        passwordtxt.setText("");
                        nametxt.setText("");
                        surnametxt.setText("");
                    }
                });
        add(background);
    }

    public void Search(){
        ArrayList<Student> students=StudentConnectionbetween.listStudents();
        int counter=0;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getLogin().equals(logintxt.getText())){
                counter++;
            }

        }
        if(counter>0){
            JOptionPane.showMessageDialog(null,"username is busy","",JOptionPane.ERROR_MESSAGE);
            logintxt.setText("");
            counter--;
        }
    }
}
