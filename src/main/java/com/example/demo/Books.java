package com.example.demo;

import java.util.Date;

public class Books {
    private int Bookid;
    private String Bookname;
    private String Bookwriter;
    private Date Bookdate;
    public int getBookid() {
        return Bookid;
    }
    public void setBookid(int bookid) {
        Bookid = bookid;
    }
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
    public Date getBookdate() {
        return Bookdate;
    }
    public void setBookdate(Date bookdate) {
        Bookdate = bookdate;
    }
    @Override
    public String toString() {
        return
                "BookID=" + Bookid +
                ", Bookname='" + Bookname + '\'' +
                ", Bookwriter='" + Bookwriter + '\'' +
                ", Bookdate=" + Bookdate ;
    }
}
