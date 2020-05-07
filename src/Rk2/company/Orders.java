package Rk2.company;

import java.io.Serializable;

public class Orders implements Serializable {
    private Long id;
    private String bookId;
    private String name;
    private String surname;

    public Orders(){

    }
    public Orders(Long id, String bookId, String name, String surname) {
        this.id = id;
        this.bookId = bookId;
        this.name = name;
        this.surname = surname;
    }

    public Orders(String bookId, String name, String surname) {
        this.bookId = bookId;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}



