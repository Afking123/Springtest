package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServicegetBody {
    private Bookswithoutid bodybooks;
    @Autowired
    private ListoBookwithoutid listtobook;
    public void in(List<Bookswithoutid> info) {
       listtobook.in(info);
       bodybooks=listtobook.out();
    }
    public Bookswithoutid out() {
        return bodybooks;
    }
}
