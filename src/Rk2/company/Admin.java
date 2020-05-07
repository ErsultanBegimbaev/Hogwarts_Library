package Rk2.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Admin  {
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static Socket socket;
    public static AdminMainFrame frame;


    public static void connectToServer(){
        try{
            socket=new Socket("127.0.0.1",777);
            outputStream=new ObjectOutputStream(socket.getOutputStream());
            inputStream=new ObjectInputStream((socket.getInputStream()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
           public static void addBook(BookDate b){
              StoreOfDates sd=new StoreOfDates();
              sd.setKindOfOperation("Add_Book");
              sd.setBook(b);
              try{
                   outputStream.writeObject(sd);
                  System.out.println("book written");
              }catch (Exception ex){
                  ex.printStackTrace();
              }
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
           public static void deleteByID(Long id){
              StoreOfDates sd=new StoreOfDates();
              sd.setKindOfOperation("Delete_Book");
              sd.setId(id);
                 try{
                   outputStream.writeObject(sd);
                 }catch (Exception e){
                     e.printStackTrace();
                 }
           }

     public static void showMainMenu(){
        Admin.frame.addBookPage.setVisible(false);
        Admin.frame.menu.setVisible(true);
        Admin.frame.adminListPage.setVisible(false);

     }

     public static void showAddbookPage(){
         Admin.frame.addBookPage.setVisible(true);
         Admin.frame.menu.setVisible(false);
         Admin.frame.adminListPage.setVisible(false);
     }

     public static void showListPage(){
         Admin.frame.addBookPage.setVisible(false);
         Admin.frame.menu.setVisible(false);
         Admin.frame.adminListPage.setVisible(true);
         ArrayList<BookDate> list = listBooks();
        // Admin.frame.listBooks.updateArea(list);
         Admin.frame.adminListPage.Table(list);
     }
     public static void showDeletePAge(){
        Admin.frame.addBookPage.setVisible(false);
        Admin.frame.menu.setVisible(false);
        Admin.frame.adminListPage.setVisible(false);
        Admin.frame.adminDeletePage.setVisible(true);
         ArrayList<BookDate> list = listBooks();
        Admin.frame.adminDeletePage.Table(list);

     }

    public static void main(String[] args) {
        connectToServer();
       frame=new AdminMainFrame();
       frame.setVisible(true);
    }
}
