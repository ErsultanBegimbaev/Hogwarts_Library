package Rk2.company;

import java.io.Serializable;

public class BookDate implements Serializable {

     private String bookId;
     private String title;
     private String author;
     private  String data;
    private Long id;

public BookDate(){

}
    public BookDate(String bookId, String title, String author, String data, Long id ) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.data = data;
        this.id = id;
    }

    public BookDate(String bookId, String title, String author, String data) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.data = data;
    }

    public BookDate(String text, String text1, String text2, String text3, Object id) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BookDate{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
