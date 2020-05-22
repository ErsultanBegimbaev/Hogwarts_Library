package Rk2.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class StudentForgotPage extends Container {
    JLabel background;

    JButton backbutton;
    JButton searchbutton;
    JButton retrivebutton;

    JTextField login;
    JTextField question;
    JTextField answer;
    JTextField password;
    ArrayList<Student> students=StudentConnectionbetween.listStudents();
    String Logo="";
    String Fac="";
    public StudentForgotPage(){
        setSize(770,433);
        setLayout(null);
        URL backurl=StudentForgotPage.class.getResource("icon/forgotpagelabel.jpg");
        ImageIcon backgroundicon=new ImageIcon(backurl);
        background=new JLabel("",backgroundicon,JLabel.CENTER);
        background.setBounds(0,0,770,433);

        login=new JTextField();
        login.setBounds(320,85,200,20);
        add(login);

        question=new JTextField();
        question.setBounds(320,135,200,20);
        add(question);

        answer=new JTextField();
        answer.setBounds(320,185,200,20);
        add(answer);

        password=new JTextField();
        password.setBounds(320,235,200,20);
        add(password);
        searchbutton=new JButton();
        URL sb=StudentForgotPage.class.getResource("icon/searchbutton.jpg");
        ImageIcon searchicon=new ImageIcon(sb);
        searchbutton.setBounds(555,75,100,35);
        searchbutton.setIcon(searchicon);
        add(searchbutton);
        searchbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){Search();}
        });

        retrivebutton=new JButton();
        URL rb=StudentForgotPage.class.getResource("icon/retrivebutton.jpg");
        ImageIcon retriveIcon=new ImageIcon(rb);
        retrivebutton.setBounds(555,185,100,35);
        retrivebutton.setIcon(retriveIcon);
        add(retrivebutton);
        retrivebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { Retrive();}
        });

        backbutton=new JButton();
        URL burl=StudentForgotPage.class.getResource("icon/backgreybutton.jpg");
        ImageIcon b=new ImageIcon(burl);
        backbutton.setBounds(555,330,100,40);
        backbutton.setIcon(b);
        add(backbutton);
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                StudentConnectionbetween.showStudentMenu();
                login.setText("");
                question.setText("");
                answer.setText("");
                password.setText("");
            }
        });

        add(background);
    }

    public void Search(){
        String faculty="";
       String text=login.getText();
       // System.out.println(text);

        for(int i=0;i<students.size();i++){
            if(students.get(i).getLogin().equals(text)){
                faculty=students.get(i).getFaculty();
                Logo=students.get(i).getLogin();
            }
        }
        if(faculty.equals("Gryffindor")){
            question.setText("Who is founder of Gryffindor?");

        }
        else if(faculty.equals("Slythering")){
            question.setText("Legendary wizard from Slythering?");
        }
        else if(faculty.equals("Ravenclaw")){
            question.setText("name of the faculty ghost?");
        }
        else if(faculty.equals("Hufflepuff")){
            question.setText("who killed Cedric Diggory?");
        }
          Fac=faculty;
    }

    public void Retrive(){
        for(int i=0;i<students.size();i++){
            if(answer.getText().equals("Godric Gryffindor") && students.get(i).getFaculty().equals("Gryffindor") && students.get(i).getLogin().equals(Logo)){
                password.setText(students.get(i).getPassword());
            }
            if(answer.getText().equals("Merlin") && students.get(i).getFaculty().equals("Slythering") && students.get(i).getLogin().equals(Logo)){
                password.setText(students.get(i).getPassword());
            }
            if(answer.getText().equals("grey lady") && students.get(i).getFaculty().equals("Ravenclaw") && students.get(i).getLogin().equals(Logo)){
                password.setText(students.get(i).getPassword());
            }
            if(answer.getText().equals("Volan de mort") && students.get(i).getFaculty().equals("Hufflepuff") && students.get(i).getLogin().equals(Logo)){
                password.setText(students.get(i).getPassword());
            }
        }
    }

}
