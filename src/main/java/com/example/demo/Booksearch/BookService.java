package com.example.demo.Booksearch;
import org.springframework.stereotype.Component;

@Component
public class BookService {
    private int BKid;
    public void getbookid(int id){
        this.BKid=id;
    }
    public int getBKid(){
        return BKid;
    }
}