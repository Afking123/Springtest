package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
@RestController
public class Bookdao {
    @Autowired
    private BookService bookService;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private BookServicegetBody serviceget;

    public  List booksearch(){
        int Bookid;
        Bookid=bookService.getBKid();
        String sql = "SELECT BookID, Bookname,Bookwriter,Bookdate FROM Books WHERE BookID =:bookid";
        Map<String,Object> map = new HashMap<>();
        map.put("bookid",Bookid);
        List  bookList = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());
        return bookList;
    }
    public void bookupdate(){
        int Bookid;
        String Bookname;
        String Bookwriter;
        String Bookdate;
        Bookid=bookService.getBKid();
        Bookname=serviceget.out().getBookname();
        Bookwriter=serviceget.out().getBookwriter();
        Bookdate=serviceget.out().getBookdate();
        String sql = "UPDATE Books SET bookname = :bookname, bookwriter = :bookwriter, bookdate = :bookdate WHERE BookID = :bookid";
        Map<String,Object> map = new HashMap<>();
        map.put("bookid",Bookid);
        map.put("bookdate",Bookdate);
        map.put("bookwriter",Bookwriter);
        map.put("bookname",Bookname) ;
        namedParameterJdbcTemplate.update(sql, map);
    }
    public void bookdelete(){
        int Bookid;
        Bookid=bookService.getBKid();
        String sql = "DELETE FROM Books WHERE BookID = :bookid";
        Map<String,Object> map = new HashMap<>();
        map.put("bookid",Bookid);
        namedParameterJdbcTemplate.update(sql, map);
    }
    public void bookinsert(){
        int Bookid;
        String Bookname;
        String Bookwriter;
        String Bookdate;
        Bookid=bookService.getBKid();
        Bookname=serviceget.out().getBookname();
        Bookwriter=serviceget.out().getBookwriter();
        Bookdate=serviceget.out().getBookdate();
        String sql = "INSERT INTO Books VALUES(:bookid, :bookname, :bookwriter, :bookdate)";
        Map<String,Object> map = new HashMap<>();
        map.put("bookid",Bookid);
        map.put("bookdate",Bookdate);
        map.put("bookwriter",Bookwriter);
        map.put("bookname",Bookname) ;
        namedParameterJdbcTemplate.update(sql, map);
    }

}
