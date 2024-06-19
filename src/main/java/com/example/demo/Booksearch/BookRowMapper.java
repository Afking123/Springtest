package com.example.demo.Booksearch;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BookRowMapper implements RowMapper <Books>{

    @Override
    public  Books mapRow(ResultSet rs, int rowNum) throws SQLException {        Books books = new Books();
        books.setBookid(rs.getInt("BookID"));
        books.setBookname(rs.getString("Bookname"));
        books.setBookwriter(rs.getString("Bookwriter"));
        books.setBookdate(rs.getDate("Bookdate"));
        return books;
    };
}
