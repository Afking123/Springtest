package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListoBookwithoutid {
    @Autowired
    private Bookswithoutid books;
    public void  in(List<Bookswithoutid> info) {
        for (Bookswithoutid book : info){
            books.setBookname(book.getBookname())  ;
            books.setBookwriter(book.getBookwriter());
            books.setBookdate(book.getBookdate());
        }
    }
    public  Bookswithoutid out() {
        System.out.println("Book Name: " + books.getBookname());
        System.out.println("Book Writer: " + books.getBookwriter());
        System.out.println("Book Date: " + books.getBookdate());
        return books;
    }
}
