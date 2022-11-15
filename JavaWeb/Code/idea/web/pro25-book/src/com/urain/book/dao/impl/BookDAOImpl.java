package com.urain.book.dao.impl;

import com.urain.book.dao.BookDAO;
import com.urain.book.pojo.Book;
import com.urain.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 8:06
 * @description:
 * @version: 1.0
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return executeQuery("select * from t_book where bookStatus = 0");
    }

    @Override
    public Book getBook(Integer id) {
        return load("select * from t_book where id = ?", id);
    }
}
