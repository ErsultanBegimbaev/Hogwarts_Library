package Rk2.company;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.print.Book;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
    public static Long id = null;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        @Override
       public void run(){
              try{
                  StoreOfDates store=null;
                   while ((store = (StoreOfDates) inputStream.readObject()) !=null){///whilestarts
                      if(store.getKindOfOperation().equals("Add_Student")){
                         try{
                                 Student student=store.getStudent();
                                    AddStudentintoDataBase(student);
                         }catch (Exception e){
                             e.printStackTrace();
                         }
                      }
                          else if(store.getKindOfOperation().equals("List_Students")){//for login to account
                                 ArrayList<Student> students=getAllStudents();
                                 StoreOfDates st=new StoreOfDates();
                                  st.setStudents(students);
                                  outputStream.writeObject(st);
                      } else if(store.getKindOfOperation().equals("Add_Book")){//
                                try {
                                    BookDate book=store.getBook();
                                           addBookInDB(book);

                                }catch (Exception ex){
                                    ex.printStackTrace();
                                }
                      }
                        else if(store.getKindOfOperation().equals("List_Books")){//
                                      ArrayList<BookDate> books=getBooks();
                                      StoreOfDates sd=new StoreOfDates();
                                       sd.setBooks(books);
                                       outputStream.writeObject(sd);
                      } else if(store.getKindOfOperation().equals("Delete_Book")){//
                                        Long id=store.getId();
                                        deleteBook(id);

                      } else if(store.getKindOfOperation().equals("Borrow_Book")){
                                  Orders orders=store.getOrders().get(0);
                                        addOrderToDB(orders);
                      }else  if(store.getKindOfOperation().equals("List_Order")){
                        ArrayList<Orders> orders=getOrderList();
                          StoreOfDates sdot=new StoreOfDates();
                          sdot.setOrders(orders);
                          outputStream.writeObject(sdot);

                      }

                      ///whileend
                  }

              }catch (Exception ex){
                  ex.printStackTrace();
              }
       }



       public void AddStudentintoDataBase(Student student){
                     try{

                         PreparedStatement statement=connection.prepareStatement("insert into studentdata (id, Login, password, Name, Surname, faculty, course) values (null, ?,?,?,?,?,?)");
                                statement.setString(1,student.getLogin());
                                statement.setString(2,student.getPassword());
                                statement.setString(3,student.getName());
                                statement.setString(4,student.getSurname());
                                statement.setString(5,student.getFaculty());
                                statement.setString(6,student.getCourse());
                             statement.executeUpdate();
                               statement.close();
                       //  JOptionPane.showMessageDialog(null,"student inserted into DB");

                     }catch (Exception ex){
                         ex.printStackTrace();
                     }
       }
                public ArrayList<Student> getAllStudents(){
                            ArrayList<Student> list=new ArrayList<>();
                             try{
                                   PreparedStatement statement=connection.prepareStatement("select * from studentdata");
                                       ResultSet resultSet=statement.executeQuery();
                                      while( resultSet.next()){
                                                 String login=resultSet.getString("Login");
                                                 String password=resultSet.getString("password");
                                                 String name=resultSet.getString("Name");
                                                 String surname=resultSet.getString("Surname");
                                                 String fac=resultSet.getString("faculty");
                                                 String course=resultSet.getString("course");
                                                 Long id=resultSet.getLong("id");
                                                 list.add(new Student(login,password,name,surname,fac,course,id));
                                      }
                                       statement.close();
                             }catch (Exception ex){
                                 ex.printStackTrace();
                             }
                             return list;
                }
                    public void addBookInDB(BookDate book){
                          try {
                               PreparedStatement statement=connection.prepareStatement("insert into books(id, bookID, title, author, data) values (null, ?,?,?,?)");
                                      statement.setString(1,book.getBookId());
                                      statement.setString(2,book.getTitle());
                                      statement.setString(3,book.getAuthor());
                                      statement.setString(4,book.getData());
                                            statement.executeUpdate();
                                            //JOptionPane.showMessageDialog(null,"book is inserted into DB");
                              System.out.println("inserted");
                           }catch (Exception ex){
                          ex.printStackTrace();
                     }
                    }

                        public ArrayList<BookDate> getBooks(){
                                  ArrayList<BookDate> books=new ArrayList<>();
                                try{
                                         Statement statement=connection.createStatement();
                                          String query="Select * from books";
                                          ResultSet resultSet=statement.executeQuery(query);
                                             while (resultSet.next()){
                                                      Long id=resultSet.getLong("id");
                                                      String bookid=resultSet.getString("bookID");
                                                      String title=resultSet.getString("title");
                                                      String author=resultSet.getString("author");
                                                      String data=resultSet.getString("data");
                                                          books.add(new BookDate( bookid, title, author, data, id));

                                             }
                                                    statement.close();

                                }catch (Exception ex){
                                    ex.printStackTrace();
                                }
                                return books;
                        }
                        public void deleteBook(Long id){
                                try{
                                         PreparedStatement statement=connection.prepareStatement("Delete  from books where id=?");
                                         statement.setLong(1,id);
                                         int rows=statement.executeUpdate();

                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                        }
                        public void addOrderToDB(Orders orders){
                                try{
                                     PreparedStatement statement=connection.prepareStatement("insert into orders(id,bookId,name,surname) values(null,?,?,?)");
                                             statement.setString(1,orders.getBookId());
                                             statement.setString(2,orders.getName());
                                             statement.setString(3,orders.getSurname());
                                                statement.executeUpdate();

                                }catch (Exception ex){
                                    ex.printStackTrace();
                                }
                        }
                        public ArrayList<Orders> getOrderList(){
                               ArrayList <Orders> orders=new ArrayList<>();
                               try{
                                   Statement statement=connection.createStatement();
                                      String query="Select * from orders";
                                       ResultSet resultSet=statement.executeQuery(query);
                                       while (resultSet.next()){
                                           Long id=resultSet.getLong("id");
                                           String bookid=resultSet.getString("bookID");
                                           String name=resultSet.getString("name");
                                           String surname=resultSet.getString("surname");
                                            orders.add(new Orders(id, bookid,name,surname));
                                           //System.out.println(" ordered ");
                                       }
                                       statement.close();
                               }catch (Exception ex){
                                   ex.printStackTrace();
                               }
                               return orders;
                        }
    }