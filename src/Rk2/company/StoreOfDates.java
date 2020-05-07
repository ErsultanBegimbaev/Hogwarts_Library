package Rk2.company;

import java.io.Serializable;
import java.util.ArrayList;

public class StoreOfDates implements Serializable {
      Long id;
      String  kindOfOperation;
      ArrayList<BookDate> books;
      ArrayList<Orders> orders;
      ArrayList<Student> students;
      BookDate book;
      Orders order;
      Student student;

    public  StoreOfDates(){

    }

    public StoreOfDates(Long id, String kindOfOperation, ArrayList<BookDate> books, ArrayList<Orders> orders, ArrayList<Student> students, BookDate book, Orders order, Student student) {
        this.id = id;
        this.kindOfOperation = kindOfOperation;
        this.books = books;
        this.orders = orders;
        this.students = students;
        this.book = book;
        this.order = order;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKindOfOperation() {
        return kindOfOperation;
    }

    public void setKindOfOperation(String kindOfOperation) {
        this.kindOfOperation = kindOfOperation;
    }

    public ArrayList<BookDate> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<BookDate> books) {
        this.books = books;
    }

    public ArrayList<Orders> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public BookDate getBook() {
        return book;
    }

    public void setBook(BookDate book) {
        this.book = book;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StoreOfDates{" +
                "id=" + id +
                ", kindOfOperation='" + kindOfOperation + '\'' +
                ", books=" + books +
                ", orders=" + orders +
                ", students=" + students +
                ", book=" + book +
                ", order=" + order +
                ", student=" + student +
                '}';
    }
}
