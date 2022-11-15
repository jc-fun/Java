package com.urain.spring5.dao.impl;

import com.urain.spring5.dao.BookDAO;
import com.urain.spring5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/24 17:18
 * @description:
 * @version: 1.0
 */

@Repository
public class BookDAOImpl implements BookDAO {

    // 注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加的方法
    @Override
    public void addBook(Book book) {
        // 创建sql语句
        String sql = "insert into t_book values(?, ?, ?, ?)";
        // 调用方法实现
        Object[] args = {book.getUserId(), book.getUsername(), book.getUstatus(), book.getPubDate()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }

    // 修改
    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set username = ?, ustatus = ?, pub_date = ? where user_id = ?";
        int update = jdbcTemplate.update(sql, book.getUsername(), book.getUstatus(), book.getPubDate(), book.getUserId());
        System.out.println(update);

    }

    // 删除
    @Override
    public void deleteBook(String id) {
        String sql = "delete from t_book where user_id = ?";
        int update = jdbcTemplate.update(sql, id);
        System.out.println(update);
    }

    // 查询表中的记录数
    @Override
    public Integer selectCount() {
        String sql = "select count(*) from t_book";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    // 查询表中的一条记录
    @Override
    public Book findBook(String id) {
        // 调用方法
        try {
            String sql = "select * from t_book where user_id = ?";
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
        } catch (DataAccessException e) {
            return null;
        }
    }

    // 查询表中的多条记录
    @Override
    public List<Book> findBookList() {
        try {
            String sql = "select * from t_book";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
        } catch (DataAccessException e) {
            return null;
        }
    }

    // 批量添加
    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?, ?, ?, ?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints.length);
    }

    // 批量修改
    @Override
    public void batchUpdateBook(List<Object[]> batchArgs) {
        String sql = "update t_book set username = ?, ustatus = ?, pub_date = ? where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints.length);
    }

    @Override
    public void batchDeleteBook(List<Object[]> batchArgs) {
        String sql = "delete from t_book where user_id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints.length);

    }
}

