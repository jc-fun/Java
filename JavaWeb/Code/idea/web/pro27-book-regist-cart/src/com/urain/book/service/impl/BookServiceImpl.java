package com.urain.book.service.impl;

import com.urain.book.dao.BookDAO;
import com.urain.book.pojo.Book;
import com.urain.book.service.BookService;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 8:11
 * @description:
 * @version: 1.0
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;

    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
