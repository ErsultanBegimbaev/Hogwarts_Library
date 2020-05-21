package Rk2.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class StudentConnectionbetween {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static StudentFrame frame;
    public static Socket socket;
    public static String accaunt=null;


    private static ArrayList<Student> students;

    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",777);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void showStudentRegistration(){
        StudentConnectionbetween.frame.studentRegistration.setVisible(true);
        StudentConnectionbetween.frame.studentMainMenu.setVisible(false);
        StudentConnectionbetween.frame.sPage.setVisible(false);
        StudentConnectionbetween.frame.studentOrderBookPage.setVisible(false);
        StudentConnectionbetween.frame.studentListPage.setVisible(false);
    }
    public static void showStudentMenu(){
        StudentConnectionbetween.frame.studentRegistration.setVisible(false);
        StudentConnectionbetween.frame.studentMainMenu.setVisible(true);
        StudentConnectionbetween.frame.sPage.setVisible(false);
        StudentConnectionbetween.frame.studentOrderBookPage.setVisible(false);
        StudentConnectionbetween.frame.studentListPage.setVisible(false);
    }
    public static void showStudentPage(){
        StudentConnectionbetween.frame.studentRegistration.setVisible(false);
        StudentConnectionbetween.frame.studentMainMenu.setVisible(false);
        StudentConnectionbetween.frame.sPage.setVisible(true);
        StudentConnectionbetween.frame.studentOrderBookPage.setVisible(false);
        StudentConnectionbetween.frame.studentListPage.setVisible(false);
    }
    public static void Loginadd(String login){ accaunt=login;}

    public static void showOrderBook(){
        StudentConnectionbetween.frame.studentRegistration.setVisible(false);
        StudentConnectionbetween.frame.studentMainMenu.setVisible(false);
        StudentConnectionbetween.frame.sPage.setVisible(false);
        StudentConnectionbetween.frame.studentOrderBookPage.setVisible(true);
        StudentConnectionbetween.frame.studentListPage.setVisible(false);
    }
    public static void showListPage(){
        StudentConnectionbetween.frame.studentRegistration.setVisible(false);
        StudentConnectionbetween.frame.studentMainMenu.setVisible(false);
        StudentConnectionbetween.frame.sPage.setVisible(false);
        StudentConnectionbetween.frame.studentOrderBookPage.setVisible(false);
        StudentConnectionbetween.frame.studentListPage.setVisible(true);
        ArrayList<Orders> table=Orderlist();
        StudentConnectionbetween.frame.studentListPage.Table(table);

    }


        public static void addStudent(Student student){
            StoreOfDates sd=new StoreOfDates();
            sd.setKindOfOperation("Add_Student");
            sd.setStudent(student);
              try {
                  outputStream.writeObject(sd);
                  System.out.println("added bro");

              }catch (Exception e){
                  e.printStackTrace();
              }
        }

              public static ArrayList<Student> listStudents(){
                ArrayList <Student> students=new ArrayList<>();
                StoreOfDates sd=new StoreOfDates();
                sd.setKindOfOperation("List_Students");
                sd.setStudents(students);
                       try {
                                outputStream.writeObject(sd);
                            if((sd=(StoreOfDates) inputStream.readObject() )!=null){
                                      students=sd.getStudents();
                                        for(Student aa: students){
                                          //  System.out.println(aa);
                                        }
                            }
                       }catch (Exception ex){

                       }
                            return students;
              }
    public static ArrayList<BookDate> listBooks(){
        ArrayList<BookDate> books=new ArrayList<>();
        StoreOfDates sd=new StoreOfDates();
        sd.setKindOfOperation("List_Books");
        sd.setBooks(books);
        try{
            outputStream.writeObject(sd);
            if((sd=(StoreOfDates) inputStream.readObject()) !=null){
                books=sd.getBooks();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return books;
    }
         public static void addOrder(Orders orders){
            StoreOfDates sd=new StoreOfDates();
              ArrayList<Orders>order=new ArrayList<>();
                 order.add(orders);
                 sd.setKindOfOperation("Borrow_Book");
                  sd.setOrders(order);
                   try{
                       outputStream.writeObject(sd);

                   }catch (Exception ex){
                       ex.printStackTrace();
                   }
         }
               public static ArrayList <Orders> Orderlist(){
                    ArrayList<Orders> orders=new ArrayList<>();
                     StoreOfDates sd=new StoreOfDates();
                     sd.setKindOfOperation("List_Order");
                     sd.setOrders(orders);
                     try{
                         outputStream.writeObject(sd);
                         if((sd=(StoreOfDates) inputStream.readObject()) !=null){
                                    orders=sd.getOrders();
                         }
                     }catch (Exception ex){
                         ex.printStackTrace();
                        // System.out.println("it is in sConnection");
                     }
                     return  orders;
               }





    public static void main(String[] args) {
        connectToServer();
        frame=new StudentFrame();
        frame.setVisible(true);
    }
}
