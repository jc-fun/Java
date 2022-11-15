package com.urain.book.dao;

import com.urain.book.pojo.Book;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 8:03
 * @description:
 * @version: 1.0
 */
public interface BookDAO {
    List<Book> getBookList();
    Book getBook(Integer id);
}
