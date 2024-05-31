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

    public  List findandpush(){
        int Bookid;
        Bookid=bookService.getBKid();
        String sql = "SELECT BookID, Bookname,Bookwriter,Bookdate FROM Books WHERE BookID =:bookid";
        Map<String,Object> map = new HashMap<>();
        map.put("bookid",Bookid);
        List  bookList = namedParameterJdbcTemplate.query(sql, map, new BookRowMapper());
        return bookList;
    }

}
