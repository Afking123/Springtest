package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class MyController {
    @Autowired
    private BookService bookService;
    @Autowired
    private Bookdao bookdao;
    @RequestMapping("/book/{bookid}")
    public List select(@PathVariable int bookid) {
        bookService.getbookid(bookid);
        return bookdao.findandpush();
    }

}