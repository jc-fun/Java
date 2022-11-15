package com.urain.book.controller;

import com.urain.book.pojo.Book;
import com.urain.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 8:23
 * @description:
 * @version: 1.0
 */
public class BookController {

    private BookService bookService;

    public String index(HttpSession session) {
        List<Book> bookList = bookService.getBookList();
        session.setAttribute("bookList", bookList);
        return "index";
    }
}
