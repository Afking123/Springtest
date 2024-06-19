package com.example.demo.Booksearch;

import org.springframework.stereotype.Component;

@Component
public class Bookswithoutid {
    private String Bookname;
    private String Bookwriter;
    private String Bookdate;
    public String getBookname() {
        return Bookname;
    }
    public void setBookname(String bookname) {
        Bookname = bookname;
    }
    public String getBookwriter() {
        return Bookwriter;
    }
    public void setBookwriter(String bookwriter) {
        Bookwriter = bookwriter;
    }
    public String getBookdate() {
        return Bookdate;
    }
    public void setBookdate(String bookdate) {
        Bookdate = bookdate;
    }
}
