package com.urain.book.service;

import com.urain.book.pojo.Book;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 8:10
 * @description:
 * @version: 1.0
 */
public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
}
