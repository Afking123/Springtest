package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.Model;


@Controller
public class MyController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookServicegetBody bookServicegetBody;
    @Autowired
    private Bookdao bookdao;

    @GetMapping("/book/{bookid}")
    public String select(Model model,@PathVariable int bookid) {
        bookService.getbookid(bookid);
        Test test = new Test();
        test.setStr(bookdao.booksearch().toString());
        //System.out.println(test.getStr());
        model.addAttribute("test", test);
        return "fragments :: testFragment";
    }
    @PutMapping ("/book/{bookid}")
    public String update(@PathVariable int bookid, @RequestBody List<Bookswithoutid> updateinfo,Model model){
        System.out.println("更新bookid"+bookid);
       bookServicegetBody.in(updateinfo);
       bookService.getbookid(bookid);
       bookdao.bookupdate();
        Test test = new Test();
        test.setStr("Bookid"+bookid+"已更新");
        model.addAttribute("test", test);
        return "fragments :: testFragment";
    }
    @RequestMapping(value ="/book/{bookid}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int bookid,Model model) {
        bookService.getbookid(bookid);
        bookdao.bookdelete();
        Test test = new Test();
        test.setStr("Bookid"+bookid+"已刪除");
        model.addAttribute("test", test);
        return "fragments :: testFragment";
    }
    @PostMapping(value ="/book/{bookid}")
    public String Create(@PathVariable int bookid, @RequestBody List<Bookswithoutid> updateinfo,Model model){
        System.out.println("新增bookid"+bookid);
        bookServicegetBody.in(updateinfo);
        bookService.getbookid(bookid);
        bookdao.bookinsert();
        Test test = new Test();
        test.setStr("Bookid"+bookid+"已新增");
        model.addAttribute("test", test);
        return "fragments :: testFragment";
    }
    @GetMapping("/1")
    public String page(Model model){
        Test test = new Test();
        test.setStr("default");
        //System.out.println(test.getStr());
        model.addAttribute("test", test);
        return "Firstpage";
    }
    @GetMapping("/2")
    public String page2(Model model){
        model.addAttribute("ko", "Hello World!!!");
        return "Secondpage";
    }

}