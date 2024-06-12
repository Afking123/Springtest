package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookServicegetBody bookServicegetBody;
    @Autowired
    private Bookdao bookdao;
    @Autowired
    private FileUploadDao fileUploadDao;
    @Autowired
    private FileUploadService fileUploadService;

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
    @GetMapping("/")
    public String page(Model model){
        Test test = new Test();
        test.setStr("default");
        System.out.println(test.getStr());
        model.addAttribute("test", test);
        return "Firstpage";
    }
    @PostMapping("/2")
    public String page2(Model model){
        //System.out.println("yo");
        return "Secondpage";
    }
    @PostMapping("/fileupload")
    public String fileupload(@RequestParam("files") MultipartFile[] files ,RedirectAttributes redirectAttributes,Model model) {
        StringBuilder message = new StringBuilder();
        for (MultipartFile file : files) {
            fileUploadService.in(file, redirectAttributes);
            message.append(fileUploadDao.fileupload()).append("<br>");
        }
        model.addAttribute("message", message);
        return "Secondpage";
    }
}