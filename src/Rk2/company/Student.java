package Rk2.company;

import java.io.Serializable;

public class Student implements Serializable {

  private String login;
  private String password;
  private String Name;
  private String Surname;
  private  String faculty;
  private  String course;
    private long id;
    public Student(){

    }

    public Student( String login, String password, String name, String surname, String faculty, String course,long id) {
        this.login = login;
        this.password = password;
        Name = name;
        Surname = surname;
        this.faculty = faculty;
        this.course = course;
        this.id = id;
    }

    public Student(String login, String password, String name, String surname, String faculty, String course) {
        this.login = login;
        this.password = password;
        Name = name;
        Surname = surname;
        this.faculty = faculty;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
