package com.urain.spring5.service;

import com.urain.spring5.dao.BookDAO;
import com.urain.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/24 17:18
 * @description:
 * @version: 1.0
 */

@Service
public class BookService {
    // 注入dao
    @Autowired
    private BookDAO bookDAO;

    // 添加的方法
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    // 修改的方法
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    // 删除的方法
    public void deleteBook(String id) {
        bookDAO.deleteBook(id);
    }

    // 查询表记录数
    public Integer findCount() {
        return bookDAO.selectCount();
    }

    // 查询表中的一条记录
    public Book findBook(String id) {
        return bookDAO.findBook(id);
    }

    // 查询表中的多条记录
    public List<Book> findBookList() {
        return bookDAO.findBookList();
    }

    // 批量添加
    public void batchAdd(List<Object[]> batchArgs) {
        bookDAO.batchAddBook(batchArgs);
    }

    // 批量修改
    public void batchUpdateBook(List<Object[]> batchArgs) {
        bookDAO.batchUpdateBook(batchArgs);
    }

    // 批量删除
    public void batchDeleteBook(List<Object[]> batchArgs) {
        bookDAO.batchDeleteBook(batchArgs);
    }
}
