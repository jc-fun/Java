package com.urain.spring5.dao;

import com.urain.spring5.entity.Book;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/24 17:18
 * @description:
 * @version: 1.0
 */

public interface BookDAO {
    // 添加的方法
    void addBook(Book book);

    // 修改的方法
    void updateBook(Book book);

    // 删除的方法
    void deleteBook(String id);

    // 查询表记录数
    Integer selectCount();

    // 查询表中的一条记录
    public Book findBook(String id);

    // 查询表中的多条记录
    public List<Book> findBookList();

    // 批量添加
    void batchAddBook(List<Object[]> batchArgs);

    // 批量修改
    void batchUpdateBook(List<Object[]> batchArgs);

    // 批量删除
    void batchDeleteBook(List<Object[]> batchArgs);
}
